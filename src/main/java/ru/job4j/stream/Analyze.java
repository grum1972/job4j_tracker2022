package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .map(pupil -> pupil.subjects())
                .flatMap(subjects -> subjects.stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(tuple -> new Tuple(tuple.name(), Stream
                        .of(tuple.subjects())
                        .flatMap(subjects -> subjects.stream())
                        .mapToInt(Subject::score)
                        .average()
                        .orElse(0D)))
                .collect(Collectors.toList());

    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        Map<String, Double> map = stream
                .map(pupil -> pupil.subjects())
                .flatMap(subjects -> subjects.stream())
                .collect(groupingBy(Subject::name, LinkedHashMap::new, averagingDouble(Subject::score)));
        return map.entrySet().stream()
                .map(tuple -> new Tuple(tuple.getKey(), tuple.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(tuple -> new Tuple(tuple.name(), Stream
                .of(tuple.subjects())
                .flatMap(subjects -> subjects.stream())
                .mapToInt(Subject::score)
                .sum()))
                .max(Comparator.comparing(Tuple::score))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        Map<String, Double> map = stream
                .map(pupil -> pupil.subjects())
                .flatMap(subjects -> subjects.stream())
                .collect(groupingBy(Subject::name, LinkedHashMap::new, summingDouble(Subject::score)));
        return map.entrySet().stream()
                .map(tuple -> new Tuple(tuple.getKey(), tuple.getValue()))
                .max(Comparator.comparing(Tuple::score))
                .orElse(null);
    }
}

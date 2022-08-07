package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .map(Pupil::subjects)
                .flatMap(subjects -> subjects.stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(tuple -> new Tuple(tuple.name(), tuple.subjects()
                        .stream()
                        .mapToInt(Subject::score)
                        .average()
                        .orElse(0D)))
                .collect(Collectors.toList());

    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(Pupil::subjects)
                .flatMap(subjects -> subjects.stream())
                .collect(groupingBy(Subject::name, LinkedHashMap::new, averagingDouble(Subject::score)))
                .entrySet().stream()
                .map(tuple -> new Tuple(tuple.getKey(), tuple.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(tuple -> new Tuple(tuple.name(), tuple.subjects()
                        .stream()
                        .mapToInt(Subject::score)
                        .sum()))
                .max(Comparator.comparing(Tuple::score))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .map(Pupil::subjects)
                .flatMap(subjects -> subjects.stream())
                .collect(groupingBy(Subject::name, summingDouble(Subject::score)))
                .entrySet().stream()
                .map(tuple -> new Tuple(tuple.getKey(), tuple.getValue()))
                .max(Comparator.comparing(Tuple::score))
                .orElse(null);
    }
}

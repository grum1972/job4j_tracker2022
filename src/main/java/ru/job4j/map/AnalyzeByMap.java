package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int sum = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        return sum / (double) count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {

        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            rsl.add(new Label(pupil.name(), sum / (double) pupil.subjects().size()));
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {

        List<Label> rsl = new ArrayList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (map.containsKey(subject.name())) {
                    int tempScore = map.get(subject.name());
                    map.put(subject.name(), subject.score() + tempScore);
                } else {
                    map.put(subject.name(), subject.score());
                }
            }
        }
        for (String key : map.keySet()) {
            rsl.add(new Label(key, map.get(key) / (double) pupils.size()));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            rsl.add(new Label(pupil.name(), sum));
        }
        Collections.sort(rsl);
        return rsl.get(rsl.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (map.containsKey(subject.name())) {
                    int tempScore = map.get(subject.name());
                    map.put(subject.name(), subject.score() + tempScore);
                } else {
                    map.put(subject.name(), subject.score());
                }
            }
        }
        for (String key : map.keySet()) {
            rsl.add(new Label(key, map.get(key)));
        }
        Collections.sort(rsl);
        return rsl.get(rsl.size() - 1);
    }
}

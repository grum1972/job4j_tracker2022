package ru.job4j.collection;

import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<>();
        autos.add("Auto1");
        autos.add("Auto2");
        autos.add("Auto1");
        autos.add("Auto3");
        for (String auto :autos) {
            System.out.println(auto);
        }
    }
}

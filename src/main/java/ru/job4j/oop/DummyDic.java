package ru.job4j.oop;

public class DummyDic {
    public static void main(String[] args) {
        DummyDic dummyDic = new DummyDic();
        System.out.println(dummyDic.engToRus("word"));
    }

    private String engToRus(String word) {
        return "Unknown word: " + word;
    }
}

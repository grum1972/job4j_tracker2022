package ru.job4j.poly;

public interface Transport {
    void move();

    void passengers(int passengers);

    int load(int quantity);

}

package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Автобус поехал");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Я везу : " + passengers + " пассажиров !");
    }

    @Override
    public int load(int quantity) {
        final int PRICE_FOR_LITER = 40;
        return quantity * PRICE_FOR_LITER;
    }
}

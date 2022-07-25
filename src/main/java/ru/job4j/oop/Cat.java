package ru.job4j.oop;

public class Cat {
    String food;
    String name;

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.giveNick("Gav");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.eat("fish");
        black.giveNick("Black");
        black.show();
    }

    private void giveNick(String name) {
        this.name = name;
    }

    private void show() {
        System.out.println("Cat :" + this.name + " eat " + this.food);
    }

    private void eat(String meat) {
        this.food = meat;
    }
}

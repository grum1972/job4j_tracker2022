package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public static void main(String[] args) {
        Error err1 = new Error();
        Error err2 = new Error(true, 1, "This is error!");
        err1.info();
        err2.info();
    }

    private void info() {
        System.out.println("Active: " + this.active);
        System.out.println("Status: " +  this.status);
        System.out.println("Message: " + this.message);
    }
}

package ru.job4j.oop;

public class VehicleUsage {
    public static void main(String[] args) {
        Bus bus = new Bus();
        Train train = new Train();
        Airplane airplane = new Airplane();
        Vehicle[] vehicles = {bus, train, airplane};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}

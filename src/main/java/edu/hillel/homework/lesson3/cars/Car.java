package edu.hillel.homework.lesson3.cars;

public class Car {

    public void start() {
        startElectricity();
        startCommand();
        startFuelSystem();
    }

    private void startElectricity() {
        System.out.println("Starting car electricity system...");
    }

    private void startCommand() {
        System.out.println("Starting car command system...");
    }

    private void startFuelSystem() {
        System.out.println("Starting car fuel system...");
    }
}

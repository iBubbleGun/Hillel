package edu.hillel.homework.lesson17.ball_factory.storage;

import edu.hillel.homework.lesson17.ball_factory.Ball;

public class Football extends Ball {

    private static final float ballDiameter = 22.28f;
    private static final String kindOfSport = "Football";

    public Football(int serialNumber) {
        super(ballDiameter, kindOfSport, serialNumber);
    }

    @Override
    public void play() {
        System.out.println("Let's play football (ball serial number = " + super.getSerialNumber() + ")");
    }
}

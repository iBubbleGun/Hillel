package edu.hillel.homework.lesson17.ball_factory.storage;

import edu.hillel.homework.lesson17.ball_factory.Ball;

public class Basketball extends Ball {

    private static final float ballDiameter = 24.84f;
    private static final String kindOfSport = "Basketball";

    public Basketball(int serialNumber) {
        super(ballDiameter, kindOfSport, serialNumber);
    }

    @Override
    public void play() {
        System.out.println("Let's play basketball (ball serial number = " + super.getSerialNumber() + ")");
    }
}

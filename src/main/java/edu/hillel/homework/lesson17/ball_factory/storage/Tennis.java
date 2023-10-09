package edu.hillel.homework.lesson17.ball_factory.storage;

import edu.hillel.homework.lesson17.ball_factory.Ball;

public class Tennis extends Ball {

    private static final float ballDiameter = 6.7f;
    private static final String kindOfSport = "Tennis";

    public Tennis(int serialNumber) {
        super(ballDiameter, kindOfSport, serialNumber);
    }

    @Override
    public void play() {
        System.out.println("Let's play tennis (ball serial number = " + super.getSerialNumber() + ")");
    }
}

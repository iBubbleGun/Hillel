package edu.hillel.homework.lesson5.obstacles.lets;

import edu.hillel.homework.lesson5.obstacles.Let;
import java.util.Random;

public class Treadmill implements Let {

    private final int MIN_DISTANCE_LONG = 100; // meters
    private final int MAX_DISTANCE_LONG = 2500; // meters
    private int distance;
    private Random rnd;

    public Treadmill() {
        rnd = new Random();
        this.distance = rnd.nextInt(MAX_DISTANCE_LONG - MIN_DISTANCE_LONG) + MIN_DISTANCE_LONG;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public void obstacle() {
        System.out.println("\nObstacle Treadmill " + getDistance() + " meters long.");
    }
}

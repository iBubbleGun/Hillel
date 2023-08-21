package edu.hillel.homework.lesson5.obstacles.lets;

import edu.hillel.homework.lesson5.obstacles.Let;
import java.util.Random;

public class Wall implements Let {

    private final int MIN_WALL_HEIGHT = 50; // centimeters
    private final int MAX_WALL_HEIGHT = 450; // centimeters
    private int distance;
    private Random rnd;

    public Wall() {
        rnd = new Random();
        this.distance = rnd.nextInt(MAX_WALL_HEIGHT - MIN_WALL_HEIGHT) + MIN_WALL_HEIGHT;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public void obstacle() {
        System.out.println("\nObstacle Wall " + getDistance() + " centimeters height.");
    }
}

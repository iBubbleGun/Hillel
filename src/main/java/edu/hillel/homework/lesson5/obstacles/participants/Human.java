package edu.hillel.homework.lesson5.obstacles.participants;

import edu.hillel.homework.lesson5.obstacles.Let;
import edu.hillel.homework.lesson5.obstacles.ObstacleController;
import edu.hillel.homework.lesson5.obstacles.Participant;
import edu.hillel.homework.lesson5.obstacles.lets.Treadmill;
import edu.hillel.homework.lesson5.obstacles.lets.Wall;

public class Human implements Participant {

    private final int MAX_DISTANCE_TO_HUMAN_RUN = 1800;
    private final int MAX_HEIGHT_TO_HUMAN_JUMP = 300;
    private String name;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void participateInCompetition(Let let, int letLength, ObstacleController controller) {
        if (let instanceof Treadmill) {
            if (letLength <= MAX_DISTANCE_TO_HUMAN_RUN) {
                run(letLength);
            } else {
                controller.setParticipantOvercome(this, false);
                System.out.println("Participant human " + name
                        + " did not pass the obstacle " + let.getClass().getSimpleName()
                        + ", " + letLength + " meters long. "
                        + name + " ran only " + MAX_DISTANCE_TO_HUMAN_RUN + " meters.");
            }
        } else if (let instanceof Wall) {
            if (letLength <= MAX_HEIGHT_TO_HUMAN_JUMP) {
                jump(letLength);
            } else {
                controller.setParticipantOvercome(this, false);
                System.out.println("Participant human " + name
                        + " did not pass the obstacle " + let.getClass().getSimpleName()
                        + ", " + letLength + " centimeters high. "
                        + name + " jumped only " + MAX_HEIGHT_TO_HUMAN_JUMP + " centimeters.");
            }
        }
    }

    @Override
    public void run(int distance) {
        System.out.println("Participant human " + getName()
                + " passes an obstacle Treadmill "
                + distance + " meters long.");
    }

    @Override
    public void jump(int height) {
        System.out.println("Participant human " + getName()
                + " passes an obstacle Wall "
                + height + " centimeters high.");
    }
}

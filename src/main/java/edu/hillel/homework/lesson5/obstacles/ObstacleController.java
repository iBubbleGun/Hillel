package edu.hillel.homework.lesson5.obstacles;

import edu.hillel.homework.lesson5.obstacles.participants.Cat;
import edu.hillel.homework.lesson5.obstacles.participants.Human;
import edu.hillel.homework.lesson5.obstacles.participants.Robot;

public class ObstacleController {

    private boolean isHumanOvercome;
    private boolean isCatOvercome;
    private boolean isRobotOvercome;

    public ObstacleController() {
        this.isHumanOvercome = true;
        this.isCatOvercome = true;
        this.isRobotOvercome = true;
    }

    public boolean isHumanOvercome() {
        return isHumanOvercome;
    }

    public boolean isCatOvercome() {
        return isCatOvercome;
    }

    public boolean isRobotOvercome() {
        return isRobotOvercome;
    }

    public void setParticipantOvercome(Participant participant, boolean overcome) {
        if (participant instanceof Human) {
            this.isHumanOvercome = overcome;
        } else if (participant instanceof Cat) {
            this.isCatOvercome = overcome;
        } else if (participant instanceof Robot) {
            this.isRobotOvercome = overcome;
        }
    }
}

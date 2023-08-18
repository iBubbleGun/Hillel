package edu.hillel.homework.lesson5.obstacles;

public interface Participant {

    void participateInCompetition(Let let, int letLength, ObstacleController controller);
    void run(int distance);
    void jump(int height);
}

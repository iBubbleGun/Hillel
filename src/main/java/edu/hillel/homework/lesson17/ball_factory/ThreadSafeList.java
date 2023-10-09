package edu.hillel.homework.lesson17.ball_factory;

import org.jetbrains.annotations.NotNull;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafeList {

    private final CopyOnWriteArrayList<Ball> ballsList;

    public ThreadSafeList() {
        this.ballsList = new CopyOnWriteArrayList<>();
    }

    public void add(Ball ball) {
        ballsList.add(ball);
    }

    public void remove(int serialNumber) {
        Optional<Ball> foundBall = getBallBySerialNumber(ballsList, serialNumber);
        if (foundBall.isPresent()) {
            ballsList.removeIf(ball -> ball.getSerialNumber() == serialNumber);
            System.out.println(
                    "Removed " + foundBall.get().getKindOfSport() +
                            " ball with serial number \"" + serialNumber + "\".");
        } else {
            System.out.println("Ball with serial number \"" + serialNumber + "\" not found!");
        }
    }

    public Ball get(int serialNumber) {
        Optional<Ball> foundBall = getBallBySerialNumber(ballsList, serialNumber);
        if (foundBall.isEmpty()) {
            throw new NoSuchElementException("Ball with serial number \"" + serialNumber + "\" not found!");
        }
        return foundBall.get();
    }

    public void playWithBallWithSpecificSerialNumber(int serialNumber) {
        Optional<Ball> foundBall = getBallBySerialNumber(ballsList, serialNumber);
        if (foundBall.isPresent()) {
            foundBall.get().play();
        } else {
            System.out.println("Ball with serial number \"" + serialNumber + "\" not found!");
        }
    }

    public void printAllPresentedSerialNumbers() {
        ballsList.stream()
                .mapToInt(Ball::getSerialNumber)
                .mapToObj(serialNumber -> serialNumber + ",")
                .forEach(System.out::print);
        System.out.println();
    }

    private @NotNull Optional<Ball> getBallBySerialNumber(@NotNull CopyOnWriteArrayList<Ball> list, int serialNumber) {
        return list.stream()
                .filter(ball -> ball.getSerialNumber() == serialNumber)
                .findFirst();
    }

    @Override
    public String toString() {
        return "BallManager{" +
                "ballsList=" + ballsList +
                "}";
    }
}

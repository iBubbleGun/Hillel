package edu.hillel.homework.lesson17;

import edu.hillel.homework.lesson17.ball_factory.BallManager;
import edu.hillel.homework.lesson17.ball_factory.storage.Basketball;
import edu.hillel.homework.lesson17.ball_factory.storage.Football;
import edu.hillel.homework.lesson17.ball_factory.storage.Tennis;
import edu.hillel.homework.lesson17.petrol_station.PetrolStation;
import edu.hillel.homework.lesson17.petrol_station.car.Car;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        ///////////////////////////////////////////////// PART 1 /////////////////////////////////////////////////
        BallManager ballManager = new BallManager();

        final int amountBallForEachKindOfSport = 10;

        Thread addFootballBalls = new Thread(() -> {
            // balls serial numbers from 1 to 10
            IntStream.range(0, amountBallForEachKindOfSport)
                    .mapToObj(i -> new Football(i + 1))
                    .forEach(ballManager::add);
        });

        Thread addBasketballBalls = new Thread(() -> {
            // balls serial numbers from 11 to 20
            IntStream.range(0, amountBallForEachKindOfSport)
                    .mapToObj(i -> new Basketball(i + amountBallForEachKindOfSport + 1))
                    .forEach(ballManager::add);
        });

        Thread addTennisBalls = new Thread(() -> {
            // balls serial numbers from 21 to 30
            IntStream.range(0, amountBallForEachKindOfSport)
                    .mapToObj(i -> new Tennis(i + (amountBallForEachKindOfSport * 2) + 1))
                    .forEach(ballManager::add);
        });

        addFootballBalls.start();
        addBasketballBalls.start();
        addTennisBalls.start();

        try {
            addFootballBalls.join();
            addBasketballBalls.join();
            addTennisBalls.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Presented balls with serial numbers:");
        ballManager.printAllPresentedSerialNumbers(); // print serial numbers for all stored balls

        ballManager.playWithBallWithSpecificSerialNumber(2); // play football with ball (sn = 2)
        ballManager.playWithBallWithSpecificSerialNumber(11); // play basketball with ball (sn = 11)
        ballManager.playWithBallWithSpecificSerialNumber(30); // play tennis with ball (sn = 30)

        //ballManager.get(43); // throw NoSuchElementException - ball with serial number 43 doesn't exist.

        Thread getFootballBall = new Thread(() -> {
            // get ball with serial number from 2 to 6
            IntStream.range(0, 5)
                    .mapToObj(i -> ballManager.get(i + 2))
                    .forEach(System.out::println);
        });
        Thread getTennisBall = new Thread(() -> {
            // get ball with serial number from 22 to 26
            IntStream.range(0, 5)
                    .mapToObj(i -> ballManager.get(i + 22))
                    .forEach(System.out::println);
        });
        getFootballBall.start();
        getTennisBall.start();
        try {
            getFootballBall.join();
            getTennisBall.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread removeAllFootballBalls = new Thread(() -> IntStream.range(0, amountBallForEachKindOfSport)
                .map(i -> i + 1)
                .forEach(ballManager::remove));
        Thread removeAllTennisBalls = new Thread(() -> IntStream.range(0, amountBallForEachKindOfSport)
                .map(i -> i + (amountBallForEachKindOfSport * 2) + 1)
                .forEach(ballManager::remove));
        removeAllFootballBalls.start();
        removeAllTennisBalls.start();
        try {
            removeAllFootballBalls.join();
            removeAllTennisBalls.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("There are still balls with serial numbers:");
        ballManager.printAllPresentedSerialNumbers();

        ///////////////////////////////////////////////// PART 2 /////////////////////////////////////////////////
        System.out.println("\n=== Petrol station ===");
        final int totalCarsForRefuel = 30;
        PetrolStation petrolStation = new PetrolStation(600, totalCarsForRefuel);

        IntStream.range(0, totalCarsForRefuel).forEach(i -> petrolStation.doRefuel(new Car(), getRandomFuelAmount()));

        try {
            petrolStation.awaitCompletion(); // make sure to wait for all threads to complete execution.
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }

        petrolStation.shutdownExecutor();
        System.out.println("Done!\n------\n" +
                "Current fuel balance at the station: " + petrolStation.getAmount() + " liters.");
    }

    private static int getRandomFuelAmount() {
        final int minFuelAmount = 10;
        final int maxFuelAmount = 45;
        return ThreadLocalRandom.current().nextInt(minFuelAmount, maxFuelAmount + 1);
    }
}

package edu.hillel.homework.lesson17.petrol_station.car;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarNumberGenerator {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int NUM_DIGITS = 4;
    private final StringBuilder carNumber;
    private final Random random;

    public CarNumberGenerator() {
        this.carNumber = new StringBuilder();
        this.random = new Random();
    }

    public String generateRandomCarNumber() {
        return carNumber.append(IntStream.range(0, NUM_DIGITS)
                .mapToObj(i -> String.valueOf(generateRandomDigit()))
                .collect(Collectors.joining(
                        "",
                        String.valueOf(generateRandomLetter()) + generateRandomLetter(),
                        String.valueOf(generateRandomLetter()) + generateRandomLetter())
                )).toString();
    }

    private char generateRandomLetter() {
        int index = random.nextInt(ALPHABET.length());
        return ALPHABET.charAt(index);
    }

    private int generateRandomDigit() {
        return random.nextInt(10);
    }
}

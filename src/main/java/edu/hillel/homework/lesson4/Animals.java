package edu.hillel.homework.lesson4;

public class Animals {

    private static int totalAnimalsCount = 0;
    private String animalName;

    public Animals(String animalName) {
        totalAnimalsCount++;
    }

    public static int getTotalAnimalsCount() {
        return totalAnimalsCount;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void run(int distance) {
        //
    }
}

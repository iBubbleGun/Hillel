package edu.hillel.homework.lesson4;

public class Animals {

    private static int totalAnimalsCount = 0;
    private String name;

    public Animals(String name) {
        this.name = name;
        totalAnimalsCount++;
    }

    public static int getTotalAnimalsCount() {
        return totalAnimalsCount;
    }

    public String getName() {
        return name;
    }

    public void run(int distance) {
        //
    }
}

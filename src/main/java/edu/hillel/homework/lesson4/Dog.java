package edu.hillel.homework.lesson4;

public class Dog extends Animals {

    private static int totalDogsCount = 0;

    public Dog(String dogName) {
        super(dogName);
        totalDogsCount++;
    }

    public static int getTotalDogsCount() {
        return totalDogsCount;
    }

    @Override
    public void run(int distance) {
        //
        super.run(distance);
    }
}

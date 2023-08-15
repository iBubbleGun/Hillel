package edu.hillel.homework.lesson4.dogs;

import edu.hillel.homework.lesson4.Animals;

public class Dog extends Animals {

    private static final int DOG_MAX_RUN_DISTANCE = 500;
    private static final int DOG_MAX_SWIM_DISTANCE = 10;
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
        if (distance > DOG_MAX_RUN_DISTANCE) {
            System.out.println("I'm sorry, but dogs can't run more than " + DOG_MAX_RUN_DISTANCE + " meters! So, " + super.getName() + " can't run " + distance + " meters!");
            return;
        }
        System.out.println("The dog " + super.getName() + " ran " + distance + " meters.");
    }

    @Override
    public void swim(int distance) {
        if (distance > DOG_MAX_SWIM_DISTANCE) {
            System.out.println("I'm sorry, but dogs can't swam more than " + DOG_MAX_SWIM_DISTANCE + " meters! So, " + super.getName() + " can't swim " + distance + " meters!");
            return;
        }
        System.out.println("The dog " + super.getName() + " swam " + distance + " meters.");
    }

    public void sayWuf() {
        System.out.println("The dog " + super.getName() + " say's wuf-wuf!");
    }
}

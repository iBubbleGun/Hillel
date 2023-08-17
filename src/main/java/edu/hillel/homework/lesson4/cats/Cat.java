package edu.hillel.homework.lesson4.cats;

import edu.hillel.homework.lesson4.Animals;
import edu.hillel.homework.lesson4.Counter;

public class Cat extends Animals {

    private static final int CAT_MAX_RUN_DISTANCE = 200;

    public Cat(String catName, Counter counter) {
        super(catName);
        counter.incrementCounter(this);
    }

    @Override
    public void run(int distance) {
        if (distance > CAT_MAX_RUN_DISTANCE) {
            System.out.println("I'm sorry, but cats can't run more than " + CAT_MAX_RUN_DISTANCE + " meters! So, " + super.getName() + " can't run " + distance + " meters!");
            return;
        }
        System.out.println("The cat " + super.getName() + " ran " + distance + " meters.");
    }

    @Override
    public void swim(int distance) {
        System.out.println("I'm sorry, but cats can't swim. So, " + super.getName() + " can't swim any distance.");
    }

    public void sayMeow() {
        System.out.println("The cat " + super.getName() + " say's meow.");
    }
}

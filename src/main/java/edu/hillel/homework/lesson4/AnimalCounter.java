package edu.hillel.homework.lesson4;

import edu.hillel.homework.lesson4.cats.Cat;
import edu.hillel.homework.lesson4.dogs.Dog;

public class AnimalCounter implements Counter {

    private int totalAnimalsCounter = 0;
    private int totalDogsCounter = 0;
    private int totalCatsCounter = 0;

    @Override
    public int getTotalAnimalsCount() {
        return totalAnimalsCounter;
    }

    @Override
    public int getTotalDogsCount() {
        return totalDogsCounter;
    }

    @Override
    public int getTotalCatsCount() {
        return totalCatsCounter;
    }

    @Override
    public void incrementCounter(Animals animal) {
        if (animal instanceof Dog || animal instanceof Cat) {
            totalAnimalsCounter++;

            if (animal instanceof Dog) {
                totalDogsCounter++;
            } else if (animal instanceof Cat) {
                totalCatsCounter++;
            }
        }
    }
}

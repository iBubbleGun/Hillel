package edu.hillel.homework.lesson9.warehouse;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {

    private final List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        this.fruits.add(fruit);
    }

    public void addFruits(T[] fruits) {
        this.fruits.addAll(Arrays.asList(fruits));
    }

    public float getWeight() {
        if (this.fruits.isEmpty()) {
            return 0.0f;
        }
        return this.fruits.get(0).getWeight() * this.fruits.size();
    }

    public int getFruitsQuantity() {
        return this.fruits.size();
    }

    public String getFruitsType() {
        try {
            return this.fruits.get(0).getClass().getSimpleName().toLowerCase();
        } catch (Exception e) {
            throw new RuntimeException("Can't tell which fruit is in the box because it's empty!", e);
        }
    }

    public boolean compare(@NotNull Box<? extends Fruit> otherBox) {
        return this.getWeight() == otherBox.getWeight();
    }

    public void merge(@NotNull Box<T> otherBox) {
        if (!otherBox.fruits.isEmpty()) {
            int firstBoxQuantity = this.fruits.size();
            int otherBoxQuantity = otherBox.fruits.size();

            this.fruits.addAll(otherBox.fruits);
            otherBox.fruits.clear();

            System.out.println("Successfully merged new "
                    + otherBoxQuantity + " with " + firstBoxQuantity + " old "
                    + this.getFruitsType().concat("s."));
        } else {
            System.out.println("Your other box is empty!\n" +
                    "Nothing to merge.");
        }
    }
}

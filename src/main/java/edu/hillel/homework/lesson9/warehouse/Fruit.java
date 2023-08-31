package edu.hillel.homework.lesson9.warehouse;

public class Fruit<T extends Fruit> {

    private float weight;

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}

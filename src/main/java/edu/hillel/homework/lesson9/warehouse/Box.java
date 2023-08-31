package edu.hillel.homework.lesson9.warehouse;

import edu.hillel.homework.lesson9.warehouse.fruit_storage_area.Apple;

import java.util.List;

public class Box<T extends Fruit> {

    private T fruit;
    private List<T> fruits;

    public T getFruit() {
        return fruit;
    }

    public void setFruit(T fruit) {
        this.fruit = fruit;
    }
}

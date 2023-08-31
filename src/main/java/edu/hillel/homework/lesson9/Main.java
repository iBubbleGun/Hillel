package edu.hillel.homework.lesson9;

import edu.hillel.homework.lesson9.warehouse.Box;
import edu.hillel.homework.lesson9.warehouse.fruit_storage_area.*;

public class Main {

    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>();
        appleBox.setFruit(new Apple());

        System.out.println(appleBox.getFruit().getWeight());
    }
}

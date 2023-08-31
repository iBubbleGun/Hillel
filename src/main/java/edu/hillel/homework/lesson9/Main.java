package edu.hillel.homework.lesson9;

import edu.hillel.homework.lesson9.warehouse.Box;
import edu.hillel.homework.lesson9.warehouse.fruit_storage_area.*;

public class Main {

    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruits(new Apple[]{new Apple(), new Apple(), new Apple(), new Apple()});

        System.out.println(appleBox.getWeight());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruits(new Orange[]{new Orange(), new Orange(), new Orange()});

        System.out.println(orangeBox.getWeight());

        System.out.println(appleBox.compare(orangeBox));

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple());
        appleBox2.addFruit(new Apple());
        appleBox2.addFruit(new Apple());
        appleBox2.addFruits(new Apple[]{new Apple(), new Apple(), new Apple(), new Apple()});
        System.out.println(appleBox2.getWeight());

        appleBox.merge(appleBox2);

        System.out.println(appleBox.getWeight());
        System.out.println(appleBox2.getWeight());

        System.out.println(appleBox2.compare(orangeBox));
        appleBox.merge(appleBox2);
    }
}

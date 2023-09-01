package edu.hillel.homework.lesson9;

import edu.hillel.homework.lesson9.warehouse.Box;
import edu.hillel.homework.lesson9.warehouse.fruit_storage_area.*;

public class Main {

    public static void main(String[] args) {

        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());
        Apple[] applesArray = {new Apple(), new Apple(), new Apple(), new Apple()};
        appleBox1.addFruits(applesArray);
        System.out.println("Created appleBox1 with "
                + appleBox1.getFruitsQuantity() + " "
                + appleBox1.getFruitsType() + "s.");
        System.out.println("Now weight of appleBox1 = " + appleBox1.getWeight());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruits(new Orange[]{new Orange(), new Orange(), new Orange()});
        System.out.println("\nCreated orangeBox with "
                + orangeBox.getFruitsQuantity() + " "
                + orangeBox.getFruitsType() + "s.");
        System.out.println("Now weight of orangeBox = " + orangeBox.getWeight());

        System.out.println("\nCompare appleBox1 with orangeBox..." +
                "\nThey are the same weight: " + appleBox1.compare(orangeBox));

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple());
        appleBox2.addFruit(new Apple());
        appleBox2.addFruit(new Apple());
        appleBox2.addFruits(applesArray);
        System.out.println("\nCreated appleBox2 with "
                + appleBox2.getFruitsQuantity() + " "
                + appleBox2.getFruitsType() + "s.");
        System.out.println("Now weight of appleBox2 = " + appleBox2.getWeight());

        System.out.println("\nTrying to merge appleBox2 with appleBox1...");
        appleBox1.merge(appleBox2);

        System.out.println("Now weight of appleBox1 = " + appleBox1.getWeight());
        System.out.println("Now weight of appleBox2 = " + appleBox2.getWeight());

        System.out.println("\nCompare appleBox2 with orangeBox..." +
                "\nThey are the same weight: " + appleBox2.compare(orangeBox));

        System.out.println("\nTrying to merge appleBox2 with appleBox1...");
        appleBox1.merge(appleBox2);

        Box<Banana> bananaBox = new Box<>();
        bananaBox.addFruit(new Banana());
        bananaBox.addFruits(new Banana[]{new Banana(), new Banana(), new Banana(), new Banana(), new Banana()});
        System.out.println("\nCreated bananaBox with "
                + bananaBox.getFruitsQuantity() + " "
                + bananaBox.getFruitsType() + "s.");
        System.out.println("Now weight of bananaBox = " + bananaBox.getWeight());

        Box<Plum> plumBox = new Box<>();
        plumBox.addFruit(new Plum());
        plumBox.addFruits(new Plum[]{new Plum(), new Plum(), new Plum(), new Plum(), new Plum()});
        System.out.println("\nCreated plumBox with "
                + plumBox.getFruitsQuantity() + " "
                + plumBox.getFruitsType() + "s.");
        System.out.println("Now weight of plumBox = " + plumBox.getWeight());

        System.out.println("\nCompare bananaBox with plumBox..." +
                "\nThey are the same weight: " + bananaBox.compare(plumBox));

        // Added 54 plums in to plumBox.
        System.out.println("\nAdded 54 plums in to plumBox.");
        for (int i = 0; i < 54; i++) {
            plumBox.addFruit(new Plum());
        }
        System.out.println("Now weight of plumBox = "
                + plumBox.getWeight()
                + " (now " + plumBox.getFruitsQuantity() + " " + plumBox.getFruitsType() + "s).");
        System.out.println("\nNew compare bananaBox with plumBox..." +
                "\nThey are the same weight: " + bananaBox.compare(plumBox));

        Box<Lemon> lemonBox = new Box<>();
        System.out.println("\nCreated empty lemonBox.");
        System.out.println("Now weight of lemonBox = " + lemonBox.getWeight());
    }
}

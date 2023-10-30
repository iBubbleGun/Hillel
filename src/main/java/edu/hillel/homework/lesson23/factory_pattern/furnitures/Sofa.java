package edu.hillel.homework.lesson23.factory_pattern.furnitures;

import edu.hillel.homework.lesson23.factory_pattern.Furniture;

public class Sofa implements Furniture {

    @Override
    public void assemble() {
        System.out.println("Assembling a sofa.");
    }

    @Override
    public String getDescription() {
        return "This is a sofa.";
    }
}

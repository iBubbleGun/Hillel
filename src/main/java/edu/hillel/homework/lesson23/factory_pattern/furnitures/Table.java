package edu.hillel.homework.lesson23.factory_pattern.furnitures;

import edu.hillel.homework.lesson23.factory_pattern.Furniture;

public class Table implements Furniture {

    @Override
    public void assemble() {
        System.out.println("Assembling a table.");
    }

    @Override
    public String getDescription() {
        return "This is a table.";
    }
}

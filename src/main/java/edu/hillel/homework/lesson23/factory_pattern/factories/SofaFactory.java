package edu.hillel.homework.lesson23.factory_pattern.factories;

import edu.hillel.homework.lesson23.factory_pattern.Furniture;
import edu.hillel.homework.lesson23.factory_pattern.FurnitureFactory;
import edu.hillel.homework.lesson23.factory_pattern.furnitures.Sofa;

public class SofaFactory implements FurnitureFactory {

    @Override
    public Furniture createFurniture() {
        return new Sofa();
    }
}

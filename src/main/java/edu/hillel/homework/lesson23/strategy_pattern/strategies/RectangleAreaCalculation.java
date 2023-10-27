package edu.hillel.homework.lesson23.strategy_pattern.strategies;

import edu.hillel.homework.lesson23.strategy_pattern.AreaCalculationStrategy;

public class RectangleAreaCalculation implements AreaCalculationStrategy {

    private final double width;
    private final double height;

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public RectangleAreaCalculation(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

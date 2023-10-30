package edu.hillel.homework.lesson23.strategy_pattern.strategies;

import edu.hillel.homework.lesson23.strategy_pattern.AreaCalculationStrategy;

public class TriangleAreaCalculation implements AreaCalculationStrategy {

    private final double base;
    private final double height;

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public TriangleAreaCalculation(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

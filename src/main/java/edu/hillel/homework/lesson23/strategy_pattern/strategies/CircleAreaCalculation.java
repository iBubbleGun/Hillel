package edu.hillel.homework.lesson23.strategy_pattern.strategies;

import edu.hillel.homework.lesson23.strategy_pattern.AreaCalculationStrategy;

public class CircleAreaCalculation implements AreaCalculationStrategy {

    private final double radius;

    public double getRadius() {
        return radius;
    }

    public CircleAreaCalculation(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

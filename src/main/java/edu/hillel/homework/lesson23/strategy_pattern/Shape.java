package edu.hillel.homework.lesson23.strategy_pattern;

public class Shape {

    private AreaCalculationStrategy geometricFigure;

    public void setAreaCalculationStrategy(AreaCalculationStrategy strategy) {
        this.geometricFigure = strategy;
    }

    public double calculateArea() {
        if (geometricFigure == null) {
            throw new IllegalStateException("Area calculation strategy is not set.");
        }
        return geometricFigure.calculateArea();
    }
}

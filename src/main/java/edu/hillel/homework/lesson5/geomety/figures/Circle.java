package edu.hillel.homework.lesson5.geomety.figures;

import edu.hillel.homework.lesson5.geomety.GeometricFigure;

public class Circle implements GeometricFigure {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateFigureArea() {
        return Math.PI * radius * radius;
    }
}

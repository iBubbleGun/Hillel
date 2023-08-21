package edu.hillel.homework.lesson5.geomety.figures;

import edu.hillel.homework.lesson5.geomety.GeometricFigure;

public class Square implements GeometricFigure {

    private double squareSideLength;

    public Square(double squareSideLength) {
        this.squareSideLength = squareSideLength;
    }

    public void setSquareSideLength(double squareSideLength) {
        this.squareSideLength = squareSideLength;
    }

    @Override
    public double calculateFigureArea() {
        return squareSideLength * squareSideLength;
    }
}

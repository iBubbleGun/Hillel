package edu.hillel.homework.lesson5.geomety.figures;

import edu.hillel.homework.lesson5.geomety.GeometricFigure;

public class Triangle implements GeometricFigure {

    private double triangleHeight;
    private double triangleBaseLength;

    public Triangle(double triangleHeight, double triangleBaseLength) {
        this.triangleHeight = triangleHeight;
        this.triangleBaseLength = triangleBaseLength;
    }

    public void setTriangleHeight(double triangleHeight) {
        this.triangleHeight = triangleHeight;
    }

    public void setTriangleBaseLength(double triangleBaseLength) {
        this.triangleBaseLength = triangleBaseLength;
    }

    @Override
    public double calculateFigureArea() {
        return (triangleHeight * triangleBaseLength) / 2;
    }
}

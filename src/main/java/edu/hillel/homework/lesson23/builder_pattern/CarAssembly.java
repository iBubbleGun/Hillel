package edu.hillel.homework.lesson23.builder_pattern;

public class CarAssembly implements Car {

    private String bodyType;
    private String engine;
    private int wheels;
    private int seatsNumber;
    private String color;

    @Override
    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    @Override
    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    @Override
    public void setSetColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car {" +
                "BodyType: " + bodyType + ", " +
                "Engine: " + engine + ", " +
                "Wheels: " + wheels + ", " +
                "SeatsNumber: " + seatsNumber + ", " +
                "Color: " + color + "}";
    }
}

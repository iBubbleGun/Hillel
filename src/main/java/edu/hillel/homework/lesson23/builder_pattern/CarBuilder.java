package edu.hillel.homework.lesson23.builder_pattern;

public abstract class CarBuilder {

    protected Car car;
    private final String color;

    public CarBuilder(String color) {
        this.color = color;
    }

    public Car getCar() {
        return car;
    }

    public String getColor() {
        return color;
    }

    public void createNewCar() {
        car = new CarAssembly();
    }

    public abstract void buildBodyType();

    public abstract void buildEngine();

    public abstract void buildWheels();

    public abstract void buildSeatsNumber();

    public abstract void buildColor();
}

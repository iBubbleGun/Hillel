package edu.hillel.homework.lesson23.builder_pattern;

public class RobotCarPicker {

    private CarBuilder carBuilder;

    public void setCarBuilder(CarBuilder builder) {
        this.carBuilder = builder;
    }

    public Car getCar() {
        return carBuilder.getCar();
    }

    public void constructCar() {
        carBuilder.createNewCar();

        carBuilder.buildBodyType();
        carBuilder.buildEngine();
        carBuilder.buildWheels();
        carBuilder.buildSeatsNumber();
        carBuilder.buildColor();
    }
}

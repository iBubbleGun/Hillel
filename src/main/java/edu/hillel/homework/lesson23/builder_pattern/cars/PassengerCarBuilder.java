package edu.hillel.homework.lesson23.builder_pattern.cars;

import edu.hillel.homework.lesson23.builder_pattern.CarBuilder;

public class PassengerCarBuilder extends CarBuilder {

    private static final String BODY_TYPE = "Sedan";
    private static final String ENGINE = "V4 normal";
    private static final int WHEELS = 4;
    private static final int SEATS = 4;

    public PassengerCarBuilder(String color) {
        super(color);
    }

    @Override
    public void buildBodyType() {
        car.setBodyType(BODY_TYPE);
    }

    @Override
    public void buildEngine() {
        car.setEngine(ENGINE);
    }

    @Override
    public void buildWheels() {
        car.setWheels(WHEELS);
    }

    @Override
    public void buildSeatsNumber() {
        car.setSeatsNumber(SEATS);
    }

    @Override
    public void buildColor() {
        car.setSetColor(getColor());
    }
}

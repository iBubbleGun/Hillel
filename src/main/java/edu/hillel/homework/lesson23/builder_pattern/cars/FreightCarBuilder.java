package edu.hillel.homework.lesson23.builder_pattern.cars;

import edu.hillel.homework.lesson23.builder_pattern.CarBuilder;

public class FreightCarBuilder extends CarBuilder {

    private static final String BODY_TYPE = "Pickup";
    private static final String ENGINE = "V4 turbo";
    private static final int WHEELS = 6;
    private static final int SEATS = 2;

    public FreightCarBuilder(String color) {
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

package edu.hillel.homework.lesson23.builder_pattern.cars;

import edu.hillel.homework.lesson23.builder_pattern.CarBuilder;

public class RacingCarBuilder extends CarBuilder {

    public RacingCarBuilder(String color) {
        super(color);
    }

    @Override
    public void buildBodyType() {
        car.setBodyType("Monoposto");
    }

    @Override
    public void buildEngine() {
        car.setEngine("V12 double turbo");
    }

    @Override
    public void buildWheels() {
        car.setWheels(4);
    }

    @Override
    public void buildSeatsNumber() {
        car.setSeatsNumber(1);
    }

    @Override
    public void buildColor() {
        car.setSetColor(super.getColor());
    }
}

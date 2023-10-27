package edu.hillel.homework.lesson23.builder_pattern.cars;

import edu.hillel.homework.lesson23.builder_pattern.CarBuilder;

public class FreightCarBuilder extends CarBuilder {

    public FreightCarBuilder(String color) {
        super(color);
    }

    @Override
    public void buildBodyType() {
        car.setBodyType("Pickup");
    }

    @Override
    public void buildEngine() {
        car.setEngine("V4 turbo");
    }

    @Override
    public void buildWheels() {
        car.setWheels(6);
    }

    @Override
    public void buildSeatsNumber() {
        car.setSeatsNumber(2);
    }

    @Override
    public void buildColor() {
        car.setSetColor(super.getColor());
    }
}

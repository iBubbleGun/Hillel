package edu.hillel.homework.lesson23.builder_pattern.cars;

import edu.hillel.homework.lesson23.builder_pattern.CarBuilder;

public class PassengerCarBuilder extends CarBuilder {

    public PassengerCarBuilder(String color) {
        super(color);
    }

    @Override
    public void buildBodyType() {
        car.setBodyType("Sedan");
    }

    @Override
    public void buildEngine() {
        car.setEngine("V4 normal");
    }

    @Override
    public void buildWheels() {
        car.setWheels(4);
    }

    @Override
    public void buildSeatsNumber() {
        car.setSeatsNumber(4);
    }

    @Override
    public void buildColor() {
        car.setSetColor(super.getColor());
    }
}

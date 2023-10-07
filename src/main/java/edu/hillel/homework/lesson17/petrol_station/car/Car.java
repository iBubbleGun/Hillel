package edu.hillel.homework.lesson17.petrol_station.car;

import java.util.Random;

public class Car {

    private final String carNumber;
    private final String carBrand;

    public Car() {
        this.carNumber = new CarNumberGenerator().generateRandomCarNumber();
        final CarBrand[] carBrands = CarBrand.values();
        this.carBrand = carBrands[new Random().nextInt(carBrands.length)].name();
    }

    public String getCarNumber() {
        return carNumber;
    }

    public String getCarBrand() {
        return carBrand;
    }
}

enum CarBrand {
    Opel,
    Mitsubishi,
    Mercedes,
    Honda,
    Hyundai,
    Mazda,
    BMW,
    Peugeot,
    Renault,
    Volkswagen,
    Chevrolet,
    Dodge,
    Maserati,
    Subaru
}

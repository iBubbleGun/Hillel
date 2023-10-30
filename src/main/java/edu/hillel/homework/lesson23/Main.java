package edu.hillel.homework.lesson23;

import edu.hillel.homework.lesson23.builder_pattern.CarBuilder;
import edu.hillel.homework.lesson23.builder_pattern.RobotCarPicker;
import edu.hillel.homework.lesson23.builder_pattern.cars.FreightCarBuilder;
import edu.hillel.homework.lesson23.builder_pattern.cars.PassengerCarBuilder;
import edu.hillel.homework.lesson23.builder_pattern.cars.RacingCarBuilder;
import edu.hillel.homework.lesson23.factory_pattern.Furniture;
import edu.hillel.homework.lesson23.factory_pattern.FurnitureFactory;
import edu.hillel.homework.lesson23.factory_pattern.factories.ChairFactory;
import edu.hillel.homework.lesson23.factory_pattern.factories.SofaFactory;
import edu.hillel.homework.lesson23.factory_pattern.factories.TableFactory;
import edu.hillel.homework.lesson23.strategy_pattern.Shape;
import edu.hillel.homework.lesson23.strategy_pattern.strategies.CircleAreaCalculation;
import edu.hillel.homework.lesson23.strategy_pattern.strategies.RectangleAreaCalculation;
import edu.hillel.homework.lesson23.strategy_pattern.strategies.TriangleAreaCalculation;

public class Main {

    public static void main(String[] args) {

        /// builder pattern for build cars usage ///
        final RobotCarPicker freightCarPicker = new RobotCarPicker();
        final CarBuilder freightCar = new FreightCarBuilder("Black");
        freightCarPicker.setCarBuilder(freightCar);
        freightCarPicker.constructCar();
        System.out.println("Built new freight car: " + freightCarPicker.getCar());

        final RobotCarPicker passengerRedCarPicker = new RobotCarPicker();
        final CarBuilder passengerRedCar = new PassengerCarBuilder("Red");
        passengerRedCarPicker.setCarBuilder(passengerRedCar);
        passengerRedCarPicker.constructCar();
        System.out.println("Built new passenger red car: " + passengerRedCarPicker.getCar());

        final RobotCarPicker passengerYellowCarPicker = new RobotCarPicker();
        final CarBuilder passengerYellowCar = new PassengerCarBuilder("Yellow");
        passengerYellowCarPicker.setCarBuilder(passengerYellowCar);
        passengerYellowCarPicker.constructCar();
        System.out.println("Built new passenger yellow car: " + passengerYellowCarPicker.getCar());

        final RobotCarPicker racingCarPicker = new RobotCarPicker();
        final CarBuilder racingCar = new RacingCarBuilder("White");
        racingCarPicker.setCarBuilder(racingCar);
        racingCarPicker.constructCar();
        System.out.println("Built new racing car: " + racingCarPicker.getCar());

        System.out.println();

        /// factory pattern for create furniture usage ///
        final FurnitureFactory chairFactory = new ChairFactory();
        final Furniture chair = chairFactory.createFurniture();
        chair.assemble();
        System.out.println(chair.getDescription());

        final FurnitureFactory tableFactory = new TableFactory();
        final Furniture table = tableFactory.createFurniture();
        table.assemble();
        System.out.println(table.getDescription());

        final FurnitureFactory sofaFactory = new SofaFactory();
        final Furniture sofa = sofaFactory.createFurniture();
        sofa.assemble();
        System.out.println(sofa.getDescription());

        System.out.println();

        /// strategy pattern for calculate figures area usage ///
        // rectangle
        final Shape rectangle = new Shape();
        final RectangleAreaCalculation newRectangle = new RectangleAreaCalculation(4.0, 5.0);
        rectangle.setAreaCalculationStrategy(newRectangle);
        System.out.printf("Rectangle area (width = %.2f, height = %.2f) = %.2f%n",
                newRectangle.getWidth(),
                newRectangle.getHeight(),
                rectangle.calculateArea());

        // triangle
        final Shape triangle = new Shape();
        final TriangleAreaCalculation newTriangle = new TriangleAreaCalculation(3.0, 4.0);
        triangle.setAreaCalculationStrategy(newTriangle);
        System.out.printf("Triangle area (base = %.2f, height = %.2f) = %.2f%n",
                newTriangle.getBase(),
                newTriangle.getHeight(),
                triangle.calculateArea());

        // circle
        final Shape circle = new Shape();
        final CircleAreaCalculation newCircle = new CircleAreaCalculation(5.0);
        circle.setAreaCalculationStrategy(newCircle);
        System.out.printf("Circle area (radius = %.2f) = %.2f%n",
                newCircle.getRadius(),
                circle.calculateArea());
    }
}

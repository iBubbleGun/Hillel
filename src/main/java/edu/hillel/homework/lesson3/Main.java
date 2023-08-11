package edu.hillel.homework.lesson3;

import edu.hillel.homework.lesson3.employee.Employee;
import edu.hillel.homework.lesson3.cars.Car;

public class Main {

    public static void main(String[] args) {
        // Employee conctructor and public printNewEmployee() method
        Employee employee = new Employee("Kosiak Tymur Anatolievich", "Junior", "us1gav@gmail.com", "+380449379992", 36);
        employee.printNewEmployee();

        System.out.println();

        // Call the same named static methods from the same classes of different packages
        System.out.println(edu.hillel.homework.lesson3.package1.SameName.sameNameMethod());
        System.out.println(edu.hillel.homework.lesson3.package2.SameName.sameNameMethod());

        System.out.println();

        // Car start() method with three hidden private methods
        Car car = new Car();
        car.start();
    }
}

package edu.hillel.homework.lesson6;

import edu.hillel.homework.lesson6.homeworkapp.HomeWorkAppCore;

public class HomeWorkApp {

    public static void main(String[] args) {
        HomeWorkAppCore homeWork = new HomeWorkAppCore();

        homeWork.delimiter(1);
        homeWork.printThreeWords();

        homeWork.delimiter(2);
        homeWork.checkSumSign(2, -5);

        homeWork.delimiter(3);
        homeWork.printColor(50);

        homeWork.delimiter(4);
        homeWork.compareNumbers(4, -5);

        homeWork.delimiter(5);
        System.out.println(homeWork.isSumBetweenTenAndTwenty(4, 8));

        homeWork.delimiter(6);
        homeWork.positiveNumberOrNot(-8);

        homeWork.delimiter(7);
        System.out.println(homeWork.isNegativeNumber(-6));

        homeWork.delimiter(8);
        homeWork.printLineNTimes("This is my line.", 4);

        homeWork.delimiter(9);
        // Example:
        // Non-leap years: 1700, 1800, 1900, 2100, 2200, 2300, 2500, 2600 etc;
        // Leap years: 1600, 2000, 2008, 2028, 2048, 2068, 2088, 2400 etc.
        System.out.println(homeWork.isLeapYear(2100));
    }
}

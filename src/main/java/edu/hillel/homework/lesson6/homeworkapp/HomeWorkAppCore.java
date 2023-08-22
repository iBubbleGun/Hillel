package edu.hillel.homework.lesson6.homeworkapp;

public class HomeWorkAppCore {

    public void delimiter(int homeworkPart) {
        System.out.println("\n" + "-".repeat(60) + " part " + homeworkPart);
    }

    public void printThreeWords() {
        String[] fruits = {"Orange", "Banana", "Apple"};
        for (String s : fruits) {
            System.out.println(s);
        }
    }

    public void checkSumSign(int a, int b) {
        int sum = a + b;
        System.out.print((0 <= sum) ? "The sum of the numbers is positive." : "The sum of the numbers is negative.");
        System.out.println(" (" + a + " + " + b + " = " + sum + ")");
    }

    public void printColor(int value) {
        String color;
        if (value <= 0) {
            color = "Red";
        } else if (value <= 100) {
            color = "Yellow";
        } else {
            color = "Green";
        }
        System.out.println(color);
    }

    public void compareNumbers(int a, int b) {
        System.out.println((a >= b) ? "a >= b" : "a < b");
    }

    public boolean isSumBetweenTenAndTwenty(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public void positiveNumberOrNot(int number) {
        System.out.println((0 <= number) ? "Number " + number + " is positive." : "Number " + number + " is negative.");
    }

    public boolean isNegativeNumber(int number) {
        return number < 0;
    }

    public void printLineNTimes(String line, int times) {
        if (0 < times) {
            for (int i = 0; i < times; i++) {
                System.out.println(line);
            }
        } else {
            System.out.println("Your \"times\" must be greater than zero.");
        }
    }

    public boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            return year % 100 != 0 || year % 400 == 0;
        } else {
            return false;
        }
    }
}

package edu.hillel.homework.lesson16;

import edu.hillel.homework.lesson16.threaded_process.ValueCalculator;

public class Main {

    public static void main(String[] args) {

        ValueCalculator vc = new ValueCalculator(100_000_000);
        vc.printValueArrayTotalSize();
        vc.printHalfArraySize();
        vc.refillArrayThreadedMethod();
    }
}

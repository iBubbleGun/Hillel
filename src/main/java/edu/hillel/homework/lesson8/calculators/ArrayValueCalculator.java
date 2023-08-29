package edu.hillel.homework.lesson8.calculators;

import edu.hillel.homework.lesson8.exceptions.*;

public class ArrayValueCalculator {

    private final int MAX_ARRAY_LENGTH_ALLOWED;

    public ArrayValueCalculator() {
        this.MAX_ARRAY_LENGTH_ALLOWED = 4;
    }

    public int doCalc(String[][] inputArray) throws
            ArraySizeException,
            ArrayDataException,
            ArrayEmptyException,
            ArrayElementEmptyException {
        if (inputArray == null) {
            throw new ArrayEmptyException("An error occured!\n" +
                    "Array can not be empty!");
        }
        if (!is4x4Array(inputArray)) {
            throw new ArraySizeException("An error occured!\n" +
                    "Only 4x4 arrays are allowed!");
        }
        int sum = 0;
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(inputArray[i][j]);
                } catch (Exception e) {
                    if (inputArray[i][j] == null || inputArray[i][j].isEmpty()) {
                        throw new ArrayElementEmptyException("An error occured!\n" +
                                "Array element \"" + inputArray[i][j] + "\" " +
                                "with index [" + i + "][" + j + "]" +
                                " cannot be converted to a number because it is empty!");
                    } else {
                        throw new ArrayDataException("An error occured!\n" +
                                "Array element \"" + inputArray[i][j] + "\" " +
                                "with index [" + i + "][" + j + "]" +
                                " cannot be converted to a number because it's not a number!");
                    }
                }
            }
        }
        return sum;
    }

    private boolean is4x4Array(String[][] array) {
        if (array.length != MAX_ARRAY_LENGTH_ALLOWED) {
            return false;
        }
        for (String[] row : array) {
            if (row == null) {
                try {
                    throw new RuntimeException("Subarray also can not be empty!");
                }
                catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    return false;
                }
            }
            if (row.length != MAX_ARRAY_LENGTH_ALLOWED) {
                return false;
            }
        }
        return true;
    }
}

package edu.hillel.homework.lesson8;

import edu.hillel.homework.lesson8.calculators.ArrayValueCalculator;
import edu.hillel.homework.lesson8.exceptions.*;

public class Main {

    public static void main(String[] args) {

        ArrayValueCalculator avc = new ArrayValueCalculator();

        Object[] testArraysArray = {
                // Example 1. Normal String[4][4] array without errors
                new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}},

                // Example 2. Error ArraySizeException #1 in [1][1] array (array contains more than 4 elements).
                new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8", "55"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}},

                // Example 3. Error ArraySizeException #2 in [2] array (subarray contains more than 4 arrays).
                new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}, {"17", "18", "19", "20"}},

                // Example 4. Error ArraySizeException #3 in [3][1] array (contains less than 4 elements).
                new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}},

                // Example 5. Error ArraySizeException #4 in [4] array (subarray contains less than 4 arrays).
                new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}},

                // Example 6. Error ArrayDataException in [5] array, element with index [1][2] contains string and can't be convert in to int.
                new String[][]{{"1", "2", "3", "4"}, {"5", "6", "some text", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}},

                // Example 7. Error ArrayEmptyException. [6] array is empty.
                null,

                // Example 8. Error RuntimeException (also ArrayEmptyException). [7][3] array is empty (null).
                new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, null},

                // Example 9. Error ArrayElementEmptyException. in [8] array, element with index [3][2] is empty.
                new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", null, "16"}},

                // Example 10. Error ArrayElementEmptyException. in [9] array, element with index [0][2] is empty.
                new String[][]{{"1", "2", "", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}}
        };

        for (int i = 0; i < testArraysArray.length; i++) {
            System.out.println("-".repeat(103).concat(" ").concat(getMessage(i)));
            try {
                int result = avc.doCalc((String[][]) testArraysArray[i]);
                System.out.println("Result = " + result + ".");
            } catch (ArraySizeException | ArrayEmptyException | ArrayElementEmptyException e) {
                System.out.println(e.getMessage());
            } catch (ArrayDataException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            System.out.println();
        }
    }

    private static String getMessage(int i) {
        String msg;
        if (i == 0) {
            msg = "Normal 4x4 array with good result calculation";
        } else if (i < 5) {
            msg = "Error ArraySizeException";
        } else if (i < 6) {
            msg = "Error ArrayDataException";
        } else if (i < 8) {
            msg = "Error ArrayEmptyException";
        } else {
            msg = "Error ArrayElementEmptyException";
        }
        return "Example #" + (i + 1) + ". " + msg;
    }
}

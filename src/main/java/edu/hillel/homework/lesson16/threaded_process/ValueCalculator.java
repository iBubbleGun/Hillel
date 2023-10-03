package edu.hillel.homework.lesson16.threaded_process;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class ValueCalculator {

    private static final float NUMBER = 1.0f;
    private float[] valueArray;
    private final int valueArrayTotalSize;
    private final int firstHalfValueArraySize;
    private final int secondHalfValueArraySize;

    public ValueCalculator(int arraySize) {
        this.valueArray = new float[arraySize];
        this.valueArrayTotalSize = arraySize;
        this.firstHalfValueArraySize = calculateFirstHalfArraySize(valueArray);
        this.secondHalfValueArraySize = arraySize - firstHalfValueArraySize;
    }

    public void refillArrayThreadedMethod() {
        final int a1ArraySize = firstHalfValueArraySize;
        final int a2ArraySize = secondHalfValueArraySize;

        float[] a1 = new float[a1ArraySize];
        float[] a2 = new float[a2ArraySize];

        System.out.println("\nUse refillArrayThreadedMethod()... Wait... ");
        long start = System.currentTimeMillis(); // start operating time value (ms)

        Arrays.fill(valueArray, NUMBER);

        System.arraycopy(valueArray, 0, a1, 0, a1ArraySize);
        System.arraycopy(valueArray, a1ArraySize, a2, 0, a2ArraySize);

        Thread thread1 = new Thread(() -> recalculateArrayElementValues(a1), "Thread 1");
        Thread thread2 = new Thread(() -> recalculateArrayElementValues(a2), "Thread 2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("An error occurred while trying to threads joining.");
            //e.printStackTrace();
        }

        this.valueArray = mergeTwoArrays(a1, a2);

//        System.out.println("\nFinal array values:");
//        for (float f : valueArray) {
//            System.out.print(f + ",");
//        }
//        System.out.println();

        long result = System.currentTimeMillis() - start; // stop operating time value (ms)

        System.out.println("Done!\nTotal operating time = " + result + " ms.");
    }

    public void printValueArrayTotalSize() {
        System.out.println("Total array size = " + valueArrayTotalSize + " elements.");
    }

    public void printHalfArraySize() {
        if (firstHalfValueArraySize == secondHalfValueArraySize) {
            System.out.println("Half array size = " + firstHalfValueArraySize + " elements.");
            return;
        }
        System.out.println(
                "An array has an odd number of elements.\n" +
                        "Therefore the array was divided into two halves with dimensions:\n  " +
                        "first half array size = " + firstHalfValueArraySize + " elements;\n  " +
                        "second half array size = " + secondHalfValueArraySize + " elements."
        );
    }

    /**
     * @param inputArray - any float arrays.
     * @return The method returns a number that corresponds to half the number of elements of the passed array.
     * If the passed array contains an odd number of elements, the number will be returned, rounded up to the nearest integer.
     * For example, if the input array contains 10000 elements, the method will return 5000.
     * If the input array contains 10001 elements, the method will return 5001.
     */
    @Contract(pure = true)
    private int calculateFirstHalfArraySize(float @NotNull [] inputArray) {
        return (int) Math.ceil(inputArray.length / 2.0);
    }

    private void recalculateArrayElementValues(float @NotNull [] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = (float) (
                    inputArray[i] *
                            Math.sin(0.2f + (float) i / 5) *
                            Math.cos(0.2f + (float) i / 5) *
                            Math.cos(0.4f + (float) i / 2)
            );
        }
    }

    private float @NotNull [] mergeTwoArrays(float @NotNull [] arr1, float @NotNull [] arr2) {
        final int arr1Size = arr1.length;
        final int arr2Size = arr2.length;

        float[] resultArray = new float[arr1Size + arr2Size];

        System.arraycopy(arr1, 0, resultArray, 0, arr1Size);
        System.arraycopy(arr2, 0, resultArray, arr1Size, arr2Size);

        return resultArray;
    }
}

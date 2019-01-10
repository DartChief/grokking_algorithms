package com.caspian.search;

import java.util.Scanner;

public class BinarySearch {

    private static int[] numbers = new int[300];

    public static void main(String[] args) {
        System.out.println("Write the coefficient: ");
        Scanner sc = new Scanner(System.in);
        int coefficient = sc.nextInt();
        fillArray(coefficient);

        for (int i = 0; i < numbers.length / 30; i++) {
            String row = "";
            for (int j = 0; j < 30; j++) {
                row = row.concat(String.valueOf(numbers[j + i*30]) + " ");
            }
            System.out.println(row);
        }

        System.out.println("Write the target value: ");
        sc = new Scanner(System.in);
        int targetValue = sc.nextInt();
        Integer targetIndex = getIndexByValueIfExists(targetValue);
        if (targetIndex != null) {
            System.out.println("Target index = " + targetIndex);
        } else {
            System.out.println("Array is not contain target value");
        }
    }

    private static Integer getIndexByValueIfExists(int value) {
        return binarySearch(value);
    }

    private static Integer binarySearch(int value) {
        int lowIndex = 0;
        int highIndex = numbers.length - 1;
        int midIndex;

        while (lowIndex <= highIndex) {
            midIndex = (lowIndex + highIndex) / 2;

            if (value == numbers[midIndex]) {
                return midIndex;
            }

            if (value > numbers[midIndex]) {
                lowIndex = midIndex + 1;
            } else {
                highIndex = midIndex - 1;
            }
        }

        return null;
    }

    private static void fillArray(int coefficient) {
        for (int i = 0; i < 300; i++) {
            numbers[i] = i + coefficient;
        }
    }
}

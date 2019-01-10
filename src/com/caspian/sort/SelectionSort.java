package com.caspian.sort;

import java.util.Arrays;

public class SelectionSort {

    private static int[] unsortedArray = {2,44,56,38,11,267,23,3,1};

    public static void main(String[] args) {
        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));
        System.out.println("Sorted array: " + Arrays.toString(getSortedArray()));
    }

    private static int[] getSortedArray() {
        int[] sortedArray = new int[unsortedArray.length];
        sort(sortedArray);

        return sortedArray;
    }

    private static void sort(int[] emptyArray) {
        int unsortedArrayLength = unsortedArray.length;

        for (int i = 0; i < emptyArray.length; i++) {
            int minIndex = 0;
            int minValue = unsortedArray[0];

            for (int j = 1; j < unsortedArrayLength; j++) {
                if (unsortedArray[j] < minValue) {
                    minIndex = j;
                    minValue = unsortedArray[j];
                }
            }
            emptyArray[i] = minValue;

            System.arraycopy(unsortedArray, minIndex + 1, unsortedArray, minIndex,
                    unsortedArrayLength - 1 - minIndex);
            unsortedArrayLength--;
        }
    }

}

package com.caspian.other;

import java.util.ArrayList;
import java.util.List;

public class RecursiveSum {

    public static void main(String[] args) {
        System.out.println("Sum of {1, 2, 3, 0, 55, 4, 2} = " + sumOfArray(new int[]{1, 2, 3, 0, 55, 4, 2}, 7));
        System.out.println("Sum of {4} = " + sumOfArray(new int[]{4}, 1));
        System.out.println("Sum of nothing = " + sumOfArray(new int[]{}, 0));

        List<Object> objectList = new ArrayList<>();
        objectList.add(new Object());
        objectList.add(new Object());
        objectList.add(new Object());
        objectList.add(new Object());
        objectList.add(new Object());
        System.out.println("Count of list with size = " + objectList.size() + " is " + countOfList(objectList, 0));
    }

    private static int sumOfArray(int[] numbers, int length) {
        if (length <= 0) {
            return 0;
        }

        return numbers[length - 1] + sumOfArray(numbers, length - 1);
    }

    private static int sumOfArrayDeprecated(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }

        if (numbers.length == 1) {
            return numbers[0];
        }

        int[] newNumbers = new int[numbers.length - 1];
        System.arraycopy(numbers, 1, newNumbers, 0, newNumbers.length);

        return numbers[0] + sumOfArrayDeprecated(newNumbers);
    }

    private static int countOfList(List<Object> list, int index) {
        try {
            list.get(index);
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }

        return countOfList(list, index + 1) + 1;
    }
}

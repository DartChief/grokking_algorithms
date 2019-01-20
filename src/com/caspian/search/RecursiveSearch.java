package com.caspian.search;

import com.caspian.model.Box;
import com.caspian.model.ObjectBox;
import com.caspian.util.Filler;

import java.util.ArrayList;
import java.util.List;

public class RecursiveSearch {

    public static void main(String[] args) throws CloneNotSupportedException {
        Box mainBox = Filler.getFilledMainBox();
        String standardKey = findKeyByFromField(mainBox.clone());
        System.out.println("Standard found key: " + standardKey);
        String recursionKey = recursiveFindKeyFromField(mainBox.clone());
        System.out.println("Recursive found key: " + recursionKey);

        ObjectBox objectMainBox = Filler.getFilledMainObjectBox();
        String objectRecursionKey = recursiveFindKeyFromObjectList(objectMainBox.clone());
        System.out.println("Recursion found key from Object list: " + objectRecursionKey);

        System.out.println(slowerRecursiveFindMax(new int[]{78,6,7,3,4,6,77}, 7));
        System.out.println(recursiveFindMax(new int[]{78,6,7,3,4,6,77}, 0, 7));
    }

    private static String findKeyByFromField(Box mainBox) {
        List<Box> pile = new ArrayList<>();
        pile.add(mainBox);

        while (!pile.isEmpty()) {
            Box currentBox = pile.get(0);

            for (Box box : currentBox.boxList) {
                if (box.key != null) {
                    return box.key;
                }

                if (!box.boxList.isEmpty()) {
                    pile.add(box);
                }
            }
            pile.remove(currentBox);
        }

        return null;
    }

    private static String recursiveFindKeyFromField(Box box) {
        if (box.key != null) {
            return box.key;
        }

        for (Box currentBox : box.boxList) {
            String key = recursiveFindKeyFromField(currentBox);
            if (key != null) {
                return key;
            }
        }

        return null;
    }

    private static String recursiveFindKeyFromObjectList(Object thing) {
        if (thing instanceof String) {
            return (String) thing;
        }

        for (Object currentThing : ((ObjectBox) thing).boxList) {
            String key = recursiveFindKeyFromObjectList(currentThing);
            if (key != null) {
                return key;
            }
        }

        return null;
    }

    private static int recursiveFindMax(int[] numbers, int maxValue, int length) {
        if (length == 0) {
            return maxValue;
        }

        if (numbers[length - 1] > maxValue) {
            maxValue = numbers[length - 1];
        }

        return recursiveFindMax(numbers, maxValue, length - 1);
    }

    private static int slowerRecursiveFindMax(int[] numbers, int length) {
        if (length == 1) {
            return numbers[0];
        }

        return Math.max(numbers[length-1], slowerRecursiveFindMax(numbers, length-1));
    }
}

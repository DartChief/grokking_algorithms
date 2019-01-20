package com.caspian.util;

import com.caspian.model.Box;
import com.caspian.model.ObjectBox;

public class Filler {

    public static int[] getFilledNumberArray(int coefficient, int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = i + coefficient;
        }

        return numbers;
    }

    public static Box getFilledMainBox() {
        Box mainBox = new Box();
        mainBox.boxList.add(new Box());
        mainBox.boxList.get(0).boxList.add(new Box());
        mainBox.boxList.get(0).boxList.add(new Box());
        mainBox.boxList.get(0).boxList.add(new Box());
        mainBox.boxList.get(0).boxList.add(new Box());

        mainBox.boxList.add(new Box());

        mainBox.boxList.add(new Box());
        mainBox.boxList.get(2).boxList.add(new Box());

        mainBox.boxList.add(new Box());
        mainBox.boxList.get(3).boxList.add(new Box());
        mainBox.boxList.get(3).boxList.add(new Box());
        mainBox.boxList.get(3).boxList.get(1).boxList.add(new Box());
        Box boxWithKey = new Box();
        boxWithKey.key = "Key in box 3:1:1";
        mainBox.boxList.get(3).boxList.get(1).boxList.add(boxWithKey);
        mainBox.boxList.get(3).boxList.get(1).boxList.add(new Box());
        mainBox.boxList.get(3).boxList.add(new Box());

        mainBox.boxList.add(new Box());
        mainBox.boxList.get(4).boxList.add(new Box());

        mainBox.boxList.add(new Box());
        mainBox.boxList.add(new Box());

        return mainBox;
    }

    public static ObjectBox getFilledMainObjectBox() {
        ObjectBox mainBox = new ObjectBox();
        mainBox.boxList.add(new ObjectBox());
        ((ObjectBox) mainBox.boxList.get(0)).boxList.add(new ObjectBox());
        ((ObjectBox) mainBox.boxList.get(0)).boxList.add(new ObjectBox());
        ((ObjectBox) mainBox.boxList.get(0)).boxList.add(new ObjectBox());
        mainBox.boxList.add(new ObjectBox());
        ((ObjectBox) mainBox.boxList.get(1)).boxList.add(new ObjectBox());
        ((ObjectBox) mainBox.boxList.get(1)).boxList.add(new ObjectBox());
        ((ObjectBox)((ObjectBox) mainBox.boxList.get(1)).boxList.get(0)).boxList.add(new ObjectBox());
        ((ObjectBox)((ObjectBox) mainBox.boxList.get(1)).boxList.get(0)).boxList.add("Key in box 3:1:1");
        ((ObjectBox) mainBox.boxList.get(1)).boxList.add(new ObjectBox());

        return mainBox;
    }

}

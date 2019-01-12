package com.caspian;

import java.util.ArrayList;
import java.util.List;

public class Recursion {

    public static void main(String[] args) throws CloneNotSupportedException {
        Box mainBox = getFilledMainBox();
        String standardKey = findKeyByFromField(mainBox.clone());
        System.out.println("Standard found key: " + standardKey);
        String recursionKey = recursiveFindKeyFromField(mainBox.clone());
        System.out.println("Recursive found key: " + recursionKey);

        ObjectBox objectMainBox = getFilledMainObjectBox();
        String objectRecursionKey = recursiveFindKeyFromObjectList(objectMainBox.clone());
        System.out.println("Recursion found key from Object list: " + objectRecursionKey);
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

    private static Box getFilledMainBox() {
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

    private static ObjectBox getFilledMainObjectBox() {
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

    private static class Box implements Cloneable {
        List<Box> boxList = new ArrayList<>();

        String key = null;

        @Override
        public Box clone() throws CloneNotSupportedException {
            return (Box) super.clone();
        }
    }

    private static class ObjectBox implements Cloneable {
        List<Object> boxList = new ArrayList<>();

        @Override
        public ObjectBox clone() throws CloneNotSupportedException {
            return (ObjectBox) super.clone();
        }
    }
}

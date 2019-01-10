package com.caspian;

import java.util.ArrayList;
import java.util.List;

public class Recursion {

    public static void main(String[] args) throws CloneNotSupportedException {
        Box mainBox = getFilledMainBox();
        String standardKey = findKeyByStandard(mainBox.clone());
        System.out.println("Standard key: " + standardKey);
        findKeyByRecursion(mainBox.clone());

        StrangeBox strangeMainBox = getFilledMainStrangeBox();
        findKeyByStrangeRecursion(strangeMainBox.clone());
    }

    private static String findKeyByStandard(Box mainBox) {
        List<Box> pile = new ArrayList<>();
        pile.add(mainBox);

        while (!pile.isEmpty()) {
            for (Box box : pile) {
                if (box.key != null) {
                    return box.key;
                }

                if (!box.boxList.isEmpty()) {
                    pile.addAll(box.boxList);
                }
                pile.remove(box);
                ((ArrayList<Box>) pile).trimToSize();
            }
        }

        return null;
    }

    private static void findKeyByRecursion(Box mainBox) {
        if (mainBox.key != null) {
            System.out.println("Recursion key: " + mainBox.key);
            return;
        }

        for (Box box : mainBox.boxList) {
            findKeyByStandard(box);
        }
    }

    private static void findKeyByStrangeRecursion(StrangeBox mainBox) {

        for (Object thing : mainBox.boxList) {
            if (thing instanceof String) {
                System.out.println("Strange Recursion key: " + thing);
                return;
            } else {
                findKeyByStrangeRecursion((StrangeBox) thing);
            }
        }
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

    private static StrangeBox getFilledMainStrangeBox() {
        StrangeBox mainBox = new StrangeBox();
        mainBox.boxList.add(new StrangeBox());
        ((StrangeBox) mainBox.boxList.get(0)).boxList.add(new StrangeBox());
        ((StrangeBox) mainBox.boxList.get(0)).boxList.add(new StrangeBox());
        ((StrangeBox) mainBox.boxList.get(0)).boxList.add(new StrangeBox());
        mainBox.boxList.add(new StrangeBox());
        ((StrangeBox) mainBox.boxList.get(1)).boxList.add(new StrangeBox());
        ((StrangeBox) mainBox.boxList.get(1)).boxList.add(new StrangeBox());
        ((StrangeBox)((StrangeBox) mainBox.boxList.get(1)).boxList.get(0)).boxList.add(new StrangeBox());
        ((StrangeBox)((StrangeBox) mainBox.boxList.get(1)).boxList.get(0)).boxList.add("Key in box 3:1:1");
        ((StrangeBox) mainBox.boxList.get(1)).boxList.add(new StrangeBox());

        return mainBox;
    }

    private static class Box implements Cloneable {
        List<Box> boxList = new ArrayList<>();

        String key = null;

        @Override
        public Box clone() throws CloneNotSupportedException {
//            Box clone = (Box) super.clone();
//            Box clone = new Box();
//            clone.boxList.addAll(this.boxList);
//            clone.key = this.key;
            return (Box) super.clone();
        }
    }

    private static class StrangeBox implements Cloneable {
        List<Object> boxList = new ArrayList<>();

        @Override
        public StrangeBox clone() throws CloneNotSupportedException {
//            Box clone = (Box) super.clone();
//            Box clone = new Box();
//            clone.boxList.addAll(this.boxList);
//            clone.key = this.key;
            return (StrangeBox) super.clone();
        }
    }
}

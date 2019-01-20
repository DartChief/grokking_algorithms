package com.caspian.model;

import java.util.ArrayList;
import java.util.List;

public class Box implements Cloneable {

    public List<Box> boxList = new ArrayList<>();

    public String key = null;

    @Override
    public Box clone() throws CloneNotSupportedException {
        return (Box) super.clone();
    }
}

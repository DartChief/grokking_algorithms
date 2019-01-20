package com.caspian.model;

import java.util.ArrayList;
import java.util.List;

public class ObjectBox implements Cloneable {

    public List<Object> boxList = new ArrayList<>();

    @Override
    public ObjectBox clone() throws CloneNotSupportedException {
        return (ObjectBox) super.clone();
    }
}

package com.xyw55.gof.flyweight;

/**
 * 外部状态UnsharedConcreteFlyWeight
 * Created by xiayiwei on 12/11/16.
 */
//外部状态UnsharedConcreteFlyWeight
public class Coordinate {
    private int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

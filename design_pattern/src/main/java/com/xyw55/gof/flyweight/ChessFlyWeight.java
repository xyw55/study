package com.xyw55.gof.flyweight;

/**
 * 享元类
 * Created by xiayiwei on 12/11/16.
 */

//Flyweight抽象享元类
public interface ChessFlyWeight {
    void setColor(String color);

    String getColor();

    void display(Coordinate c);
}

//ConcreteFlyWeight具体享元类
class ConcreteChess implements ChessFlyWeight {
    private String color;

    public ConcreteChess(String color) {
        super();
        this.color = color;
    }

    @Override
    public void setColor(String color) {

    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void display(Coordinate c) {
        System.out.println("color: " + color);
        System.out.println("coordinate: " + c.getX() + " " + c.getY());
    }
}

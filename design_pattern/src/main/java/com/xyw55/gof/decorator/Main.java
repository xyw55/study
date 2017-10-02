package com.xyw55.gof.decorator;

/**
 * Created by xiayiwei on 12/11/16.
 */
public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.move();

        FlyCar flyCar = new FlyCar(car);
        flyCar.move();

        WaterCar waterCar = new WaterCar(flyCar);
        waterCar.move();
    }
}

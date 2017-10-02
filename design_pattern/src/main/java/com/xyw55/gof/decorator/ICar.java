package com.xyw55.gof.decorator;

/**
 * Created by xiayiwei on 12/11/16.
 */

//Component抽象组件
public interface ICar {
    void move();
}


//ConcreteComponent具体构件角色（真实对象）
class Car implements ICar {


    @Override
    public void move() {
        System.out.println("run in road");
    }
}

//Decorator装饰角色
class SuperCar implements ICar {
    private ICar car;

    public SuperCar(ICar car) {
        super();
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}

//ConcreteDecorator具体装饰角色
class FlyCar extends SuperCar {

    public FlyCar(ICar car) {
        super(car);
    }

    public void fly() {
        System.out.println("fly in sky");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}

//ConcreteDecorator具体装饰角色
class WaterCar extends SuperCar {

    public WaterCar(ICar car) {
        super(car);
    }

    public void swimming() {
        System.out.println("run in water");
    }

    @Override
    public void move() {
        super.move();
        swimming();
    }
}


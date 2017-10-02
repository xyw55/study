package com.xyw55.gof.factory.factorymethod;

import com.xyw55.gof.factory.Audi;
import com.xyw55.gof.factory.Car;

/**
 * Created by xiayiwei on 11/27/16.
 */
public class AudiFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new Audi();
    }
}

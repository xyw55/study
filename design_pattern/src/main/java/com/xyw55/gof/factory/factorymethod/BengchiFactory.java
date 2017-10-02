package com.xyw55.gof.factory.factorymethod;

import com.xyw55.gof.factory.Bengchi;
import com.xyw55.gof.factory.Car;

/**
 * Created by xiayiwei on 11/27/16.
 */
public class BengchiFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new Bengchi();
    }
}

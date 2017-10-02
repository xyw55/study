package com.xyw55.gof.strategy;

/**
 * Created by xiayiwei on 12/18/16.
 */
public class OldUserStrategy implements IStrategy {
    @Override
    public double getPreice(double standardPrice) {
        return standardPrice * 0.9;
    }
}

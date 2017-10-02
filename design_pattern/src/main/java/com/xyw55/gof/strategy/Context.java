package com.xyw55.gof.strategy;

/**
 * Created by xiayiwei on 12/18/16.
 */
//负责和具体的策略类交互,使得算法和客户端调用分离
public class Context {
    private IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void printPrice(double s) {
        System.out.println(strategy.getPreice(s));
    }


}

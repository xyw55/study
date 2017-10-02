package com.xyw55.gof.strategy;

/**
 * Created by xiayiwei on 12/18/16.
 */
public class Main {
    public static void main(String[] args) {
        Context context = new Context(new NewUserStrategy());
        context.printPrice(10);
        Context context2 = new Context(new OldUserStrategy());
        context2.printPrice(10);

    }
}

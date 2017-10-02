package com.xyw55.gof.mediator;

/**
 * Created by xiayiwei on 12/17/16.
 */
public class Main {
    public static void main(String[] args) {
        President president = new President();
        Development development = new Development(president, "development");
        Financial financial = new Financial(president, "financial");
        Market market = new Market(president, "market");

        development.selfAction();
        development.outAction();

    }
}

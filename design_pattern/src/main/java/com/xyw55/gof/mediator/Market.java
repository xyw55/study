package com.xyw55.gof.mediator;

/**
 * Created by xiayiwei on 12/17/16.
 */
public class Market implements Department {
    private Mediator mediator;
    private String name;

    public Market(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        mediator.register(name, this);
    }

    @Override
    public void selfAction() {
        System.out.println(name + "sold production.");
    }

    @Override
    public void outAction() {
        System.out.println(name + "plan a activity, need money");
        mediator.commond("financial");
    }
}

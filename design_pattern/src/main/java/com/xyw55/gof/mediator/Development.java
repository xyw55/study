package com.xyw55.gof.mediator;

/**
 * Created by xiayiwei on 12/17/16.
 */
public class Development implements Department {
    private Mediator mediator;
    private String name;

    public Development(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        mediator.register(name, this);
    }

    @Override
    public void selfAction() {
        System.out.println(name + " coding");
    }

    @Override
    public void outAction() {
        System.out.println(name + " server is over, need new server");
        mediator.commond("financial");
    }
}

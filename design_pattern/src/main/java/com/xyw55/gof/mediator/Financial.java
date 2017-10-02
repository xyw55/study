package com.xyw55.gof.mediator;

/**
 * Created by xiayiwei on 12/17/16.
 */
public class Financial implements Department {
    private Mediator mediator;
    private String name;

    public Financial(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        mediator.register(name, this);
    }

    @Override
    public void selfAction() {
        System.out.println(name + " manage money. get money");
    }

    @Override
    public void outAction() {
        System.out.println(name + " send monney");
    }
}

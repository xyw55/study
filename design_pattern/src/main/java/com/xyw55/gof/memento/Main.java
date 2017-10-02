package com.xyw55.gof.memento;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiayiwei on 12/18/16.
 */
public class Main {
    public static void main(String[] args) {
        CareTake taker = new CareTake();
        Emp emp = new Emp("55", 15);

        taker.addMemento(emp.memento());
        System.out.println(JSON.toJSONString(emp));
        emp.setAge(16);
        taker.addMemento(emp.memento());
        System.out.println(JSON.toJSONString(emp));
        emp.setAge(17);
        System.out.println(JSON.toJSONString(emp));

        emp.recovery(taker.getLastMemento());
        System.out.println(JSON.toJSONString(emp));

        emp.recovery(taker.getLastMemento());
        System.out.println(JSON.toJSONString(emp));

    }
}

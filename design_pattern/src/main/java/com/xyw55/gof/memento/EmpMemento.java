package com.xyw55.gof.memento;

/**
 * Created by xiayiwei on 12/18/16.
 */
// 备忘录类
public class EmpMemento {
    private String name;
    private int age;

    public EmpMemento(Emp emp) {
        this.name = emp.getName();
        this.age = emp.getAge();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

package com.xyw55.gof.memento;

/**
 * Created by xiayiwei on 12/18/16.
 */
// 源发器类
public class Emp {
    private String name;
    private int age;

    // 进行备忘操作,返回备忘录对象
    public EmpMemento memento() {
        return new EmpMemento(this);
    }

    // 进行数据恢复,恢复成指定备忘录的值
    public void recovery(EmpMemento mmt) {
        this.name = mmt.getName();
        this.age = mmt.getAge();
    }

    public Emp(String name, int age) {
        this.name = name;
        this.age = age;
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

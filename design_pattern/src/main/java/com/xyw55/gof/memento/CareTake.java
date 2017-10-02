package com.xyw55.gof.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiayiwei on 12/18/16.
 */
// 负责人类, 负责管理备忘录
public class CareTake {
    private List<EmpMemento> empMementoList = new ArrayList<>();

    public void addMemento(EmpMemento empMemento) {
        empMementoList.add(empMemento);
    }

    // 按顺序逐个恢复
    public EmpMemento getLastMemento() {
        if (empMementoList.size() <= 0) {
            return null;
        }
        int index = empMementoList.size() - 1;
        EmpMemento result = empMementoList.get(index);
        empMementoList.remove(index);
        return result;
    }

}

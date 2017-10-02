package com.xyw55.gof.chainOfResp;

/**
 * Created by xiayiwei on 12/13/16.
 */
public class Main {
    public static void main(String[] args) {
        Leader a = new Director("director");
        Leader b = new Manger("manager");
        Leader c = new GeneralManager("generaManager");

        // 组织责任链关系
        a.setNextLeader(b);
        b.setNextLeader(c);

        // 开始请假操作
        LeaveRequest request = new LeaveRequest("tom", "gogogog", 40);
        a.handlerRequest(request);

    }
}

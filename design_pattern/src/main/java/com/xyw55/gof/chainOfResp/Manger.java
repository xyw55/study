package com.xyw55.gof.chainOfResp;

/**
 * Created by xiayiwei on 12/12/16.
 */
public class Manger extends Leader {
    public Manger(String name) {
        super(name);
    }

    @Override
    public void handlerRequest(LeaveRequest leaveRequest) {
        if (leaveRequest.getDays() < 10) {
            System.out.println("员工: " + leaveRequest.getName() + " 请假 " + leaveRequest.getDays() + "天,理由: " +
                    leaveRequest.getReason());
            System.out.println("manager: " + this.name + " 审批通过.");
        } else {
            if (this.nextLeader != null) {
                this.nextLeader.handlerRequest(leaveRequest);
            }
        }
    }
}

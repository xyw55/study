package com.xyw55.gof.chainOfResp;

/**
 * Created by xiayiwei on 12/13/16.
 */
public class GeneralManager extends Leader{
    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handlerRequest(LeaveRequest leaveRequest) {
        if (leaveRequest.getDays() < 30) {
            System.out.println("员工: " + leaveRequest.getName() + " 请假 " + leaveRequest.getDays() + "天,理由: " +
                    leaveRequest.getReason());
            System.out.println("generalManager: " + this.name + " 审批通过.");
        } else {
            System.out.println("请假时间过长,no");
        }
    }
}

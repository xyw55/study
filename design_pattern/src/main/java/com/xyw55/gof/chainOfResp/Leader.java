package com.xyw55.gof.chainOfResp;

/**
 * Created by xiayiwei on 12/12/16.
 */
public abstract class Leader {
    protected String name;
    protected Leader nextLeader;

    public Leader(String name) {
        this.name = name;
    }

    // 设置责任链上的后继对象
    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    /**
     * 设置责任链上核心处理方法
     * @param leaveRequest
     */
    public abstract void handlerRequest(LeaveRequest leaveRequest);
}

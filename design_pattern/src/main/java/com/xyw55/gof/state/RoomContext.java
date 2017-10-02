package com.xyw55.gof.state;

/**
 * Created by xiayiwei on 12/18/16.
 */
public class RoomContext {
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        System.out.println("modify state");
        this.state = state;
        state.handle();
    }
}

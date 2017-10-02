package com.xyw55.gof.state;

/**
 * Created by xiayiwei on 12/18/16.
 */
public class Main {
    public static void main(String[] args) {
        RoomContext ctx = new RoomContext();
        ctx.setState(new FreeSate());

        ctx.setState(new BookSate());
    }
}

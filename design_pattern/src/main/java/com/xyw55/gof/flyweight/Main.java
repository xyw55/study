package com.xyw55.gof.flyweight;

/**
 * Created by xiayiwei on 12/11/16.
 */
public class Main {
    public static void main(String[] args) {
        ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("black");
        ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("black");
        System.out.println(chess1);
        System.out.println(chess2);

        System.out.println("增加外部状态--------");
        chess1.display(new Coordinate(1,2));
        chess2.display(new Coordinate(2,1));

    }
}

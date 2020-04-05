/*
 * @(#) SpiralPrint.java 2020-03-28
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.xyw55.other;

/**
 *
 * 螺旋打印
 * @author xyw55
 * @version 2020-03-28
 */
public class SpiralPrint {

    private void solution(int n) {
        int edgeSize = (int) Math.ceil(Math.sqrt(n));
        int x = 0;
        int y = 0;
        int num = 1;
        int flag = 1;
        int size = edgeSize;
        int[][] result = new int[edgeSize][edgeSize];
        while (true) {
            if (flag == 1) {
                for (int i = 0; i < size; i++) {
                    result[x][y] = num;
                    y++;
                    num++;
                }
                y--;
                x++;
                flag = 2;
                size--;
            } else if (flag == 2) {
                for (int i = 0; i < size; i++) {
                    result[x][y] = num;
                    x++;
                    num++;
                }
                x--;
                y--;
                flag = 3;
            } else if (flag == 3) {
                for (int i = 0; i < size; i++) {
                    result[x][y] = num;
                    y--;
                    num++;
                }
                y++;
                x--;
                flag = 4;
                size--;
            } else if (flag == 4) {
                for (int i = 0; i < size; i++) {
                    result[x][y] = num;
                    x--;
                    num++;
                }
                x++;
                y++;
                flag = 1;
            }


            if (size < 0 || num > n) {
                break;
            }
        }

        for (int i = 0; i < edgeSize; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < edgeSize; j++) {
                stringBuilder.append(result[i][j]).append(" ");
            }
            System.out.println(stringBuilder.toString());

        }


    }

    public static void main(String[] args) {
        SpiralPrint spiralPrint = new SpiralPrint();
        spiralPrint.solution(16);

    }

}

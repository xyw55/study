/*
 * @(#) GenerateParenthess.java 2019-10-13
 *
 * Copyright 2019 NetEase.com, Inc. All rights reserved.
 */

package com.xyw55.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author xyw55
 * @version 2019-10-13
 */
public class GenerateParenthess {

    /**
     * BFS
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        Queue<Item> queue = new LinkedBlockingQueue<>();

        queue.add(new Item("(", 1, 0));
        while (!queue.isEmpty()) {
            Item item = queue.poll();
            if (item.data.length() == n * 2) {
                ret.add(item.data);
                continue;
            }
            if (item.lefttNum > item.righttNum) {
                queue.add(new Item(item.data + ")", item.lefttNum, item.righttNum + 1));
            }
            if (item.lefttNum < n) {
                queue.add(new Item(item.data + "(", item.lefttNum + 1, item.righttNum));
            }
        }

        return ret;
    }


    class Item {
        public Item(String data, int lefttNum, int righttNum) {
            this.data = data;
            this.lefttNum = lefttNum;
            this.righttNum = righttNum;
        }

        String data;
        int lefttNum;
        int righttNum;
    }

    public static void main(String[] args) {
        GenerateParenthess generateParenthess = new GenerateParenthess();

        for (String item : generateParenthess.generateParenthesis(4)) {
            System.out.println(item);
        }
    }
}
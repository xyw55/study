/*
 * @(#) LongestValidParentheses.java 2019-11-03
 *
 * Copyright 2019 NetEase.com, Inc. All rights reserved.
 */

package com.xyw55.other;

/**
 * leetcode 32. Longest Valid Parentheses
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 * @author xyw55
 * @version 2019-11-03
 */
public class LongestValidParentheses {


    /**
     * 动态规划
     * index  0 1 2 3 4 5 6 7 8 9
     * output 0 2 2 0 2 6 6 0 2 10
     * input  ( ) ( ( ) ) ( ( ) )
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {

        if (null == s || s.length() == 0) {
            return 0;
        }
        int[] longestValidParenthessesNUmber = new int[s.length()];
        longestValidParenthessesNUmber[0] = 0;
        int max = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (s.charAt(i - 1) == '(') {
                    longestValidParenthessesNUmber[i] = 0;
                } else {
                    longestValidParenthessesNUmber[i] = longestValidParenthessesNUmber[i - 1];
                }
            } else {
                if (i - 1 - longestValidParenthessesNUmber[i - 1] >= 0 && s.charAt(i - 1 - longestValidParenthessesNUmber[i - 1]) == '(') {
                    longestValidParenthessesNUmber[i] = longestValidParenthessesNUmber[i - 1 - longestValidParenthessesNUmber[i - 1]] + longestValidParenthessesNUmber[i - 1] + 2;
                    max = max > longestValidParenthessesNUmber[i] ? max :
                            longestValidParenthessesNUmber[i];
                } else {
                    longestValidParenthessesNUmber[i] = 0;
                }
            }
        }
        for (int i = 0; i < longestValidParenthessesNUmber.length; i++) {
            System.out.println(longestValidParenthessesNUmber[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
//        System.out.println(longestValidParentheses.longestValidParentheses("(()"));
//        System.out.println(longestValidParentheses.longestValidParentheses(")))()())"));
        System.out.println(longestValidParentheses.longestValidParentheses("()(())(())"));

    }




}

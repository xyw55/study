/*
 * @(#) RegularExpressionMatching.java 2019-09-15
 *
 * Copyright 2019 NetEase.com, Inc. All rights reserved.
 */

package com.xyw55.string;

/**
 * leetcode 10
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 *
 * @author xyw55
 * @version 2019-09-15
 */
public class RegularExpressionMatching {


    /**
     * 递归
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        } else if (s.length() > 0 && p.length() == 0) {
            return false;
        }
        /**
         * 从后往前找,递归
         * 从正则表达式找
         * =-1，就是空字符串
         */
        int j = s.length() - 1;
        int i = p.length() - 1;
        if (p.charAt(i) == '*') {
            // 1. 不等于或者s为空字符串，则跳过*
            if (j == -1 || (p.charAt(i - 1) != '.' && p.charAt(i - 1) != s.charAt(j))) {
                return isMatch(s.substring(0, j + 1), p.substring(0, i - 1));
            }
            // 2. 等于，2.1 跳过，2.2 匹配一个， 匹配多个
            while (!isMatch(s.substring(0, j + 1), p.substring(0, i - 1))) {
                // 不等于
                if (j <= -1 || (p.charAt(i - 1) != '.' && p.charAt(i - 1) != s.charAt(j))) {
                    return false;
                }
                // 等于
                j--;

            }
            return true;
        } else if (j != -1 && (p.charAt(i) == s.charAt(j) || p.charAt(i) == '.')) {
            return isMatch(s.substring(0, j), p.substring(0, i));
        }
        return false;
    }


    /**
     * 2D DP
     * 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
     * 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
     * 3, If p.charAt(j) == '*':
     * here are two sub conditions:
     * 1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
     * 2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
     * dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
     * or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
     * or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for (int i = 2; i < n + 1; i = i + 2) {
            if (p.charAt(i - 1) == '*' && dp[0][i - 2]) {
                dp[0][i] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 2 + 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i][j + 1] || dp[i + 1][j] || dp[i + 1][j - 2 + 1]);
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
//        System.out.println(regularExpressionMatching.isMatch2("mississippi", "mis*is*p*."));
//        System.out.println(regularExpressionMatching.isMatch2("aaa", "aaaa"));
//        System.out.println(regularExpressionMatching.isMatch2("a", "ab*a"));
//        System.out.println(regularExpressionMatching.isMatch2("aa", "a*"));
//        System.out.println(regularExpressionMatching.isMatch2("ab", ".*"));
//        System.out.println(regularExpressionMatching.isMatch2("aab", "c*a*b*"));
//        System.out.println(regularExpressionMatching.isMatch2("a", ".*..a*"));
        System.out.println(regularExpressionMatching.isMatch2("", ".*"));
    }
}
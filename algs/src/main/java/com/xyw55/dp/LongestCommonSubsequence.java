/*
 * @(#) LongestCommonSubsequence.java 2020-04-05
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.xyw55.dp;

/**
 * leetcode 1143. Longest Common Subsequence
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 *
 * A subsequence of a string is a new string generated from the original string with
 * some characters(can be none) deleted without changing the relative order of the remaining characters.
 * (eg, "ace" is a subsequence of "abcde" while "aec" is not).
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 *
 * If there is no common subsequence, return 0.
 * @author xyw55
 * @version 2020-04-05
 */
public class LongestCommonSubsequence {
    /**
     * 递归
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0){
            return 0;
        }
        if (text1.length() > text2.length()) {
            return longestCommonSubsequence(text2, text1);
        }
        int result = 0;
        int i = text1.length();
        int j = text2.length();
        if (text1.charAt(i-1) == text2.charAt(j-1)) {
            result = longestCommonSubsequence(text1.substring(0,i-1),
                    text2.substring(0,j-1)) + 1;
        } else {
            result = Math.max(longestCommonSubsequence(text1.substring(0,i-1),
                    text2.substring(0,j)),
                    longestCommonSubsequence(text1.substring(0,i),
                            text2.substring(0,j-1)));
        }
        return result;

    }

    /**
     * dp
     * 使用两位数组存储运算情况，
     * 递推公式为，如果text1[i] == text2[j],tmp[i][j] = tmp[i-1][j-1] + 1;
     * 否则为tmp[i][j] = Math.max(tmp[i-1][j], tmp[i][j-1]);
     */
    public int longestCommonSubsequence2(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0){
            return 0;
        }
        if (text1.length() > text2.length()) {
            return longestCommonSubsequence(text2, text1);
        }
        int t1 = text1.length();
        int t2 = text2.length();
        int[][] tmpResult = new int[t1+1][t2+1];
        tmpResult[0][0] = 0;
        for (int i = 0; i <= text1.length(); i++) {
            tmpResult[i][0] = 0;
        }
        for (int i = 0; i <= text2.length(); i++) {
            tmpResult[0][i] = 0;
        }

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    tmpResult[i][j] = tmpResult[i-1][j-1] + 1;
                } else {
                    tmpResult[i][j] = Math.max(tmpResult[i][j-1], tmpResult[i-1][j]);
                }
            }
        }

        return tmpResult[t1][t2];
    }



}

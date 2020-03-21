/*
 * @(#) MinimunWindowsSubstring.java 2020-03-21
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.xyw55.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 76. Minimum Window Substring
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 * @author xyw55
 * @version 2020-03-21
 */
public class MinimunWindowsSubstring {

    /**
     * BF
     * 时间复杂度O(N^2)
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        String result = "";
        int[] flags = new int[t.length()];
        for (int i = 0; i < flags.length; i++) {
            flags[i] = -1;
        }
        // 计算是否满足条件
        boolean valid = false;
        for (int right = 0; right < s.length(); right++) {
            // 取当前字符在t中flags[tIndex]中值最小的为tIndex
            String currentLetter = s.substring(right, right + 1);
            int tIndex = s.length() + 1;
            int sIndex = s.length() + 1;
            for (int i = 0; i < t.length(); i++) {
                if (t.substring(i, i + 1).equals(currentLetter)) {
                    if (flags[i] < sIndex) {
                        sIndex = flags[i];
                        tIndex = i;
                    }
                }
            }
            // 发生替换
            if (tIndex <= s.length()) {
                flags[tIndex] = right;
                if (!valid) {
                    boolean tempValid = true;
                    for (int i = 0; i < flags.length; i++) {
                        if (flags[i] < 0) {
                            tempValid = false;
                        }
                    }
                    valid = tempValid;
                }
                if (valid) {
                    // 获取flags中左右边界
                    int start = s.length(), end = 0;
                    for (int flag : flags) {
                        start = Math.min(start, flag);
                        end = Math.max(end, flag);
                    }
                    if ("".equals(result) || (end + 1 - start) < result.length()) {
                        result = s.substring(start, end + 1);
                    }
                }
            }
        }
        return result;
    }

    /**
     * two pointer method
     * 1. 移动右指针，直到满足t
     * 2.是否满足，计算当前窗口值
     * 3.移动左指针，如果符合，计算窗口值，继续移动左指针，直到不符合
     * 时间复杂度O(N)
     * @param s
     * @param t
     * @return
     */
    public String minWindow2(String s, String t) {
        String result = "";
        int left = 0;
        // 优化点：可以只用tCount，不需要flags，节约内存，
        // 另外判断是否满足条件太复杂，可以用一个uniqueLetter统计
        // 每次到uniqueLetter到0,就是满足条件
        Map<Integer, Integer> flags = new HashMap<>();

        Map<Integer, Integer> tCount = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char letter = t.charAt(i);
            tCount.put(letter - 'a', tCount.getOrDefault(letter - 'a', 0) + 1);
        }
        //1. 移动右指针，直到满足t
        for (int right = 0; right < s.length(); right++) {
            char letter = s.charAt(right);
            flags.put(letter - 'a', flags.getOrDefault(letter - 'a', 0) + 1);

            // 2.是否满足，计算当前窗口值
            boolean valid = true;
            for (Map.Entry<Integer, Integer> entry : tCount.entrySet()) {
                if (entry.getValue() > flags.getOrDefault(entry.getKey(), 0)) {
                    valid = false;
                }
            }
            // 3.移动左指针，如果符合，计算窗口值，继续移动左指针，直到不符合
            if (valid) {
                while (left <= right) {
                    if ("".equals(result) || right + 1 - left < result.length()) {
                        result = s.substring(left, right + 1);
                    }
                    int leftLetterIndex = s.charAt(left) - 'a';
                    int leftCnt = flags.get(leftLetterIndex);
                    flags.put(leftLetterIndex, --leftCnt);
                    left++;
                    if (tCount.getOrDefault(leftLetterIndex, 0) > leftCnt) {
                        break;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MinimunWindowsSubstring solution = new MinimunWindowsSubstring();
//        System.out.println(solution.longestSubstring("1", 1));
        System.out.println(solution.minWindow2("ADOBECODEBANC",
                "ABC"));
        System.out.println(solution.minWindow2("AA",
                "AA"));
    }
}

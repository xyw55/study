/*
 * @(#) LongestSubstringWithKRepeatingChar.java 2020-03-21
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.xyw55.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 395. Longest Substring with At Least K Repeating Characters
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
 *
 * Example 1:
 * Input:
 * s = "aaabb", k = 3
 * Output:
 * 3
 *
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 * Input:
 * s = "ababbc", k = 2
 * Output:
 * 5
 *
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 *
 * @author xyw55
 * @version 2020-03-21
 */
public class LongestSubstringWithKRepeatingChar {

    /**
     * 递归
     * 1.找出所有不符合的char，
     * 2.对原字符串以不符合的字符为切割点分成多个
     * 3.对子字符串递归
     * 时间复杂度为O(NlogN)，最坏N^2
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        int max = s.length();
        Map<String, Integer> stat = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String letter = s.substring(i, i + 1);
            stat.put(letter, stat.getOrDefault(letter, 0) + 1);
        }
        // 如果都不符合，可以直接return 0;
        boolean allNotMatch = true;
        List<String> regexList = new ArrayList();
        for (Map.Entry<String, Integer> entry : stat.entrySet()) {
            if (entry.getValue() >= k) {
                allNotMatch = false;
            } else {
                regexList.add(entry.getKey());
                max = 0;
            }
        }
        if (allNotMatch) {
            return 0;
        }
        if (regexList.isEmpty()) {
            return max;
        }
        String regex = String.join("|", regexList);
        String[] subStrings = s.split(regex);
        for (String subString : subStrings) {
            int result = longestSubstring(subString, k);
            if (result > max) {
                max = result;
            }
        }
        return  max;
    }

    /**
     * 方法二，可以参考leetcode 76. Minimum Window Substring的解法
     * 依次查找1个，2个...字符出现K次的最长子字符串，
     * 因为都是小写字母，时间复杂度为O(26N)
     * @param args
     */

    public static void main(String[] args) {
        LongestSubstringWithKRepeatingChar solution = new LongestSubstringWithKRepeatingChar();
        System.out.println(solution.longestSubstring("1", 1));

    }
}

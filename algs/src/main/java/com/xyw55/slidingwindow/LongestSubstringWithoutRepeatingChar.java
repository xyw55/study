/*
 * @(#) LongestSubstringWithoutRepeatingChar.java 2019-09-08
 *
 * Copyright 2019 NetEase.com, Inc. All rights reserved.
 */

package com.xyw55.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * leetcode 3
 * Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * @author xyw55
 * @version 2019-09-08
 */
public class LongestSubstringWithoutRepeatingChar {

    /**
     * 常规暴力解法
     * 双指针，但是主指针移动慢，每次需要副指针从主指针位置重新移动
     * O(n^2)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }
        int maxLength = 1;

        char[] stringArr = s.toCharArray();
        for (int i = 0; i < stringArr.length - 1; i++) {
            List<Character> subString = new ArrayList<>();
            subString.add(stringArr[i]);
            int j = i + 1;
            for (; j < stringArr.length; j++) {
                // i移动太慢了
                int index = subString.indexOf(stringArr[j]);
                if (index == -1) {
                    subString.add(stringArr[j]);
                } else {
                    i = i + index;
                    break;
                }
            }
            maxLength = Math.max(maxLength, subString.size());
            if (stringArr.length - i < maxLength) {
                break;
            }
        }
        return maxLength;
    }

    /**
     * 双指针法
     * 将经过字符记录在map中，这样主指针可以快速移动，存在重复是，才移动副指针
     * O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }
        int maxLength = 1;
        HashMap<Character, Integer> letterIndex = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (letterIndex.containsKey(s.charAt(i))) {
                j = Math.max(j, letterIndex.get(s.charAt(i)) + 1);
            }
            letterIndex.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChar longestSubstringWithoutRepeatingChar = new LongestSubstringWithoutRepeatingChar();
        System.out.println(longestSubstringWithoutRepeatingChar.lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(longestSubstringWithoutRepeatingChar.lengthOfLongestSubstring2("bbbbb"));
        System.out.println(longestSubstringWithoutRepeatingChar.lengthOfLongestSubstring2("pwwkew"));
        System.out.println(longestSubstringWithoutRepeatingChar.lengthOfLongestSubstring2("au"));
        System.out.println(longestSubstringWithoutRepeatingChar.lengthOfLongestSubstring2("aab"));
        System.out.println(longestSubstringWithoutRepeatingChar.lengthOfLongestSubstring2("dvdf"));
    }
}

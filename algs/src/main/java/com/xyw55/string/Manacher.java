package com.xyw55.string;

/**
 * leetcode 5
 * Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Created by xiayiwei on 10/25/17.
 */
public class Manacher {

    /**
     * time complexity O(n)
     * 字符间加#号，这样奇偶字符串处理逻辑一样
     * 利用回文中右半部分是对称与左半部分，所以当右半部分的回文不超过右边界，则最长回文就是左半部分对应的长度，所以可以直接得出，不需要遍历
     * @param str
     */
    static void findLongestPalindromicSubstring(String str) {
        char[] temp = str.toCharArray();
        StringBuilder sb = new StringBuilder("#");
        for (char aTemp : temp) {
            sb.append(aTemp).append("#");
        }

        temp = sb.toString().toCharArray();

        int[] rl = new int[sb.length()];

        rl[0] = 1;
        int pos = 0;
        int maxRight = 1;

        int maxPos = 0;

        for (int i = 1; i < temp.length; i++) {
            if (maxRight > i) {
                rl[i] = Math.min(rl[2 * pos - i] ,  maxRight - i);
            } else {
                rl[i] = 1;
            }
            while (i + rl[i] < temp.length && i >= rl[i] && temp[i + rl[i]] == temp[i - rl[i]]) {
                if (maxRight < i + rl[i]) {
                    maxRight = i + rl[i];
                    pos = i;
                }
                rl[i]++;
            }
            maxPos = rl[maxPos] >= rl[i] ? maxPos : i;
        }

//        for (int i = 1; i < rl.length; i = i + 2) {
//            System.out.print(rl[i] - 1);
//        }
        int start = 0;
        int end = 0;
        if ((maxPos - rl[maxPos]) % 2 == 0) {
            start = maxPos - rl[maxPos] + 1;
            end = maxPos + rl[maxPos] - 1;
        } else {
            start = maxPos - rl[maxPos] + 2;
            end = maxPos + rl[maxPos] - 2;
        }

        System.out.println(str.substring((start-1)/2,(end+1)/2));



    }

    public static void main(String[] args) {
        Manacher.findLongestPalindromicSubstring("abaaerrrrrdxgdfvdaaassds");
    }
}

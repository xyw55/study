package com.xyw55.string;

/**
 * Created by xiayiwei on 10/25/17.
 */
public class Manacher {

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
        }

        for (int i = 1; i < rl.length; i = i + 2) {
            System.out.print(rl[i] - 1);
        }

    }

    public static void main(String[] args) {
        Manacher.findLongestPalindromicSubstring("abaaerrrrrdxgdfvdaaassds");
    }
}

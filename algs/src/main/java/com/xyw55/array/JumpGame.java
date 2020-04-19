/*
 * @(#) JumpGame.java 2020-04-20
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.xyw55.array;

/**
 * leetcode55. Jump Game
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 *
 * @author xyw55
 * @version 2020-04-20
 */
public class JumpGame {

    /**
     * 从后往前寻找，并通过一个flag记录探查结果
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if(nums.length <= 1) {
            return true;
        }
        int[] flag = new int[nums.length];
        for(int i = nums.length-2 ; i >= 0; i--) {
            if (i + nums[i] >= nums.length-1) {
                flag[i] = 1;
                continue;
            }
            for(int j = 0; j <= nums[i]; j++) {
                if (flag[i + j] == 1) {
                    flag[i] = 1;
                    break;
                }
            }

        }
        return flag[0] == 1;
    }

    /**
     * 从前往后找，当前index+nums[index] 就是最大向右探索范围，i在这之内移动，如果超过nums.length-1,就说明可达
     * @param args
     */

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        int[] data = new int[]{2, 3, 1, 1, 4};
        System.out.println(jumpGame.canJump(data));
    }
}

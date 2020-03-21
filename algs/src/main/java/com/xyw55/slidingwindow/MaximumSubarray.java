/*
 * @(#) MaximumSubarray.java 2020-03-21
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.xyw55.slidingwindow;

/**
 * leetcode 53. Maximum Subarray
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * @author xyw55
 * @version 2020-03-21
 */
public class MaximumSubarray {
    /**
     * DP，preSum
     * 时间复杂度O(N)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int prevSum = Integer.MIN_VALUE;
        for(int i=0; i < nums.length; i++) {

            if (prevSum > 0) {
                prevSum = prevSum + nums[i];
                // 越界
                // if (prevSum + nums[i] < 0) {
                //     return Integer.MAX_VALUE;
                // }
            } else {
                prevSum = nums[i];
            }
            if (prevSum > max) {
                max = prevSum;
            }
        }
        return max;
    }
}

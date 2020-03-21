/*
 * @(#) SubarraySumEqualsK.java 2020-03-21
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.xyw55.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 560. Subarray Sum Equals K
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 *
 * @author xyw55
 * @version 2020-03-21
 */
public class SubarraySumEqualsK {

    /**
     * preSum + map
     * 时间复杂度O(N)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int total = 0;
        // [0,i]的累加和 -> 出现次数
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        int preSum = 0;
        for(int i=0; i < nums.length; i++) {
            int zeroToISum = preSum + nums[i];
            if(sumMap.get(zeroToISum -k) != null) {
                total += sumMap.get(zeroToISum -k);
            }
            sumMap.put(zeroToISum , sumMap.getOrDefault(zeroToISum, 0) + 1);
            preSum = zeroToISum;
        }

        return total;
    }
}

/*
 * @(#) ClimbingStairs.java 2020-04-13
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.xyw55.dp;

/**
 * LeetCode 70. Climbing Stairs
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * @author xyw55
 * @version 2020-04-13
 */
public class ClimbingStairs {
    /**
     * 没什么好说的，金典的爬楼梯问题
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int result = 0;
        int prev_prev = 1;
        int prev = 2;
        for (int i = 3; i <= n; i++) {
            result = prev + prev_prev;
            prev_prev = prev;
            prev = result;
        }
        return result;

    }
}

/*
 * @(#) ContainerWithMostWater.java 2019-06-02
 *
 * Copyright 2019 NetEase.com, Inc. All rights reserved.
 */

package com.xyw55.array;

/**
 * leetcode No.11
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 * @author xyw55
 * @version 2019-06-02
 */
public class ContainerWithMostWater {


    /**
     * 暴力求解时间复杂度O(n^2)
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int lineNumber = height.length;
        int maxValue = 0;
        for (int i = 0; i < lineNumber - 1; i++) {
            for (int j = 1; j < lineNumber; j++) {
                int minHeight = height[i] > height[j] ? height[j] : height[i];
                int tempValue = minHeight * (j - i);
                maxValue = maxValue > tempValue ? maxValue : tempValue;
            }
        }
        return maxValue;
    }

    /**
     * 头尾双指针方，时间复杂度O(n)
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int maxValue = 0;
        int head = 0;
        int end = height.length - 1;
        while (head < end) {
            int minHeight = height[head] > height[end] ? height[end] : height[head];
            int tempValue = (end - head) * minHeight;
            maxValue = maxValue > tempValue ? maxValue : tempValue;

            if (height[head] > height[end]) {
                end--;
            } else {
                head++;
            }
        }

        return maxValue;
    }

    /**
     * 比较可以采用Math库
     * @param height
     * @return
     */
    public int maxArea3(int[] height) {
        int maxValue = 0;
        int head = 0;
        int end = height.length - 1;
        while (head < end) {
            maxValue = Math.max(maxValue, (end - head) * Math.min(height[head], height[end]));
            if (height[head] > height[end]) {
                end--;
            } else {
                head++;
            }
        }

        return maxValue;
    }


    public static void main(String[] args) {

    }

}

/*
 * @(#) MedianTwoSortedArrays.java 2019-09-08
 *
 * Copyright 2019 NetEase.com, Inc. All rights reserved.
 */

package com.xyw55.array;

/**
 * leetcode 4
 * Median of Two Sorted Arrays
 * here are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * @author xyw55
 * @version 2019-09-08
 */
public class MedianTwoSortedArrays {
    /**
     * 普通解法：取每个数据的头尾，依次比较头尾，逐渐向中心靠拢，最后剩下0，1，2个元素，才比较大小，取结果
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1Head = 0;
        int num1Tail = nums1.length - 1;

        int num2Head = 0;
        int num2Tail = nums2.length - 1;


        while (num1Head < num1Tail && num2Head < num2Tail) {
            if (nums1[num1Head] < nums2[num2Head]) {
                num1Head = num1Head + 1;
            } else {
                num2Head = num2Head + 1;
            }

            if (nums1[num1Tail] > nums2[num2Tail]) {
                num1Tail = num1Tail - 1;
            } else {
                num2Tail = num2Tail - 1;
            }
        }
        while (num1Head < num1Tail) {
            if (num2Head > num2Tail) {
                if (num1Head + 1 == num1Tail) {
                    return (nums1[num1Head] + nums1[num1Tail]) / 2.0;
                } else {
                    num1Head = num1Head + 1;
                    num1Tail = num1Tail - 1;
                }
            } else if (nums2[num2Head] < nums1[num1Head]) {
                num2Head++;
                num1Tail--;
            } else if (nums2[num2Tail] > nums1[num1Tail]) {
                num2Tail--;
                num1Head++;
            } else {
                num1Head = num1Head + 1;
                num1Tail = num1Tail - 1;
            }
        }

        while (num2Head < num2Tail) {
            if (num1Head > num1Tail) {
                if (num2Head + 1 == num2Tail) {
                    return (nums2[num2Head] + nums2[num2Tail]) / 2.0;
                } else {
                    num2Head = num2Head + 1;
                    num2Tail = num2Tail - 1;
                }
            } else if (nums1[num1Head] < nums2[num2Head]) {
                num1Head++;
                num2Tail--;
            } else if (nums1[num1Tail] > nums2[num2Tail]) {
                num1Tail--;
                num2Head++;
            } else {
                num2Head = num2Head + 1;
                num2Tail = num2Tail - 1;
            }
        }


        if (num1Head == num1Tail) {
            if (num2Head == num2Tail) {
                return (nums1[num1Head] + nums2[num2Head]) / 2.0;
            } else if (num2Head > num2Tail) {
                return nums1[num1Head];
            } else if (nums1[num1Head] > nums2[num2Head] && nums1[num1Head] > nums2[num2Tail]) {
                return nums2[num2Tail];
            } else if (nums1[num1Head] < nums2[num2Head] && nums1[num1Head] < nums2[num2Tail]) {
                return nums2[num2Head];
            } else {
                return nums1[num1Head];
            }
        } else if (num1Head < num1Tail) {
            if (num2Head == num2Tail) {
                if (nums2[num2Head] < nums1[num1Head]) {
                    return nums1[num1Head];
                } else if (nums2[num2Tail] > nums1[num1Tail]) {
                    return nums1[num1Tail];
                } else {
                    return nums2[num2Head];
                }
            } else {
                return (nums1[num1Head] + nums1[num1Tail]) / 2.0;
            }
        } else {
            if (num2Head == num2Tail) {
                return nums2[num2Head];
            } else {
                return (nums2[num2Head] + nums2[num2Tail]) / 2.0;
            }

        }

    }

    /**
     * 二分法
     * 将arr1，arr2分布分成左右两个数组，l1,l2 和r1,r1 正好是均分两个数组的，保证l1 < r2, l2< r1, 就可以保证l < r,这样根据奇偶数 需要取一个或两个元素就行
     * 参考视频：https://www.youtube.com/watch?v=LPFhl65R7ww
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays2(nums2, nums1);
        }
        int low = 0;
        int high = nums1.length;
        while (low <= high) {
            // 计算分割位置
            int m1 = (low + high) / 2;
            int m2 = (nums1.length + nums2.length + 1) / 2 - m1;
            // 计算各自分区的最大最小值
            int l1 = (m1 == 0) ? Integer.MIN_VALUE : nums1[m1-1];
            int r1 = (m1 == nums1.length) ? Integer.MAX_VALUE : nums1[m1];
            int l2 = (m2 == 0) ? Integer.MIN_VALUE : nums2[m2-1];
            int r2 = (m2 == nums2.length) ? Integer.MAX_VALUE : nums2[m2];

            // 调整分割位置
            if (l1 > r2) {
                high = m1 - 1;
            } else if (l2 > r1) {
                low = m1 + 1;
            } else {
                // 计算结果
                if ((nums1.length + nums2.length) % 2 == 1) {
                    return Math.max(l1,l2);
                } else {
                    return (Math.max(l1,l2) + Math.min(r1,r2)) / 2.0;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        MedianTwoSortedArrays medianTwoSortedArrays = new MedianTwoSortedArrays();
        int[] nums1 = new int[2];
        nums1[0] = 1;
        nums1[1] = 3;
        int[] nums2 = new int[1];
        nums2[0] = 2;
        System.out.println(medianTwoSortedArrays.findMedianSortedArrays2(nums1, nums2));

        int[] nums3 = new int[2];
        nums3[0] = 1;
        nums3[1] = 2;
        int[] nums4 = new int[2];
        nums4[0] = 3;
        nums4[1] = 4;
        System.out.println(medianTwoSortedArrays.findMedianSortedArrays2(nums3, nums4));


    }
}

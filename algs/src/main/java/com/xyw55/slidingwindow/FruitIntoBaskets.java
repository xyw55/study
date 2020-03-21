/*
 * @(#) FruitIntoBaskets.java 2020-03-21
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.xyw55.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 904. Fruit Into Baskets
 *
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 *
 * You start at any tree of your choice, then repeatedly perform the following steps:
 *
 * Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 * Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 * Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
 *
 * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
 *
 * What is the total amount of fruit you can collect with this procedure?
 *
 * Example 1:
 *
 * Input: [1,2,1]
 * Output: 3
 * Explanation: We can collect [1,2,1].
 * Example 2:
 *
 * Input: [0,1,2,2]
 * Output: 3
 * Explanation: We can collect [1,2,2].
 * If we started at the first tree, we would only collect [0, 1].
 * Example 3:
 *
 * Input: [1,2,3,2,2]
 * Output: 4
 * Explanation: We can collect [2,3,2,2].
 * If we started at the first tree, we would only collect [1, 2].
 * Example 4:
 *
 * Input: [3,3,3,1,2,1,1,2,3,3,4]
 * Output: 5
 * Explanation: We can collect [1,2,1,1,2].
 * If we started at the first tree or the eighth tree, we would only collect 4 fruits.
 * @author xyw55
 * @version 2020-03-21
 */
public class FruitIntoBaskets {
    /**
     * two pointer method
     * 1. 移动右指针，直到满足t
     * 2.是否满足，计算当前窗口值
     * 3.移动左指针，如果符合，计算窗口值，继续移动左指针，直到不符合
     * 时间复杂度O(N)
     * @param tree
     * @return
     */
    public int totalFruit(int[] tree) {
        int result = 0;
        int start = 0;
        int end = 0;
        int unique = 0;
        // fruit -> counter
        Map<Integer, Integer> indexMap = new HashMap<>();

        for(;end < tree.length; end++ ) {
            // 1. 移动右指针，
            if (indexMap.containsKey(tree[end])) {
                indexMap.put(tree[end], indexMap.getOrDefault(tree[end], 0) +1);
            } else if (unique < 2) {
                indexMap.put(tree[end], indexMap.getOrDefault(tree[end], 0) +1);
                unique++;
            } else {
                // 2.新字符出现，移动左指针,直到其中一个减到0为止
                while(start < end) {
                    int count = indexMap.get(tree[start]);
                    indexMap.put(tree[start], --count);
                    if (count == 0) {
                        indexMap.remove(tree[start]);
                        unique--;
                    }
                    start++;
                    if (unique <2) {
                        break;
                    }
                }
                // 加入新的字符
                indexMap.put(tree[end], indexMap.getOrDefault(tree[end], 0) +1);
                unique++;
            }
            // 3.计算最大长度
            result = Math.max(result, end + 1 - start);
        }
        return result;
    }
}

/*
 * @(#) CoinChange.java 2020-04-05
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.xyw55.dp;

/**
 * leetcode 322. Coin Change
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * @author xyw55
 * @version 2020-04-05
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int[] amountFewestCoin = new int[amount+1];
        amountFewestCoin[0] = 0;
        for(int i = 1; i < amount+1; i++) {
            int currentCoinCount = -1;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 &&
                        amountFewestCoin[i - coins[j]] != -1) {
                    if (currentCoinCount == -1) {
                        currentCoinCount = amountFewestCoin[i - coins[j]] + 1;
                    }
                    currentCoinCount = Math.min(currentCoinCount, amountFewestCoin[i - coins[j]] + 1);

                }

            }
            amountFewestCoin[i] = currentCoinCount;
        }
        return amountFewestCoin[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = new int[]{2,5};
        System.out.println(coinChange.coinChange(coins, 3));
    }
}

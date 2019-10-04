/*
 * @(#) LetterCombinationsOfPhoneNumber.java 2019-10-02
 *
 * Copyright 2019 NetEase.com, Inc. All rights reserved.
 */

package com.xyw55.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 17. Letter Combinations of a Phone Number
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 * @author xyw55
 * @version 2019-10-02
 */
public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> numberLetter = new HashMap<>();
        numberLetter.put('2', "abc");
        numberLetter.put('3', "def");
        numberLetter.put('4', "ghi");
        numberLetter.put('5', "jkl");
        numberLetter.put('6', "mno");
        numberLetter.put('7', "pqrs");
        numberLetter.put('8', "tuv");
        numberLetter.put('9', "wxyz");

        Queue<String> stringQueue = new LinkedBlockingQueue<>();
        stringQueue.add("");
        for (int i = 0; i < digits.length(); i++) {
            String letter = numberLetter.get(digits.charAt(i));
            while (stringQueue.peek().length() == i) {
                String temp = stringQueue.poll();
                for (int j = 0; j < letter.length(); j++) {

                    stringQueue.add(temp + letter.charAt(j));
                }
            }
        }
        List<String> result = new ArrayList<>();
        while (!stringQueue.isEmpty()) {
            result.add(stringQueue.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber letterCombinationsOfPhoneNumber = new LetterCombinationsOfPhoneNumber();
        for (String item : letterCombinationsOfPhoneNumber.letterCombinations("98")) {
            System.out.println(item);
        }
    }
}

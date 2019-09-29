/*
 * @(#) ValidParenthess.java 2019-09-29
 *
 * Copyright 2019 NetEase.com, Inc. All rights reserved.
 */

package com.xyw55.stack;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * @author xyw55
 * @version 2019-09-29
 */
public class ValidParenthess {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.add(s.charAt(i));
            } else if ((s.charAt(i) == ')' && stack.empty())
                    || (s.charAt(i) == '}' && stack.empty())
                    || (s.charAt(i) == ']' && stack.empty())) {
                return false;
            } else if ((s.charAt(i) == ')' && stack.peek() != '(')
                    || (s.charAt(i) == '}' && stack.peek() != '{')
                    || (s.charAt(i) == ']' && stack.peek() != '[')) {
                return false;
            } else if ((s.charAt(i) == ')' && stack.peek() == '(')
                    || (s.charAt(i) == '}' && stack.peek() == '{')
                    || (s.charAt(i) == ']' && stack.peek() == '[')) {
                stack.pop();
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        ValidParenthess validParenthess = new ValidParenthess();
        System.out.println(validParenthess.isValid("]"));
        System.out.println(validParenthess.isValid(""));
        System.out.println(validParenthess.isValid("()"));
        System.out.println(validParenthess.isValid("()[]{}"));
        System.out.println(validParenthess.isValid("(]"));
        System.out.println(validParenthess.isValid("([)]"));
        System.out.println(validParenthess.isValid("{[]}"));
    }
}

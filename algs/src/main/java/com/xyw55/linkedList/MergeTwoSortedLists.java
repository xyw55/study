/*
 * @(#) MergeTwoSortedLists.java 2019-10-02
 *
 * Copyright 2019 NetEase.com, Inc. All rights reserved.
 */

package com.xyw55.linkedList;

/**
 * leetcode 21
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * @author xyw55
 * @version 2019-10-02
 */
public class MergeTwoSortedLists {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        // 构造空头节点
        ListNode head = new ListNode(0);
        ListNode curr = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                curr = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                curr = l2;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            curr.next = l2;
        } else if (l2 == null) {
            curr.next = l1;
        }
        return head.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode result = mergeTwoSortedLists.mergeTwoLists(ListNode.createListNodes(new int[]{ 2}), null);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

/*
 * @(#) MergeKSortedLists.java 2019-10-13
 *
 * Copyright 2019 NetEase.com, Inc. All rights reserved.
 */

package com.xyw55.linkedList;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 *
 * @author xyw55
 * @version 2019-10-13
 */
public class MergeKSortedLists {
    /**
     * 1. recursion and use merge two sorted list
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        }
        int middle = lists.length / 2;
        ListNode[] lists1 = new ListNode[middle];
        ListNode[] lists2 = new ListNode[lists.length - middle];
        for (int i = 0; i < lists.length; i++) {
            if (i < middle) {
                lists1[i] = lists[i];
            } else {
                lists2[i - middle] = lists[i];
            }
        }
        ListNode listNode1 = mergeKLists(lists1);
        ListNode listNode2 = mergeKLists(lists2);
        return mergeTwoLists(listNode1, listNode2);
    }

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


    /**
     * method2 : use Priority Queue
     * add List to queue, and sort head element in queue
     * so queue head is min element, you can get min element every time until queue is empty
     */
    public ListNode mergeKLists2(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val)
                    return -1;
                else if (o1.val == o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists)
            if (node != null)
                queue.add(node);

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
    }


}

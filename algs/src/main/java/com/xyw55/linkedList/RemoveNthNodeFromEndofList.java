package com.xyw55.linkedList;

/**
 * Created by xiayiwei on 10/3/17.
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        int i = 0;
        for (; slow != null; i++) {
            slow = slow.next;
        }
        int m = i - (n-1) % i;

        ListNode prev = null;
        ListNode curr = head;
        for (; m > 1; m--) {
            prev = curr;
            curr = curr.next;
        }

        if (prev == null) {
            return head.next;
        }
        prev.next = curr.next;
        return head;
    }
}

package com.xyw55.linkedList;

/**
 * Created by xiayiwei on 9/30/17.
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(-1);
        ListNode rightHead = new ListNode(-1);

        ListNode left = leftHead;
        ListNode right = rightHead;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }

        right.next = null;
        left.next = rightHead.next;
        return leftHead.next;

    }


}

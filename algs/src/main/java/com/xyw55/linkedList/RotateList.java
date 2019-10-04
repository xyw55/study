package com.xyw55.linkedList;

/**
 * Created by xiayiwei on 10/1/17.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 计算长度和尾节点
        ListNode tail = dummy;
        int length = 0;
        for (;tail.next != null; length++) {
            tail = tail.next;
        }

        // 找到分割点
        int m = length - k % length;
        ListNode prev = dummy;
        for (; m > 0; m--) {
            prev = prev.next;
        }

        // 旋转
        tail.next = dummy.next;
        dummy.next = prev.next;
        prev.next = null;

        return prev.next;
    }

    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        rotateList.rotateRight(ListNode.createListNodes(new int[]{1, 2}), 0);
    }
}

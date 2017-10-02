package com.xyw55.linkedList;

/**
 * Created by xiayiwei on 9/25/17.
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            if (curr.val == next.val) {
                curr.next = next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        head = prev;
        ListNode curr = head.next;
        ListNode lastSameNode = null;

        while (curr != null) {
            if (lastSameNode != null && curr.val == lastSameNode.val) {
                prev.next = curr.next;
            } else if(curr.next != null && curr.val == curr.next.val) {
                lastSameNode = curr;
                prev.next = curr.next.next;
            } else {
                prev = curr;
            }
            curr = prev.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedList removeDuplicatesfromSortedList = new RemoveDuplicatesfromSortedList();
        removeDuplicatesfromSortedList.deleteDuplicates(ListNode.createLIstNodes(new int[]{3, 5}));
    }
}

package com.xyw55.linkedList;

/**
 * Created by xiayiwei on 9/29/17.
 */
public class PalindromeLinkedList {
    /**
     * 对前半部分逆序,比较两部分
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;

        ListNode prev = new ListNode(-1);
        prev.next = head;

        // 对前半部分逆序
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode tempNode = slow.next;
            slow.next = prev.next;
            prev.next = slow;
            slow = tempNode;
        }
        // 奇数个
        if (fast != null) {
            slow = slow.next;
        }

        // 比较
        while (slow != null && slow.val == prev.next.val) {
            slow = slow.next;
            prev = prev.next;
        }
        return slow == null;
    }

    public static void main(String[] args) {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        palindromeLinkedList.isPalindrome(ListNode.createLIstNodes(new int[]{1, 2}));
    }


}

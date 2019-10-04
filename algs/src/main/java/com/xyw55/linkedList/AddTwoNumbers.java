package com.xyw55.linkedList;

/**
 * Created by xiayiwei on 10/2/17.
 */
public class AddTwoNumbers {

    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

     You may assume the two numbers do not contain any leading zero, except the number 0 itself.

     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // 互换 保证l1 > l2
        if (p2 != null) {
            ListNode tempHead = l1;
            l1 = l2;
            l2 = tempHead;
            p1 = p2;
        }

        ListNode head = l1;

        int carry = 0;
        ListNode prev = null;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            l1.val = sum % 10;
            carry = sum / 10;
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        // 处理 进位问题
        while (carry > 0) {
            if (l1 == null) {
                prev.next = new ListNode(carry);
                break;
            }
            int sum = l1.val + carry;
            l1.val = sum % 10;
            carry = sum / 10;
            prev = l1;
            l1 = l1.next;
        }

        return head;
    }

    /**
     * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

     You may assume the two numbers do not contain any leading zero, except the number 0 itself.

     Follow up:
     What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

     Example:

     Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 8 -> 0 -> 7
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // 互换 保证l1 > l2
        if (p2 != null) {
            ListNode tempHead = l1;
            l1 = l2;
            l2 = tempHead;
            p1 = p2;
        }

        ListNode res = sum(l1, l2, p1);
        if (res.val == 0) {
            res = res.next;
        }
        return res;

    }

    private ListNode sum(ListNode l1, ListNode l2, ListNode p1) {
        // 到最后一个节点
        if (l1.next == null) {
            int sum = l1.val + l2.val;
            l1.val = sum % 10;
            int carry = sum / 10;
            ListNode head = new ListNode(carry);
            head.next = l1;
            return head;
        }

        ListNode res;
        if (p1 != null) {
            // l1 长的部分
            res = sum(l1.next, l2, p1.next);
            l1.next = res.next;

            int sum = l1.val + res.val;
            l1.val = sum % 10;
            int carry = sum / 10;
            ListNode head = new ListNode(carry);
            head.next = l1;
            return head;
        } else {
            // l1 l2 一起计算的部分
            res = sum(l1.next, l2.next, p1);
            l1.next = res.next;

            int sum = l1.val + l2.val + res.val;
            l1.val = sum % 10;
            int carry = sum / 10;
            ListNode head = new ListNode(carry);
            head.next = l1;
            return head;
        }
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.addTwoNumbers2(ListNode.createListNodes(new int[]{ 1}),
                ListNode.createListNodes(new int[]{9,9,9,9}));
    }
}

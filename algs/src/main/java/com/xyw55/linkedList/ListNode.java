package com.xyw55.linkedList;

/**
 * Created by xiayiwei on 9/25/17.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static ListNode createLIstNodes(int[] numbers) {
        ListNode head = null;
        ListNode curr = null;
        for (int i=0; i < numbers.length; i++){
            if (head == null) {
                head = new ListNode(numbers[i]);
                curr = head;
            }else{
                curr.next = new ListNode(numbers[i]);
                curr = curr.next;
            }
        }
        return head;
    }}

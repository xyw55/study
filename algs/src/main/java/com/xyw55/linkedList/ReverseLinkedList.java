package com.xyw55.linkedList;


public class ReverseLinkedList {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 构造一个新的头结点,应对整个链表都翻转的情况
        ListNode pHead = new ListNode(-1);
        pHead.next = head;
        head = pHead;
        // 找到第一个要翻转的前一个节点
        for(int i = 0; i < m-1; i++){
            pHead = pHead.next;
        }
        ListNode curr = pHead.next;
        // prev 翻转的第一个节点,需要指向翻转的后一个节点
        ListNode prev = curr;
        for(int i = m; i <= n; i++){
            // 依次讲节点插入
            ListNode tempNode = curr.next;
            curr.next = pHead.next;
            pHead.next = curr;
            curr = tempNode;
            // prev指向下一个节点
            prev.next = tempNode;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.reverseBetween(ListNode.createLIstNodes(new int[]{3, 5}), 1, 2);
    }
}

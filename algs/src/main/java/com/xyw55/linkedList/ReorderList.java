package com.xyw55.linkedList;

/**
 * Created by xiayiwei on 10/1/17.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return ;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        // 奇数个节点时,右边节点多一个
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 将前半部分很后半部分分割
        prev.next = null;

        // 倒序
        ListNode right = reverse(slow);

        // merge
        ListNode curr = head;
        ListNode tempNode = null;
        while (curr != null) {
            if (curr.next == null) {
                curr.next = right;
                break;
            }
            tempNode = right.next;

            right.next = curr.next;
            curr.next = right;
            curr = curr.next.next;

            right = tempNode;
        }

    }

    public ListNode reverse(ListNode head) {
        ListNode currentNode = head;
        head = null;
        while(null != currentNode){
            ListNode next = currentNode.next;
            currentNode.next = head;
            head = currentNode;
            currentNode = next;
        }
        return head;
    }


    public void reorderList2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return ;
        }

        ListNode slow = head;
        ListNode fast = head;
        // 奇数个节点时,左边节点多一个
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 倒序
        ListNode right = reverse(slow.next);

        // 将前半部分很后半部分分割
        slow.next = null;

        // merge, 右边元素往左边塞
        ListNode curr = head;
        ListNode tempNode;
        while (right != null) {
            tempNode = right.next;

            right.next = curr.next;
            curr.next = right;
            curr = curr.next.next;

            right = tempNode;
        }

    }

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList2(ListNode.createLIstNodes(new int[]{1,2,3}));
    }
}

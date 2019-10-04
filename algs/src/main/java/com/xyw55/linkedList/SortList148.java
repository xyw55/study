package com.xyw55.linkedList;

/**
 * Created by xiayiwei on 9/26/17.
 */
public class SortList148 {
    public ListNode quickSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode leftHead = null;
        ListNode rightHead = null;
        ListNode leftTail = null;
        ListNode rightTail = null;
        ListNode middle = null;

        ListNode curr = head;
        while (curr != null) {
            if (middle == null) {
                middle = curr;
            } else if (curr.val < middle.val) {
                if (leftHead == null) {
                    leftHead = leftTail = curr;
                } else {
                    leftTail.next = curr;
                    leftTail = curr;
                }
            } else {
                 if (rightHead == null) {
                     rightHead = rightTail = curr;
                 } else {
                     rightTail.next = curr;
                     rightTail = curr;
                 }
            }
            ListNode tempNode = curr.next;
            curr.next = null;
            curr = tempNode;
        }

        leftHead = quickSortList(leftHead);
        rightHead = quickSortList(rightHead);

        if (rightHead != null) {
            middle.next = rightHead;
        }
        if (leftHead != null) {
            leftTail = leftHead;
            while (leftTail.next != null) {
                leftTail = leftTail.next;
            }
            leftTail.next = middle;
            return leftHead;
        } else {
            return middle;
        }
    }


    public ListNode mergeSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // cut two parts
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // 递归调用 归并排序
        ListNode left = mergeSortList(head);
        ListNode right = mergeSortList(slow);

        // merge
        ListNode result = new ListNode(-1);
        ListNode curr = result;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        curr.next = (left != null ? left : right);
        return result.next;
    }


    /**
     * 简单两层for循环,
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = head;
        ListNode p = dummy;
        ListNode tempNode = null;
        while (curr != null) {
            tempNode = curr.next;
            // 这一步速度提升明显
            // 如果curr节点比当前节点小,则从头开始比较大小插入,否则只需从上次插入的节点比较
            if (curr.val < p.val){
                p = dummy;
            }

            while (p.next != null && p.next.val < curr.val) {
                p = p.next;
            }

            curr.next = p.next;
            p.next = curr;
            curr = tempNode;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        SortList148 sortList148 = new SortList148();
//        sortList148.mergeSortList(com.xyw55.linkedList.ListNode.createListNodes(new int[]{3,2,4}));
        sortList148.insertionSortList(ListNode.createListNodes(new int[]{1,1}));
    }
}

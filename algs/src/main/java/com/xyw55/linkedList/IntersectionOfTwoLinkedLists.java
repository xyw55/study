package com.xyw55.linkedList;

/**
 * For example, the following two linked lists:

 A:          a1 → a2
                     ↘
                     c1 → c2 → c3
                     ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.


 * Created by xiayiwei on 9/28/17.
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLinkListLength(headA);
        int lengthB = getLinkListLength(headB);
        int diff = lengthA - lengthB;
        if (diff > 0) {
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else if (diff < 0) {
            while (diff < 0) {
                headB = headB.next;
                diff++;
            }
        }

        while (headA != null && headB != null) {
            if (headA.val == headB.val) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;

    }

    private int getLinkListLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    /**
     * 很精妙的解法
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists intersectionOfTwoLinkedLists = new IntersectionOfTwoLinkedLists();
        intersectionOfTwoLinkedLists.getIntersectionNode(ListNode.createLIstNodes(new int[]{1}),
                ListNode.createLIstNodes(new int[]{}));
    }
}

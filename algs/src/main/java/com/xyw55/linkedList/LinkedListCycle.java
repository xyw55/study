package com.xyw55.linkedList;

/**
 * Created by xiayiwei on 9/30/17.
 */
public class LinkedListCycle {
    /**
     * k快慢节点移动,耗时非常大
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 大神解法,将所有经过的节点的next都指向head节点,如果有循环,肯定会指到head节点
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        ListNode p1 = head, p2;

        while (p1 != null && p1.next != null) {
            if (p1.next == head) {
                return true;
            }
            p2 = p1.next;
            p1.next = head;
            p1 = p2;
        }

        return false;
    }


    /**
     * Define two pointers slow and fast. Both start at head node, fast is twice as fast as slow. If it reaches the end it means there is no cycle, otherwise eventually it will eventually catch up to slow pointer somewhere in the cycle.

     Let the distance from the first node to the the node where cycle begins be A, and let say the slow pointer travels travels A+B. The fast pointer must travel 2A+2B to catch up. The cycle size is N. Full cycle is also how much more fast pointer has traveled than slow pointer at meeting point.

     A+B+N = 2A+2B
     N=A+B
     From our calculation slow pointer traveled exactly full cycle when it meets fast pointer, and since originally it travled A before starting on a cycle, it must travel A to reach the point where cycle begins! We can start another slow pointer at head node, and move both pointers until they meet at the beginning of a cycle.
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode slow2 = head;
                while (slow2 != slow){
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow;

            }
        }
        return null;
    }


}

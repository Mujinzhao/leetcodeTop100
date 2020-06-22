package LeetCodeTop100;

import LeetCodeBaseDate.ListNode;

/**
 * 这题写法很多，这里试着转化一下问题变成，有环链表的环入口
 */
public class 链表相交160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode tempHeadA = headA;
        ListNode tempHeadB = headB;
        while(tempHeadA.next != null){
            tempHeadA = tempHeadA.next;
        }
        while(tempHeadB.next != null){
            tempHeadB = tempHeadB.next;
        }
        //保证一定有交点
        if(tempHeadA != tempHeadB){
            return null;
        }
        tempHeadA.next = headA;
        ListNode fast = headB.next.next;
        ListNode slow = headB.next;
        while(fast != slow){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode cur1 = headB;
        ListNode cur2 = slow;
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        tempHeadA.next = null;
        return cur1;
    }
}

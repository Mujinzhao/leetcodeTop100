package LeetCodeTop100;

import LeetCodeBaseDate.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断链表是否有环
 */
public class CircleList141 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        if(head.next == head){
            return true;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != slow && fast!=null){
            fast = fast.next;
            if(fast!=null){
                fast = fast.next;
            }
            slow = slow.next;
        }
        if(fast == null){
            return false;
        }
        return true;
    }

    /**
     * 还可以采用 哈希表的方法：看某个节点值是不是已经出现了即可
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet();
        while(head != null){
            if(set.contains(head)){
                return true;
            }else{
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }
}

package LeetCodeTop100;

import LeetCodeBaseDate.ListNode;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *
 * 如果再加一个 找出环的长度，那么从加点开始累加，再次到这个点的时候就能算出来长度了
 *
 *
 * 链表判环的入口，证明：https://www.jianshu.com/p/83eed68cbb46
 *
 */
public class 链表环入口142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == head){
            return head;
        }
        if(head.next == null){
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while(fast != slow && fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast == null||fast.next == null){
            return null;
        }
        ListNode start = head;
        ListNode end = slow;
        while(start != end){
            start = start.next;
            end = end.next;
        }
        return end;
    }
}

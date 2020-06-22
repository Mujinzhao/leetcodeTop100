package LeetCodeTop100;

/**
 * @ClassName 分割链表86
 * @Author zhangxinkun
 * @Date 2019/12/26  10:53 PM
 * @Version 1.0
 */

import LeetCodeBaseDate.ListNode;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 解析 ：虚拟指针法
 */
public class 分割链表86 {

    public ListNode partition(ListNode head, int x) {
        ListNode temoHead = head;
        ListNode temp = head.next;
        if(temp == null){
            return head;
        }
        while(temp!=null &&temp.next != null){
            if(temp.next.val < x){
                ListNode nextNode = temp.next;
                temp.next = nextNode.next;
                nextNode.next = temoHead.next;
                head.next = nextNode;
                temoHead.next = nextNode;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5  = new ListNode(5);
        ListNode listNode6  = new ListNode(2);

        ListNode head = new ListNode(-1);
        head.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        分割链表86 test = new 分割链表86();
        test.partition(head,3);
    }
}

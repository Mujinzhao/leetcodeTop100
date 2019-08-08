package LeetCodeTop100;

/**
 * @ClassName SumTowNumber2
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/8/8  2:48 PM
 * @Version 1.0
 */

import LeetCodeBaseDate.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumTowNumber2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1 = this.reverseList(l1);
        l2 = this.reverseList(l2);

        if(l1 == null){
            return this.reverseList(l2);
        }
        if(l2 == null){
            return this.reverseList(l1);
        }
        if(l1.next == null && l1.val == 0){
            return this.reverseList(l2);
        }
        if(l2.next == null && l2.val == 0){
            return this.reverseList(l1);
        }

        ListNode resultEmptyList = new ListNode(-1);
        resultEmptyList.next = null;
        ListNode tail = resultEmptyList;
        int upBit = 0;
        while(l1!=null && l2 != null){
            int sum = l1.val + l2.val;
            ListNode temp = new ListNode((sum+upBit)%10);
            upBit = (sum + upBit)/10;
            tail.next = temp;
            temp.next = null;
            tail = temp;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            ListNode temp = new ListNode((l1.val + upBit)%10);
            upBit = (l1.val+upBit)/10;
            tail.next = temp;
            l1 = l1.next;
            temp.next = null;
            tail = temp;
        }
        while(l2 != null){
            ListNode temp = new ListNode((l2.val + upBit)%10);
            upBit = (l2.val+upBit)/10;
            tail.next = temp;
            l2 = l2.next;
            temp.next = null;
            tail = temp;
        }
        if(upBit != 0){
            ListNode last = new ListNode(upBit);
            tail.next = last;
            last.next = null;
        }
        return this.reverseList(resultEmptyList.next);
    }

    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode NewHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return NewHead;
    }

    public void pint(ListNode head){
        ListNode node = head;
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args){
        SumTowNumber2 instance = new SumTowNumber2();

        ListNode listNode1 = new ListNode(9);
        ListNode listNode2 = new ListNode(9);
        ListNode listNode3 = new ListNode(9);
        ListNode listNode4 = new ListNode(9);
        ListNode listNode5  = new ListNode(9);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;

        instance.pint(listNode1);


        ListNode Node1 = new ListNode(1);
//        ListNode Node2 = new ListNode(6);
//        ListNode Node3 = new ListNode(7);

        Node1.next = null;
//        Node2.next = Node3;
//        Node3.next = null;
        instance.pint(Node1);


        ListNode nHead = instance.addTwoNumbers(listNode1,Node1);

        instance.pint(nHead);
    }
}

package LeetCodeTop100;

import LeetCodeBaseDate.ListNode;

import java.util.List;

/**
 * @ClassName ReverseListFromMtoN
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/8/7  2:19 PM
 * @Version 1.0
 */
public class ReverseListFromMtoN92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) {
            return head;
        }

        if(head == null || head.next == null){
            return head;
        }

        ListNode emptyHead = new ListNode(-1);
        ListNode NewHead = head;
        emptyHead.next = head;

        ListNode from = head;

        int begin = 1;
        if(m != 1){
            while(begin < m){
                NewHead = from;
                from = from.next;
                begin++;
            }
        }else if(m == 1){
            NewHead = emptyHead;
            from = head;
        }
        ListNode cur = from.next;
        while(begin < n){
            from.next = cur.next;
            cur.next = NewHead.next;
            NewHead.next = cur;
            cur = from.next;
            begin++;
        }
        return emptyHead.next;
    }


    public void pint(ListNode head){
        ListNode node = head;
        while(node != null){
            System.out.println(node.getVal());
            node = node.next;
        }
    }

    public static void main(String[] args){
        ReverseListFromMtoN92 instance = new ReverseListFromMtoN92();

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5  = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;

        instance.pint(listNode1);

        ListNode nHead = instance.reverseBetween(listNode1,2,5);

        instance.pint(nHead);
    }
}

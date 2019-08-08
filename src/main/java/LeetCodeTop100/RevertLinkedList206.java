package LeetCodeTop100;

import LeetCodeBaseDate.ListNode;

/**
 * @ClassName RevertLinkedList206
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/8/7  11:19 AM
 * @Version 1.0
 */
public class RevertLinkedList206 {

    //非递归方式
    public ListNode reverseList1(ListNode head){
        if(head == null || head.next == null) {
            return head;
        }

        ListNode emptyNode = new ListNode(-1);
        emptyNode.next = head;

        ListNode cur = head.next;
        //原来的head 就是翻转 过后的尾部节点
        while(cur != null){
            head.next = cur.next;
            cur.next = emptyNode.next;
            emptyNode.next = cur;
            cur = head.next;
        }

        return emptyNode.next;
    }

    //递归方式
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
        RevertLinkedList206 instance = new RevertLinkedList206();

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5  = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        instance.pint(listNode1);

        ListNode nHead = instance.reverseList(listNode1);

        instance.pint(nHead);
    }
}

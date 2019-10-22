package LeetCodeTencentTop50;

import LeetCodeBaseDate.ListNode;

/**
 * @ClassName MergeSortLinked21
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/10/22  11:29 PM
 * @Version 1.0
 */
public class MergeSortLinked21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return null;
    }

    public static void main(String[] arg){
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode10  = new ListNode(10);

        listNode2.next = listNode4;
        listNode4.next = listNode6;
        listNode6.next = listNode8;
        listNode8.next = listNode10;
        listNode10.next = null;

        ListNode listNode1 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode9  = new ListNode(9);

        listNode1.next = listNode3;
        listNode3.next = listNode5;
        listNode5.next = listNode7;
        listNode7.next = listNode9;
        listNode9.next = null;

        MergeSortLinked21 test = new MergeSortLinked21();
        test.mergeTwoLists(listNode2,listNode1);
    }
}

package LeetCodeTencentTop50;

import LeetCodeBaseDate.ListNode;

/**
 * @ClassName MergeSortLinked21
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/10/22  11:29 PM
 * @Version 1.0
 */

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 解题思路：可以直接按照数组排序的思想进行链表排序；
 * 这里学习一下递归的写法！！！！
 */
public class MergeSortLinked21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode leftH = new ListNode(Integer.MAX_VALUE);
        ListNode rightH = new ListNode(Integer.MAX_VALUE);
        if(l1 == null || l2 == null){
            return (l1 == null) ? l2 : l1;
        }
        leftH.next = l1;
        rightH.next = l2;
        ListNode leftCur = l1;
        ListNode rightCur = l2;
        while(leftCur != null && rightCur != null){
            if(leftCur.val <= rightCur.val){
                leftH.next = leftCur;
                leftCur = leftCur.next;
            }else {
                int temp = leftCur.val;
                leftCur.val = rightCur.val;
                rightCur.val = temp;

                rightH.next = rightCur.next;
                rightCur.next = leftCur.next;
                leftCur.next = rightCur;
                rightCur = rightH.next;
                leftCur = leftCur.next;
            }
        }
        if(rightCur != null){
            leftH.next.next = rightCur;
        }
        return l1;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists1(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists1(l1,l2.next);
            return l2;
        }
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
        ListNode temp = test.mergeTwoLists1(listNode2,listNode1);
        int a = 0;
    }
}

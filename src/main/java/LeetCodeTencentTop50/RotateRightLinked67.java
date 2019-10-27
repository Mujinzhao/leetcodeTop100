package LeetCodeTencentTop50;

/**
 * @ClassName RotateRightLinked67
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/10/24  12:04 AM
 * @Version 1.0
 * **/

import LeetCodeBaseDate.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 解题思路：思路还是好想的，只需要将找到需要断开的地方，然后把指针变一下就行
 */
public class RotateRightLinked67 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return head;
        }
        int sum = 0;
        ListNode cur = head;
        while(cur != null){
            sum++;
            cur = cur.next;
        }
        k = k%sum;
        if(k == 0){
            return head;
        }
        ListNode pre = head;
        while(k != 0){
            pre = pre.next;
            k--;
        }
        ListNode last = head;
        while(pre.next != null){
            pre = pre.next;
            last = last.next;
        }
        pre.next = head;
        head = last.next;
        last.next = null;
        return head;
    }

    public static void main(String[] args){
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
        RotateRightLinked67 test = new RotateRightLinked67();
        ListNode temp = test.rotateRight(listNode2,3);
        int a = 0;
    }
}

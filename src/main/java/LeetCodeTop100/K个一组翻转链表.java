package LeetCodeTop100;

import LeetCodeBaseDate.ListNode;

import java.util.List;

public class K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tempHead = head;
        int num = 0;
        while(tempHead != null){
            num++;
            tempHead = tempHead.next;
        }
        if(k == 1 || num == 1){
            return head;
        }
        ListNode newHead = head;
        for(int i=1;i+k-1<=num;i += k){
            newHead = this.reverseNM(newHead,i,i+k-1);
        }
        return newHead;
    }

    public ListNode reverseNM(ListNode head,int m,int n){
        ListNode tempHead = head;
        if(n == m){
            return head;
        }
        n = n-m + 1;
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode cur1 = preHead;
        ListNode cur2 = head;
        while(m!=1){
            m--;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        ListNode benginNode = cur2;
        ListNode preBegin = cur1;

        while(n != 0){
            n--;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        ListNode endNode = cur2;
        ListNode reverseHead = this.reversList(benginNode,endNode);
        preBegin.next = reverseHead;
        return preHead.next;
    }

    public ListNode reversList(ListNode head,ListNode end){
        if(head == end || head.next == end){
            return head;
        }
        ListNode newHead = reversList(head.next,end);

        head.next.next = head;
        head.next = end;

        return newHead;
    }
}

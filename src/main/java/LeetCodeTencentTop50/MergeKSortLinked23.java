package LeetCodeTencentTop50;

/**
 * @ClassName MergeKSortLinked23
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/10/23  12:30 AM
 * @Version 1.0
 */

import LeetCodeBaseDate.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * case ： [[],[-1,5],[1,4,6],[4,5,6]]
 *
 * 解析：这一题基础算法是有序链表的合并，然后多路合并，自然想到归并排序的算法。
 * 这一题需要牢记的归并排序是访问节点的顺序！！！！！
 * 如 1到10 的访问节点顺序为：
 * start:1, end:2
 * start:1, end:3
 * start:4, end:5
 * start:1, end:5
 * start:6, end:7
 * start:6, end:8
 * start:9, end:10
 * start:6, end:10
 * start:1, end:10
 *
 * 只有2的n次方的数值进行归并时 访问顺序如下：  如8
 * start:1, end:2
 * start:3, end:4
 * start:1, end:4
 * start:5, end:6
 * start:7, end:8
 * start:5, end:8
 * start:1, end:8
 */
public class MergeKSortLinked23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        partitionSolve(lists, 1 ,8);
        return lists[0];
    }

    public void partitionSolve(ListNode[] lists,int start,int end){
        if(start < end){
            int mid = (end - start)/2 + start;
            partitionSolve(lists,start,mid);
            partitionSolve(lists,mid+1,end);
            lists[end] = lists[start] = merge(lists[start],lists[end]);
            System.out.println("start:" + start+", end:"+end);
        }
    }

    public ListNode merge(ListNode start,ListNode end){
        if(start == null){
            return end;
        }
        if(end == null){
            return start;
        }
        if(start.val <= end.val){
            start.next = merge(start.next,end);
            return start;
        }else {
            end.next = merge(start,end.next);
            return end;
        }
    }

    public static void main(String[] args){
        ListNode firstList = null;

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

        ListNode listNode11 = new ListNode(2);
        ListNode listNode12 = new ListNode(7);
        ListNode listNode13 = new ListNode(10);

        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = null;

        ListNode[] pro = {firstList,listNode1,listNode2,listNode11};

        MergeKSortLinked23 test = new MergeKSortLinked23();

        test.mergeKLists(pro);
        int a = 0;
    }
}

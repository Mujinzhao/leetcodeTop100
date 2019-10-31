package LeetCodeTop100;

import LeetCodeBaseDate.ListNode;

import java.util.Random;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * 这一题可以联系几个算法：归并排序，链表的拆分和合并。
 * 其中，归并排序合并两个有序数组的操作也需要牢记。
 */
public class SortLinkedList148 {

    //归并排序
    public void joinSort(int[] nums){
        Sort(nums,0,nums.length-1);
    }

    public void Sort(int[] nums,int start,int end){
        if(start < end){
            int mid = start+(end - start)/2;
            Sort(nums,start,mid);
            Sort(nums,mid+1,end);
            mergeSortNumber(nums,start,mid,end);
        }
    }

    public void mergeSortNumber(int[] nums,int start,int mid,int end){
        int i = start;
        int j = mid + 1;
        int[] temp = new int[end - start +1];
        int begin = 0;
        while(i<=mid && j<=end){
            if(nums[i] < nums[j]){
                temp[begin++] = nums[i];
                i++;
            }else{
                temp[begin++] = nums[j];
                j++;
            }
        }
        while(i <= mid){
            temp[begin++] = nums[i];
            i++;
        }
        while(j <= end){
            temp[begin++] = nums[j];
            j++;
        }
        for(i = start;i<=end ;i++){
            nums[i] = temp[i-start];
        }
    }

    //链表的归并排序，主要有两个操作，一个是确定排序的边界（切割操作），一个是两个有序链表的合并操作
    //这里分别写一下这两个操作，以后这种链表的排序题目能刷到手软

    public ListNode mergeSortLinked(ListNode left,ListNode right){
        ListNode leftH = new ListNode(Integer.MAX_VALUE);
        leftH.next = left;
        ListNode rightH = new ListNode(Integer.MAX_VALUE);
        rightH.next = right;
        while(right!=null && left!=null){
            if(left.val <= right.val){
                left = left.next;
            }else {
                rightH.next = right.next;
                swap(left,right);
                right.next = left.next;
                left.next = right;
                left = left.next;
                right = rightH.next;
            }
        }
        if(right != null){
            left.next = right;
        }
        return leftH.next;
    }

    public void swap(ListNode left,ListNode right){
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
    }

    public static void main(String[] args){
        int[] nums = {4,3,2,7,8,6,1,5};
        SortLinkedList148 test = new SortLinkedList148();
        test.joinSort(nums);
        int a = 1;

        ListNode listNode1 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode9 = new ListNode(9);

        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode10 = new ListNode(10);

        listNode1.next = listNode3;
        listNode3.next = listNode5;
        listNode5.next = listNode7;
        listNode7.next = listNode9;
        listNode9.next = null;

        listNode2.next = listNode4;
        listNode4.next = listNode6;
        listNode6.next = listNode8;
        listNode8.next = listNode10;
        listNode10.next = null;
        test.mergeSortLinked(listNode1,listNode2);
    }
}

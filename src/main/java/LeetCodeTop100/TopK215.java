package LeetCodeTop100;

import LeetCodeBaseDate.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查找数组中第K大的数字：
 * 解法一：最简单的快排序，然后返回第K个数。
 * 解法二：用快排+二分查找的思想进行查找。
 * 解法三：堆排序。
 */
public class TopK215 {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length-1);
        List<Integer> a = new ArrayList<>();
        return nums[k-1];
    }

    /**
     * 解法一：直接快排
     * @param nums
     * @param begin
     * @param end
     */
    public void quickSort(int[] nums,int begin,int end){
        if(begin < end){
            int p = partition(nums,begin,end);
            quickSort(nums,begin,p-1);
            quickSort(nums,p+1,end);
        }
    }
    public int partition(int[] nums,int start,int end){
        int flag = nums[end];
        int i = start;
        for(int j=start;j <= end - 1;j++){
            if(nums[j] > flag){
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i,end);
        return i;
    }
    public void swap(int[] nums,int x,int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    /**
     * 二分 + 快排的思想
     */
    public int findKthLargest1(int[] nums, int k) {
        int len = nums.length-1;
        int left = 0;
        int right = len;
        while(left <= right){
            int mid = partition(nums,left,right);
            if(mid == k-1){
                return nums[mid];
            }else if(mid > k-1){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }

    /**
     * 堆排序 还需要实现！！
     */

}

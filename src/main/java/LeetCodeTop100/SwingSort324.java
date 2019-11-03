package LeetCodeTop100;

import java.util.Arrays;

/**
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 示例 1:
 *
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 示例 2:
 *
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 * 说明:
 * 你可以假设所有输入都会得到有效的结果。
 *
 * 进阶:
 * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 *
 * 先快排序，然后前 n/2个和后n/2个分别逆序排。
 */
public class SwingSort324 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int mid = len%2 == 1 ? len/2: len/2-1;
        int[] smaller = Arrays.copyOfRange(nums,0,mid+1);
        int[] bigger = Arrays.copyOfRange(nums,mid+1,len);
        int count = 0;
        int start1 = mid;
        int start2 = len/2-1;
        while(start1>=0 && start2>=0){
            nums[count++] = smaller[start1--];
            nums[count++] = bigger[start2--];
        }
        if(start1>=0){
            nums[count] = smaller[0];
        }
    }

    public static void main(String[] args){
        SwingSort324 test = new SwingSort324();
        int[] nums = {1,1,2,1,2,2,1};
        test.wiggleSort(nums);
        int a = 0;
    }
}

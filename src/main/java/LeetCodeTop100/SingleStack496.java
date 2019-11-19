package LeetCodeTop100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 *
 * 示例 1:
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 *     对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 *     对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 示例 2:
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于num1中的数字2，第二个数组中的下一个较大数字是3。
 *     对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 注意:
 *
 * nums1和nums2中所有元素是唯一的。
 * nums1和nums2 的数组大小都不超过1000。
 *
 *
 * 单调栈的经典题目  可以反复练习
 */
public class SingleStack496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        if(nums2.length == 1){
            ans[0] = -1;
            return ans;
        }
        if(nums2.length == 0){
            return ans;
        }
        Map<Integer,Integer> nums1Map = new HashMap();
        for(int i=0;i<nums1.length;i++){
            nums1Map.put(nums1[i],i);
        }
        Stack<Integer> stack = new Stack();
        stack.push(0);
        for(int i=1;i<nums2.length;i++){
            while(!stack.empty() && nums2[i] > nums2[stack.peek()] && i<nums2.length){
                int temp = stack.peek();
                if(nums1Map.get(nums2[temp]) != null){
                    ans[nums1Map.get(nums2[temp])] = nums2[i];
                }
                stack.pop();
            }
            stack.push(i);
        }

        while(!stack.empty()){
            if(nums1Map.get(nums2[stack.peek()]) != null){
                int temp = stack.peek();
                ans[nums1Map.get(nums2[stack.peek()])] = -1;
            }
            stack.pop();
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums1={4,1,2};
        int[] nums = {1,3,4,2};
        SingleStack496 test = new SingleStack496();
        test.nextGreaterElement(nums1,nums);
    }
}

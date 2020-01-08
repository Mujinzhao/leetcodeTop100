package LeetCodeTop100;

/**
 * @ClassName 最接近的三数之和16
 * @Author zhangxinkun
 * @Date 2019/12/31  9:58 AM
 * @Version 1.0
 */

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 解析：标签：排序和双指针
 * 本题目因为要计算三个数，如果靠暴力枚举的话时间复杂度会到 O(n^3)O(n
 * 3
 *  )，需要降低时间复杂度
 * 首先进行数组排序，时间复杂度 O(nlogn)O(nlogn)
 * 在数组 nums 中，进行遍历，每遍历一个值利用其下标i，形成一个固定值 nums[i]
 * 再使用前指针指向 start = i + 1 处，后指针指向 end = nums.length - 1 处，也就是结尾处
 * 根据 sum = nums[i] + nums[start] + nums[end] 的结果，判断 sum 与目标 target 的距离，如果更近则更新结果 ans
 * 同时判断 sum 与 target 的大小关系，因为数组有序，如果 sum > target 则 end--，如果 sum < target 则 start++，如果 sum == target 则说明距离为 0 直接返回结果
 * 整个遍历过程，固定值为 n 次，双指针为 n 次，时间复杂度为 O(n^2)O(n
 * 2
 *  )
 * 总时间复杂度：O(nlogn) + O(n^2)
 */
public class 最接近的三数之和16 {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        Arrays.sort(nums);
        int len = nums.length;
        if(len < 3){
            return 0;
        }
        if(len == 3){
            return nums[0]+nums[1]+nums[2];
        }
        for(int i=0;i<=len-3;i++){
            int resume = target - nums[i];
            int left = i+1;
            int right = len-1;
            while(left < right){
                int sum = nums[left] + nums[right];
                if(sum < resume){
                    left++;
                }else if(sum >= resume){
                    right--;
                }
                if(min > Math.abs(target - (nums[i] + sum))){
                    min = Math.abs(target - (nums[i] + sum));
                    ans = (nums[i] + sum);
                }
            }
        }
        return ans;
    }
}

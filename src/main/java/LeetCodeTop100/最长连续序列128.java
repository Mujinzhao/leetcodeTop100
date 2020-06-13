package LeetCodeTop100;

/**
 * @ClassName 最长连续序列128
 * @Author zhangxinkun
 * @Date 2020/1/14  12:09 AM
 * @Version 1.0
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 解析：只有那些小一个数字的数才进行计算
 */
public class 最长连续序列128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int temp:nums){
            set.add(temp);
        }
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int begin = nums[i];
                int tempAns = 0;
                while(set.contains(begin)){
                    tempAns++;
                    begin++;
                }
                ans = Math.max(tempAns,ans);
            }
        }
        return ans;
    }
}

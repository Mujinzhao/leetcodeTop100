package LeetCodeTop100;

/**
 * @ClassName 较小的三数之和259
 * @Author zhangxinkun
 * @Date 2019/12/31  10:22 AM
 * @Version 1.0
 */

import java.util.Arrays;

/**
 * 给定一个长度为 n 的整数数组和一个目标值 target，寻找能够使条件 nums[i] + nums[j] + nums[k] < target 成立的三元组  i, j, k 个数（0 <= i < j < k < n）。
 *
 * 示例：
 *
 * 输入: nums = [-2,0,1,3], target = 2
 * 输出: 2
 * 解释: 因为一共有两个三元组满足累加和小于 2:
 *      [-2,0,1]
 *      [-2,0,3]
 * 进阶：是否能在 O(n2) 的时间复杂度内解决？
 *
 * 解析：还是双指针，只不过在计算结果的时候，如果发现有小于目标值产生的时候，要进行区间相加。很简单
 *
 */
public class 较小的三数之和259 {
    public int threeSumSmaller(int[] nums, int target) {
        int len = nums.length;
        int ans = 0;
        if(len < 3){
            return 0;
        }
        Arrays.sort(nums);
        for(int i=0;i<=len-3;i++){
            int resume = target - nums[i];
            int left = i+1;
            int right = len-1;
            while(left < right){
                int sum = nums[left]+nums[right];
                // System.out.println("left:" + left + "right: "+right);
                if(sum < resume){
                    ans += (right - left);
                    left++;
                }else{
                    right--;
                }
            }
        }
        return ans;
    }
}

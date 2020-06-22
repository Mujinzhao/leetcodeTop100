package LeetCodeDynamicMethod;

/**
 * @ClassName 乘积最大子序列152
 * @Author zhangxinkun
 * @Date 2019/12/31  11:25 AM
 * @Version 1.0
 */

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 解析：直接计算 dp[i]为以i结尾的子序列最大乘积，这样计算会丢掉前面序列中连续两个负数提供的价值。
 * 所以同时记录，乘积的最小值。就可以了。
 */
public class 乘积最大子序列152 {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        int[] dp = new int[len];
        int[] dpMin = new int[len];
        dp[0] = nums[0];
        dpMin[0] = nums[0];
        ans = nums[0];
        for(int i=1;i<len;i++){
            // dp[i] = Math.max(nums[i]*dp[i-1],Math.max(nums[i]*dpMin[i-1],nums[i]));
            dp[i] = Math.max(dpMin[i - 1] * nums[i], Math.max(dp[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(nums[i]*dpMin[i-1],Math.min(nums[i]*dp[i-1],nums[i]));
            ans = Math.max(dp[i],ans);
        }
        return ans;
    }
}

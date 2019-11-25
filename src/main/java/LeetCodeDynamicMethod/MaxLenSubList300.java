package LeetCodeDynamicMethod;

/**
 * @ClassName MaxLenSubList300
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/11/11  11:23 PM
 * @Version 1.0
 */

/**
 * 最长上升子序列
 *
 * 动态规划思想：将dp[i] 理解为已N结尾的最长子序列的长度；
 * 那么dp[i] = dp[j]A[i] (0<=j<i && A[j]<A[i])
 *
 * 解法二：二分查找方法，明天看
 */
public class MaxLenSubList300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i] = 1;
        }
        for(int i = 0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
        }
        int max = -1;
        for(int temp:dp){
            if(max < temp){
                max = temp;
            }
        }
        return max;
    }
}

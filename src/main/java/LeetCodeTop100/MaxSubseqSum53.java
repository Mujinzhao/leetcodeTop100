package LeetCodeTop100;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 *
 *
 *
 *
 *
 */
public class MaxSubseqSum53 {
    /**
     * 将dp[i] 理解为以i 结尾的最大子序列和 那么dp[i]就只有两个来源
     * 要么来自 dp[i-1]+nums[i] 要么来自 自身这一个数字nums[i];
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(max < dp[i]){
                max = dp[i];
            }
        }
        return max;
    }
    /**
     * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
     *
     * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
     * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
     * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
     *
     * 返回 A 的最大湍流子数组的长度。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：[9,4,2,10,7,8,8,1,9]
     * 输出：5
     * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
     * 示例 2：
     *
     * 输入：[4,8,12,16]
     * 输出：2
     * 示例 3：
     *
     * 输入：[100]
     * 输出：1
     *  
     *
     * 提示：
     *
     * 1 <= A.length <= 40000
     * 0 <= A[i] <= 10^9
     *
     *
     * 最长湍流子数组，仍然可以将 dp[i] 理解为以i结尾的 最长子数组长度；
     * 那么dp[i]的来源就只有 dp[i-1]+1,或者和前面的一个数组成 湍流数组
     *
     */

    public int maxTurbulenceSize(int[] A) {
        int len = A.length;
        if(len == 1){
            return 1;
        }
        int[] dp = new int[len];
        for(int i=0;i<len;i++){
            dp[i] = 1;
        }
        if(A[0]==A[1]){
            dp[1] = 1;
        }else{
            dp[1] = 2;
        }
        for(int i=2;i<len;i++){
            if((A[i-1] > A[i] && A[i-1]>A[i-2]) || (A[i-1] < A[i] && A[i-1] < A[i-2])){
                dp[i] = dp[i-1] + 1;
            }else{
                dp[i] = A[i]==A[i-1] ? 1 : 2;
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            if(max < dp[i]){
                max = dp[i];
            }
        }
        return max;
    }

    /**
     * 解析：动态规划
     * 状态dp[i]表示以A[i]结尾的最长湍流子数组的长度，注意以A[i]结尾是必须的。
     * 这样我们来分析状态转移方程了:
     *
     * 1）若A[i-2],A[i-1],A[i]构成一个湍流数组成立，那么dp[i]=dp[i-1]+1。通俗点解释就是上一个湍流子数组加上A[i]后生成的新的湍流数组，新的湍流数组长度也就是上一个最长湍流子数组的长度dp[i-1]+1。
     * 2）若湍流数组不成立，那么我们需要比较A[i-1]与A[i]是否相等来确定dp[i]的值。若A[i-1]!=A[i],则dp[i]=2;若A[i-1]==A[i],则dp[i]=1
     *
     * 补充：对于这种连续子数组或者子序列的题，我们用动态规划思想的话，可以将状态方程设计为以下两种形式：
     *
     * 1）令dp[i]表示以A[i]开头（或结尾）的***
     * 2）令dp[i][j]表示A[i]至A[j]区间的***
     * 注：这里的***表示对原问题的描述。
     */
}

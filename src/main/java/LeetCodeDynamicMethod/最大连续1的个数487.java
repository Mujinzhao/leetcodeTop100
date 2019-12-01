package LeetCodeDynamicMethod;

/**
 * 给定一个二进制数组，你可以最多将 1 个 0 翻转为 1，找出其中最大连续 1 的个数。
 *
 * 示例 1：
 *
 * 输入：[1,0,1,1,0]
 * 输出：4
 * 解释：翻转第一个 0 可以得到最长的连续 1。
 *      当翻转以后，最大连续 1 的个数为 4。
 *  
 *
 * 注：
 *
 * 输入数组只包含 0 和 1.
 * 输入数组的长度为正整数，且不超过 10,000
 *  
 *
 * 进阶：
 * 如果输入的数字是作为 无限流 逐个输入如何处理？换句话说，内存不能存储下所有从流中输入的数字。您可以有效地解决吗？
 *
 * 解析：效率不高但是能用动态规划方法：定义dp[i][k]为以i为结尾，并且在这之前翻转了k个0的最大连续1的个数；
 * 这一题主要对比交易股票的方法，保证翻转的次数不能多于1.
 */
public class 最大连续1的个数487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return 1;
        }
        int[][] dp = new int[len][2];
        dp[0][0] = (nums[0]==1)?1:0;
        dp[0][1] = 1;
        int max = -1;
        for(int i=1;i<len;i++){
            if(nums[i] == 1){
                dp[i][0] = dp[i-1][0]+1;
                dp[i][1] = dp[i-1][1]+1;
            }else{
                dp[i][0] = 0;
                dp[i][1] = dp[i-1][0]+1;
            }
            max = Math.max(max,Math.max(dp[i][1],dp[i][0]));
        }
        return max;
    }
}

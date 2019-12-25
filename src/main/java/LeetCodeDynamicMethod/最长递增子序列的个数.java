package LeetCodeDynamicMethod;

/**
 * @ClassName 最长递增子序列的个数
 * @Author zhangxinkun
 * @Date 2019/12/3  8:38 AM
 * @Version 1.0
 */

/**
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 示例 2:
 *
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 * 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
 *
 * 解析：最长递增子序列的长度没什么好说的，简答题，主要是个数。
 * 比如当以I为结尾的时候，在扫面I之前的数字的时候，当前的dp[i]一定是已经扫描过的j中的最长的递增数组长度的值。
 * 那么就可以比较当前dp[i]和dp[j]之间的关系，如果有新的更大的值出现(dp[i] < dp[j]+1)，那么当前的count[i]就和count[j]
 * 相等！如果dp[j]+1 == dp[i]那么就说明又有一条路径可以走到当前最大的值，就去更新count[i] += count[j]。
 *
 */
public class 最长递增子序列的个数 {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i] = 1;
            count[i] = 1;
        }
        int max = -1;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    if(dp[i] < dp[j]+1){
                        dp[i] = dp[j]+1;
                        count[i] = count[j];
                    }else if(dp[i] == dp[j]+1){
                        count[i] += count[j];
                    }
                }
            }
            max = Math.max(max,dp[i]);
        }
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            if(dp[i] == max){
                ans += count[i];
            }
        }
        return ans;
    }
}

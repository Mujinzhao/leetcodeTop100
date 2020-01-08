package LeetCodeDynamicMethod;

/**
 * @ClassName 分割等和子集416
 * @Author zhangxinkun
 * @Date 2019/12/31  10:09 PM
 * @Version 1.0
 */

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * 解析：01背包问题，多看看01背包九讲。
 */
public class 分割等和子集416 {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for(int i=0;i<len;i++){
            sum += nums[i];
        }
        if((sum&1) == 1){
            return false;
        }
        boolean[][] dp = new boolean[len+2][sum/2+2];
        for(int i=0;i<len;i++){
            for(int j=0;j<=sum/2;j++){
                if(i == 0){
                    dp[i][j] = (nums[i] == j);
                }else{
                    dp[i][j] = dp[i-1][j]|(j-nums[i] > 0 ? dp[i-1][j-nums[i]] : false);
                }
            }
        }
        return dp[len-1][sum/2];
    }
}

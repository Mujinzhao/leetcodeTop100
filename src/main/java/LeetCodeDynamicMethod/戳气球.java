package LeetCodeDynamicMethod;

/**
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 * 说明:
 *
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 示例:
 *
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 * 解析：dp[i][j]表示 从i+1~~j-1之间的气球能得到的最大价值。k表示最后戳的气球是哪个
 * 那么 dp[i][j] = max(dp[i][k]+dp[k][j] + nums[i]*nums[k]*nums[j]);
 */
public class 戳气球 {
    public int maxCoins(int[] nums) {
        int ans = -1;
        int len = nums.length;
        int[] numbers = new int[len+2];
        int[][] dp = new int[len+2][len+2];
        for(int i=1;i<=len;i++){
            numbers[i] = nums[i-1];
        }
        numbers[0] = 1;
        numbers[len+1] = 1;
        for(int i=len+1;i>=0;i--){
            for(int j=i;j<=len+1;j++){
                if(i == j){
                    dp[i][j] = 0;
                    // ans = Math.max(ans,dp[i][j]);
                    continue;
                }else{
                    int tempMAX = 0;
                    for(int k = i+1;k<=j-1;k++){
                        tempMAX = Math.max(tempMAX,numbers[i]*numbers[k]*numbers[j]+dp[i][k]+dp[k][j]);
                    }
                    dp[i][j] = tempMAX;
                    // ans = Math.max(ans,dp[i][j]);
                }
            }
        }
        return dp[0][len+1];
    }
}

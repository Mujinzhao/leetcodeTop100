package LeetCodeDynamicMethod;

/**
 * @ClassName GetStones877
 * @Author zhangxinkun
 * @Date 2019/11/21  11:24 PM
 * @Version 1.0
 */

/**
 * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 *
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 *
 * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 *
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 *
 *  
 *
 * 示例：
 *
 * 输入：[5,3,4,5]
 * 输出：true
 * 解释：
 * 亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
 * 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
 * 如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
 * 如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
 * 这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
 *  
 *
 * 提示：
 *
 * 2 <= piles.length <= 500
 * piles.length 是偶数。
 * 1 <= piles[i] <= 500
 * sum(piles) 是奇数。
 *
 * 解析：
 * dp[i][j] 定义为 i-j堆石子，先手拿的，能比对手拿的多出来的石子数量.
 * 那么DP[i][j]的状态 只能从dp[i+1][j] 和 dp[i][j-1]来，所以有如下DP。
 */
public class GetStones877 {
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[][] dp = new int[len][len];
        if(len == 2){
            return true;
        }
        for(int i=0;i<len;i++){
            dp[i][i] = piles[i];
        }
        for(int i=len-1;i>=0;i--){
            for(int j=len-1;j>i;j--){
                if((j-i)%2 == 1){
                    dp[i][j] = Math.max((piles[i] + dp[i+1][j]) , (piles[j] + dp[i][j-1]));
                }else{
                    //对手让第一个获得最小值，他自己才能是最大值
                    dp[i][j] = Math.min((-piles[i] + dp[i+1][j]) , (-piles[j] + dp[i][j-1]));
                }
            }
        }
        return dp[0][len-1] > 0;
    }
}

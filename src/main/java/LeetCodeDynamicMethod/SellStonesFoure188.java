package LeetCodeDynamicMethod;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2:
 * <p>
 * 输入: [3,2,6,5,0,3], k = 2
 * 输出: 7
 * 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * <p>
 * 当K大于  len/2 的时候，那么就是相当于交易次数不受限制
 */
public class SellStonesFoure188 {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k == 0) {
            return 0;
        }
        if (len < 2) {
            return 0;
        }
        if (len == 2) {
            return prices[1] - prices[0] > 0 ? prices[1] - prices[0] : 0;
        }
        if (k > len / 2) {
            int ans = 0;
            for (int i = 1; i < len; i++) {
                if (prices[i] > prices[i - 1]) {
                    ans += prices[i] - prices[i - 1];
                }
            }
            return ans;
        }

        int[][][] dp = new int[len + 1][k + 1][3];

        for (int i = 0; i < len; i++) {
            for (int tempk = 1; tempk <= k; tempk++) {
                if (i == 0) {
                    dp[i][tempk][0] = 0;
                    dp[i][tempk][1] = -prices[0];
                    continue;
                }
                dp[i][tempk][0] = Math.max(dp[i - 1][tempk][0], dp[i - 1][tempk][1] + prices[i]);
                dp[i][tempk][1] = Math.max(dp[i - 1][tempk][1], dp[i - 1][tempk - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][k][0] > 0 ? dp[len - 1][k][0] : 0;
    }
}

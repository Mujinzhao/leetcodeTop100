package LeetCodeDynamicMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 解析1：股票可以多次进行买卖。  从数组中第一个波谷开始，找出除数组中所有的波峰和波谷，两两相减即可。
 * 需要去除数组中连着重复的数字。   击败50%
 *
 * 解法二：数组中每一个数字如果后面这个比前面的大，就把结果加上，其实本质上还是波峰波谷的思想，只不过这种方法
 * 不需要再去可以找波峰波谷，这种方法只需要遍历一遍，就把波峰波谷的差值都加上去了。  击败99%
 *
 * 解法三：动态规划：这种方法的效率其实和第一种一样，不怎么高,dp[i][0]表示第i天，不持有股票的时候的最大收益
 * dp[i][1]表示第i天持有股票时的最大收益，
 * 那么初始条件： dp[0][0] = 0; dp[0][1] = -price[i];
 * 地推公式看代码
 */
public class SellStonesTwo122 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2){
            return 0;
        }
        if(len == 2){
            return prices[1]>prices[0] ? prices[1]-prices[0] : 0;
        }
        int[] temp = new int[len];
        int sum = 0;
        temp[0] = prices[0];
        for(int i=1;i<len;i++){
            if(temp[sum] != prices[i]){
                temp[++sum] = prices[i];
            }
        }
        List<Integer> ans = new ArrayList();
        if(temp[1]>temp[0]){
            ans.add(temp[0]);
        }
        for(int i=1;i<len-1;i++){
            if((temp[i]>temp[i-1] && temp[i]>temp[i+1])||
                    (temp[i]<temp[i-1] && temp[i]<temp[i+1])){
                ans.add(temp[i]);
            }
        }
        if(temp[len-1] > temp[len-2]){
            ans.add(temp[len-1]);
        }
        if(ans.size() == 0){
            return 0;
        }
        int max = 0;
        for(int i=0;i<ans.size()-1;i+=2){
            max += (ans.get(i+1) - ans.get(i));
        }
        return max;
    }

    public int maxProfit1(int[] prices) {
        int max = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] > prices[i-1]){
                max += (prices[i] - prices[i-1]);
            }
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if(len < 2){
            return 0;
        }
        if(len == 2){
            return prices[1] - prices[0] > 0 ? prices[1]-prices[0] : 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1;i<len;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[len-1][0]>0 ? dp[len-1][0] : 0;
    }
}

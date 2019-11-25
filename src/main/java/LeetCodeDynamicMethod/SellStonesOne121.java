package LeetCodeDynamicMethod;

import java.util.Arrays;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 解析：卖股票第一题：
 *
 * dp[i] 定义为第I天卖出时的最大获利，
 *
 * 主要是定义好状态转移方程的含义：dp[i]代表第i天卖出时，能获得的最大利润；那么dp[i]的状态只能由前面的两种状态获得，
 * 1、要么是第i-1天买入的股票，第i天卖出(prices[i]-prices[i-1])；
 * 2、除i-1天外前面的某一天买入的股票(dp[i-1] + (prices[i]-prices[i-1]));
 * 状态方程如下：
 * dp[i] = max((prices[i]-prices[i-1]) , (dp[i-1] + (prices[i]-prices[i-1])));
 * 初始dp[0] = 0;
 *
 * 如题目中给出的例子：
 * prices : 7,1,5,3,6,4
 *
 * dp : 0,-6,4,2,5,3
 *
 * 解析：还有一个简单的写法，遍历的时候一直去记录，已经遍历过的数组中的最小值即可
 */
public class SellStonesOne121 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0 || len == 1){
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = 0;
        int max = 0;
        for(int i=1;i<len;i++){
            dp[i] = Math.max((prices[i] - prices[i-1]),(dp[i-1] + (prices[i] - prices[i-1])));
            max = Math.max(max,dp[i]);
        }
        if(max >= 0){
            return max;
        }else{
            return 0;
        }
    }

    public int maxProfit1(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        int min = prices[0];
        int ans = 0;
        for(int i=0;i<prices.length;i++){
            if(min > prices[i]){
                min = prices[i];
            }
            ans = Math.max((prices[i] - min),ans);
        }
        return ans;
    }
}

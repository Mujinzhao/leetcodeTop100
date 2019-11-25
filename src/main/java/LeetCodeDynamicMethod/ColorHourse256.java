package LeetCodeDynamicMethod;

/**
 * @ClassName ColorHourse256
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/11/5  11:29 PM
 * @Version 1.0
 */

/**
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 *
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的矩阵来表示的。
 *
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。请你计算出粉刷完所有房子最少的花费成本。
 *
 * 注意：
 *
 * 所有花费均为正整数。
 *
 * 示例：
 *
 * 输入: [[17,2,17],[16,16,5],[14,3,19]]
 * 输出: 10
 * 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
 *      最少花费: 2 + 5 + 3 = 10。
 *
 * 解析： 动态规划的思想
 * 首先，直观的思考动态规划：  记f(n)为涂N号房间时 花费的最小值，那么 f(n) = f(n-1) + cost[n]但是我们不知道n-1的房间
 * 涂的什么颜色，所以行不通。
 * 那么我们再想：
 * 当第N号房间涂 一个确定颜色的时候，它的花费应该是什么：当房间N涂绿色的时候，那么f(n) = f(n-1)涂黄色 和 f(n-1)涂蓝色的最小值。
 * 知道了这个，就不难写出来了。
 *
 */
public class ColorHourse256 {
    public int minCost(int[][] costs) {
        if(costs.length == 0){
            return 0;
        }
        int[][] dp = new int[costs.length][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for(int i=1;i<costs.length;i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + costs[i][2];
        }
        return Math.min(dp[costs.length-1][0],Math.min(dp[costs.length-1][1],dp[costs.length-1][2]));
    }

    public static void main(String[] args){
        int[][] cost = {{17,2,17},{16,16,5},{14,3,19}};
        ColorHourse256 test = new ColorHourse256();
        test.minCost(cost);
    }
}

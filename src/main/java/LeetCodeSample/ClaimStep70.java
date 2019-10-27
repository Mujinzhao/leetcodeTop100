package LeetCodeSample;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 */
public class ClaimStep70 {
    public int climbStairs(int n) {
        int a = 1;
        int b = 2;
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }
        int ans = 0;
        for(int i = 1; i<= n-2;i++){
            ans = a+b;
            a = b;
            b = ans;
        }
        return ans;
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 10];
        dp[0] = 0;
        dp[1] = 0;
        for(int i=2 ; i< cost.length;i++){
            dp[i] = (cost[i-1] > cost[i-2]) ? dp[i-2] + cost[i-2]: dp[i-1]+cost[i-1];
        }
        return dp[cost.length-1];
    }

    public static void main(String[] args){
        ClaimStep70 test = new ClaimStep70();
        int[] num = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(test.minCostClimbingStairs(num));
    }
}

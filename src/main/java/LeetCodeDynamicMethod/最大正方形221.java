package LeetCodeDynamicMethod;

/**
 * @ClassName 最大正方形221
 * @Author zhangxinkun
 * @Date 2019/11/25  11:12 PM
 * @Version 1.0
 */

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 解析：dp[i][j]就是已i，j为右下角的正方形最大边长，
 * 画三个小方框，就能明白
 */
public class 最大正方形221 {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if(n == 0){
            return 0;
        }
        int m = matrix[0].length;
        int[][] dp = new int[n+1][m+1];
        int ans = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    if(ans < dp[i][j]){
                        ans = dp[i][j];
                    }
                }
            }
        }
        return ans == Integer.MIN_VALUE ? 0 : ans*ans;
    }
}

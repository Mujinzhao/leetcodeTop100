package LeetCodeDynamicMethod;

/**
 * @ClassName MaxLengthSubSeriesNum718
 * @Author zhangxinkun
 * @Date 2019/11/19  11:07 PM
 * @Version 1.0
 */

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 *
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 说明:
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 * 解析：这一题和最大公共子序列相比较，这一题要求必须是连续的子数组，而不是能间隔的子串，
 * 所以这一个DP的定义就不能是  A到i,B到j的组数组长度之和，因为如果这么定义，在递推dp的时候，发现没办法从前面的状态获得，
 * 因为我们没有把每次的答案记下来。那么我们相反的，可以将dp 定义为 A已i为结尾 B以j为结尾的，连续子数组的长度，这样就不难得出
 * dp[i][j] = dp[i-1][j-1] + 1（如果A[i] == B[j]）
 * dp[i][j] = 0（如果A[i] != B[j]）
 * 以上面那个 两个数组为例子：
 *
 *   3 2 1 4 7
 * 1 0 0 1 0 0
 * 2 0 1 0 0 0
 * 3 1 0 0 0 0
 * 2 0 2 0 0 0
 * 1 0 0 3 0 0
 */
public class MaxLengthSubSeriesNum718 {
    public int findLength(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        int[][] dp = new int[lenA+1][lenB+1];
        for(int i=0;i<lenA+1;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<lenB;j++){
            dp[0][j] = 0;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<lenA;i++){
            for(int j=0;j<lenB;j++){
                if(A[i] == B[j]){
                    dp[i+1][j+1] = dp[i][j] + 1;
                    max = Math.max(dp[i+1][j+1],max);
                }else{
                    dp[i+1][j+1] = 0;
                    max = Math.max(dp[i+1][j+1],max);
                }
            }
        }
        return max;
    }
}

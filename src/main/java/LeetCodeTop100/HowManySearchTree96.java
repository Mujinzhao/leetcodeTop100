package LeetCodeTop100;

/**
 * @ClassName HowManySearchTree96
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/11/9  10:14 AM
 * @Version 1.0
 */

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 解析：当新加入一个节点的时候，以N为根，以n-1为根  分别写出来，就不难写出dp 公示了
 * dp[n] = dp[n-1]*dp[0] + dp[n-2]*dp[1] + ....  + dp[n-m]*dp[m-1] +  ... dp[1]*dp[n-2]+dp[0]*dp[n-1];
 *             以n为根         以n-1为根                                       以2为根        以1为根
 *
 *
 * 当然这题也可以用 卡特兰数
 * C0 = 1
 * ​
 * Cn+1 = 2(2n+1)/n+2 * Cn
 *             */
public class HowManySearchTree96 {
    public int numTrees(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(n == 3){
            return 5;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i] += dp[i-j]*dp[j-1];
            }
        }
        return dp[n];
    }


    public int numTrees1(int n) {
        // Note: we should use long here instead of int, otherwise overflow
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}

package LeetCodeDynamicMethod;

/**
 * @ClassName 丑数1和264
 * @Author zhangxinkun
 * @Date 2020/1/29  4:47 PM
 * @Version 1.0
 */

/**
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 *
 * 1 是丑数。
 * n 不超过1690。
 *
 * 解析：判断丑数，只需要不断的除2然后不断的除3然后不断的除5，不能除的时候，看是不是1即可。
 *
 * 找到第N个丑数，第N个丑数一定是前面的某个丑数乘上2或者乘上3或者乘上5得到的，所以，我们每次找第N个的时候，只需要找到前面的丑数中，乘上2乘上3乘上5以后
 * 最接近N-1个的时候，这个数就是我们要找到的数字。
 */
public class 丑数1和264 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[2000];
        dp[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        for(int i=1;i<n;i++){
            dp[i] = Math.min(dp[index2]*2,Math.min(dp[index3]*3,dp[index5]*5));
            while(dp[index2]*2<=dp[i]){
                index2++;
            }
            while(dp[index3]*3<=dp[i]){
                index3++;
            }
            while(dp[index5]*5<=dp[i]){
                index5++;
            }
        }
        return dp[n-1];
    }
}

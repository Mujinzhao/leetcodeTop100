package LeetCodeDynamicMethod;

/**
 * @ClassName 有多少个等差数列
 * @Author zhangxinkun
 * @Date 2019/11/25  7:42 PM
 * @Version 1.0
 */

/**
 *如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *
 * 例如，以下数列为等差数列:
 *
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * 以下数列不是等差数列。
 *
 * 1, 1, 2, 5, 7
 *  
 *
 * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 *
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 *
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 *
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 *
 *  
 *
 * 示例:
 *
 * A = [1, 2, 3, 4]
 *
 * 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
 *
 * 解析： dp[i][j]表示从I 到 J 是不是等差数列
 *
 */
public class 有多少个等差数列413 {
    public int numberOfArithmeticSlices(int[] A) {
        int len = A.length;
        if(len < 2){
            return 0;
        }
        int[][] dp = new int[len][len];
        int ans = 0;
        for(int i=2;i<len;i++){
            if((A[i] - A[i-1]) == (A[i-1] - A[i-2])){
                dp[i-2][i] = 1;
                ans++;
            }
        }
        for(int i=0;i<len;i++){
            for(int j=i+3;j<len;j++){
                if(dp[i][j-1] == 1 && (A[j] - A[j-1] == A[j-1] - A[j-2])){
                    dp[i][j] = 1;
                    ans++;
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] number = {1,2,3,4};
        有多少个等差数列413 test = new 有多少个等差数列413();
        test.numberOfArithmeticSlices(number);
    }
}

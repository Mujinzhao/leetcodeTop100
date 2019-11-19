package LeetCodeTop100;

/**
 * @ClassName editDistence72
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/11/13  10:58 PM
 * @Version 1.0
 */

/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 *
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 *
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 * 这题可以当做是模板 记下来
 * 说明：这里可以以只改变其中一个字符串为依据
 *
 * 与LeetCode161 相同的题目
 */
public class editDistence72 {
    public int minDistance(String word1, String word2) {
        int lenA = word1.length();
        int lenB = word2.length();
        int[][] dp = new int[lenA+1][lenB+1];
        for(int i=0;i<lenA+1;i++){
            dp[i][0] = i;
        }
        for(int j=0;j<lenB+1;j++){
            dp[0][j] = j;
        }
        for(int i=0;i<lenA;i++){
            for(int j=0;j<lenB;j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }else{
                                              //删除                 插入          替换
                    /**
                     * 这里重点讲一下删除和插入，是在
                     * 删除： 把A字符串的最后一个字符串删掉 那么A的长度就减一 所以是 dp[i-1][j]
                     * 插入： 在A的字符串后面插入一个B的最后一个字符，这个时候A的长度虽然加一了，但是插入点之前的字符串长度还是i，
                     * 对于B来说，在A插入一个末尾和自己相同 的字符后，需要比较的字符串就减少了一个，所以整体上市 dp[i][j-1]
                     *
                    *
                    */                        //删除                 插入          替换
                    dp[i+1][j+1] = 1 + Math.min(dp[i][j+1],Math.min(dp[i+1][j],dp[i][j]));
                }
            }
        }
        return dp[lenA][lenB];
    }
}

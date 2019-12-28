package LeetCodeDynamicMethod;

/**
 * @ClassName EditDistence583
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/11/13  11:44 PM
 * @Version 1.0
 */

/**
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 *
 * 示例 1:
 *
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 * 说明:
 *
 * 给定单词的长度不超过500。
 * 给定单词中的字符只含有小写字母。
 *
 * 计算最长公共子序列即可
 */
public class EditDistence583 {
    public int minDistance(String word1, String word2) {
        int lenA = word1.length();
        int lenB = word2.length();
        int[][] dp = new int[lenA+1][lenB+1];
        for(int i=0;i<lenA;i++){
            for(int j=0;j<lenB;j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return lenA + lenB - 2*dp[lenA][lenB];
    }
}

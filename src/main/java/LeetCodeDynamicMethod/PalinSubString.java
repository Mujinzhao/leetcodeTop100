package LeetCodeDynamicMethod;

/**
 * @ClassName PalinSubString
 * @Author zhangxinkun
 * @Date 2019/11/15  12:37 AM
 * @Version 1.0
 */

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 *
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 *
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 注意:
 *
 * 输入的字符串长度不会超过1000。
 *
 * 解析：状态转义方程比较好想，这里需要注意的是 dp[i][j]通过 dp[i+1][j-1]获得，这个是在左下角，所以状态方程需要从下到上遍历。
 * 如果char(i) == char(i) 就是需要判断 dp[i+1][j-1]是不是就可以了。
 */
public class PalinSubString {
    public int countSubstrings(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        int ans = 0;
        for(int i=len-1;i>=0;i--){
            for(int j=len-1;j>=i;j--){
                if(i == j){
                    dp[i][j] = 1;
                    ans++;
                }else if((j-i) == 1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j))?1:0;
                    if(dp[i][j] == 1){
                        ans++;
                    }
                }else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1){
                        ans++;
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}

package LeetCodeDynamicMethod;

/**
 * @ClassName 交错字符串97
 * @Author zhangxinkun
 * @Date 2020/2/21  11:08 AM
 * @Version 1.0
 */

/**
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 *
 * 示例 1:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 *
 * 解析：dp[i][j]表示s1到i，s2到j，能否构成s3的（i+j）的前缀
 */
public class 交错字符串97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1 + len2 != len3){
            return false;
        }
        if(len1 == 0 && len2 == 0 && len3==0){
            return true;
        }
        if(len1 == 0||len2 == 0){
            if(len1 == 0){
                return s2.equals(s3);
            }else{
                return s1.equals(s3);
            }
        }
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for(int i=1;i<=len1;i++){
            if(s1.substring(0,i).equals(s3.substring(0,i))){
                dp[i][0] = true;
            }else{
                dp[i][0] = false;
            }
        }
        for(int i=1;i<=len2;i++){
            if(s2.substring(0,i).equals(s3.substring(0,i))){
                dp[0][i] = true;
            }else{
                dp[0][i] = false;
            }
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(s1.charAt(i-1)!=s3.charAt(i+j-1) && s2.charAt(j-1)!=s3.charAt(i+j-1)){
                    dp[i][j] = false;
                }else{
                    if(s1.charAt(i-1) == s3.charAt(i+j-1) && s2.charAt(j-1)!=s3.charAt(i+j-1)){
                        dp[i][j] = dp[i-1][j];
                    }else if(s1.charAt(i-1) != s3.charAt(i+j-1) && s2.charAt(j-1)==s3.charAt(i+j-1)){
                        dp[i][j] = dp[i][j-1];
                    }else if(s1.charAt(i-1) == s3.charAt(i+j-1) && s2.charAt(j-1)==s3.charAt(i+j-1)){
                        dp[i][j] = dp[i-1][j]||dp[i][j-1];
                    }
                }
            }
        }
        return dp[len1][len2];
    }
}

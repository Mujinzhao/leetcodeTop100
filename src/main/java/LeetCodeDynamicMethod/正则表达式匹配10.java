package LeetCodeDynamicMethod;

/**
 * @ClassName 正则表达式匹配10
 * @Author zhangxinkun
 * @Date 2020/2/1  6:13 PM
 * @Version 1.0
 */

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 *
 * 解析：这道题用动态规划进行求解的时候，定义dp[i][j]为s从0到i的子串和模式串p从0到j的子串是否能够匹配。
 * 1、当模式串扫描到'.'的时候,那么当dp[i-1][j-1]匹配的时候，dp[i][j]就匹配
 * 2、当模式串扫描到'*'的时候，那么当模式串的前一个字符和配匹配的子串的最后一个字符相等的时候（这个相等可能是真正的相等，也
 * 可能是模式串是'.'的相等），就能根据dp[i-1][j]进行判断。
 * 3、当模式串扫描的非'.'并且非'*'的时候，那么就只能根据dp[i-1][j-1]进行判断。
 *
 * 这一题的关键还有扫描开始的位置，对于被匹配的字符串来说，扫描必须是从空字符串开始，因为需要考虑这种情况：
 * s:"a"
 * p:"c*a"
 *
 * 当扫描到dp[1][3]的时候，不能直接根据，dp[0][2]得到不相符，因为，c*完全可以不使用，所以需要提前将这种空字符串的判断考虑进去。
 */
public class 正则表达式匹配10 {
    public boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        boolean[][] dp = new boolean[lenS+1][lenP+1];
        dp[0][0] = true;
        for(int i=0;i<=lenS;i++){
            for(int j=1;j<=lenP;j++){
                if(p.charAt(j-1) == '.'){
                    if(i>0){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = false;
                    }
                }else if(p.charAt(j-1) == '*'){
                    if(i>0 && (((j>=2) &&dp[i][j-2]) || (((s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'))&&dp[i-1][j]))){
                        dp[i][j] = true;
                    }else{
                        if(i == 0 && j>=2){
                            dp[i][j] = dp[0][j-2];
                        }
                    }
                }else{
                    if(i>0 && s.charAt(i-1) == p.charAt(j-1) && dp[i-1][j-1]){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        // for(int i=0;i<=lenS;i++){
        //     for(int j=0;j<=lenP;j++){
        //         System.out.printf(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return dp[lenS][lenP];
    }
}

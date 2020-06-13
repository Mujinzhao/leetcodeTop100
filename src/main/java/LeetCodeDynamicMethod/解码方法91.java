package LeetCodeDynamicMethod;

/**
 * @ClassName 解码方法91
 * @Author zhangxinkun
 * @Date 2020/1/9  8:33 AM
 * @Version 1.0
 */

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 解析：可以用动态规划，状态转义方程非常容易想到，但是边界处理，主要是0的处理，需要注意。
 */
public class 解码方法91 {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len];
        if(len == 0){
            return 0;
        }
        dp[0] = s.charAt(0) == '0'?0:1;
        if(dp[0] == 0){
            return 0;
        }
        for(int i=1;i<len;i++){
            if(s.charAt(i) != '0'){
                if(isComponent(i,s)){
                    if(i>1){
                        dp[i] = dp[i-1] + dp[i-2];
                    }
                    else{
                        dp[i] = dp[i-1] + 1;
                    }
                }else{
                    dp[i] = dp[i-1];
                }
            }else if(s.charAt(i) == '0' && !isComponent(i,s)){
                return 0;
            }else{
                dp[i] = i>=2?dp[i-2]:1;
            }
        }
        return dp[len-1];
    }

    private boolean isComponent(int i,String s){
        int pre = s.charAt(i-1) - '0';
        int now = s.charAt(i) - '0';
        int res = pre*10+now;
        if(pre == 0){
            return false;
        }
        return res <= 26;
    }
}

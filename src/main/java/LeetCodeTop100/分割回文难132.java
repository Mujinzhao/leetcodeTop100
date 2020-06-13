package LeetCodeTop100;

/**
 * @ClassName 分割回文难132
 * @Author zhangxinkun
 * @Date 2020/2/14  8:10 PM
 * @Version 1.0
 */

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回符合要求的最少分割次数。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出: 1
 * 解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 *
 * 解法一：递归
 * 和131一样的，但是这个求的是最小值，但是这题，明显在131的基础上进行暴利dfs就能得到答案，但是毫无疑问会超时，
 * 那么我们优化dfs的方式，最常见的就是记忆化搜索，所谓记忆化搜索就是将每次dfs的结果存下来，下次用的时候直接拿。
 * 这种优化方式什么时候用呢？！
 * 记忆化搜索：对于那种在递归的时候，有很明显的方向性的时候，比如这一题，就是很明显，在每层递归的时候都是往后面递归，for(int i=len;i>start;i--),
 * 上面一层的结果完全依赖于后面dfs的结果（父层的结果=for_min(子层)）。
 *
 *
 *
 * 既然这一题能够用记忆化搜索，那么我们就能用dp方式去解决。
 * 解法二：动态规划
 * 既然我们已经做了回文字符串的预处理，所以我们可以假设cache[i]表示从0到i的最小切割次数，那么cache[i] = if(dp[j][i] == 1) for_min(cache[j-1]+1);
 */
public class 分割回文难132 {
    int ans = 0;
    public int minCut(String s) {
        int len = s.length();
        if(len == 0){
            return ans;
        }
        ans = Integer.MAX_VALUE;
        int[][] dp = new int[len][len];
        for(int i=0;i<len;i++){
            dp[i][i] = 1;
        }
        for(int i=len-1;i>=0;i--){
            for(int j=i+1;j<len;j++){
                if(j-i == 1){
                    if(s.charAt(j) == s.charAt(i)){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = 0;
                    }
                }else{
                    if(dp[i+1][j-1] == 1 && s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = 0;
                    }
                }
            }
        }
        int[] cache = new int[len];
        dfs(0,dp,len,cache);
        return cache[0]-1;
    }

    public int dfs(int start,int[][] dp,int len,int[] cache){
        if(start >= len){
            return 0;
        }
        if(cache[start] != 0){
            return cache[start];
        }
        int temp = Integer.MAX_VALUE;
        for(int i=len;i>start;i--){
            if(dp[start][i-1] == 1){
                temp = Math.min(temp,dfs(i,dp,len,cache));
            }
        }
        cache[start] = temp+1;
        return cache[start];
    }

    //解法二：动态规化
    public int minCut2(String s) {
        int len = s.length();
        if(len == 0){
            return ans;
        }
        ans = Integer.MAX_VALUE;
        int[][] dp = new int[len][len];
        for(int i=0;i<len;i++){
            dp[i][i] = 1;
        }
        for(int i=len-1;i>=0;i--){
            for(int j=i+1;j<len;j++){
                if(j-i == 1){
                    if(s.charAt(j) == s.charAt(i)){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = 0;
                    }
                }else{
                    if(dp[i+1][j-1] == 1 && s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = 0;
                    }
                }
            }
        }
        int[] cache = new int[len];
        for(int i=0;i<len;i++){
            int temp = Integer.MAX_VALUE;
            for(int j=0;j<=i;j++){
                if(dp[j][i] == 1){
                    if(j == 0){
                        temp = 0;
                    }else{
                        temp = Math.min(temp,cache[j-1]+1);
                    }
                }
            }
            cache[i] = temp;
        }
        return cache[len-1];
    }
}

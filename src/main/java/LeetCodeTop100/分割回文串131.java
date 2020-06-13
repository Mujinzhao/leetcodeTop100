package LeetCodeTop100;

/**
 * @ClassName 分割回文串131
 * @Author zhangxinkun
 * @Date 2020/2/14  4:47 PM
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.List;

/**
 *给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * 解析：用动态规划进行预处理，得到从i到j是不是回文串，然后进行回溯搜索即可。
 */
public class 分割回文串131 {
    List<List<String>> ans = new ArrayList();
    public List<List<String>> partition(String s) {
        int len = s.length();
        if(len == 0){
            ans.add(new ArrayList());
            return ans;
        }
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
        List<String> tempAns = new ArrayList();
        dfs(0,s,tempAns,dp,len);
        return ans;
    }

    public void dfs(int start,String s,List<String> tempAns,int[][] dp,int len){
        if(start == len){
            List<String> temp = new ArrayList(tempAns);
            ans.add(temp);
            return ;
        }
        for(int i=start+1;i<=len;i++){
            if(dp[start][i-1] == 1){
                tempAns.add(s.substring(start,i));
                dfs(i,s,tempAns,dp,len);
                tempAns.remove(tempAns.size()-1);
            }
        }
    }
}

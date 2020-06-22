package LeetCodeTop100;

/**
 * @ClassName 解码字母到字符串
 * @Author zhangxinkun
 * @Date 2020/1/5  10:41 AM
 * @Version 1.0
 */
public class 解码字母到字符串 {
    public String freqAlphabets(String s) {
        int len = s.length();
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<len;){
            if(i+2 < len && s.charAt(i+2) == '#'){
                ans.append((char)(Integer.valueOf(s.substring(i,i+2)) + 'a' - 1));
                i+=3;
            }else if(i+2>=len || s.charAt(i+2) != '#'){
                ans.append((char)(Integer.valueOf(s.substring(i,i+1)) + 'a' - 1));
                i+=1;
            }
        }
        return ans.toString();
    }

    //异或解答
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int len = arr.length;
        int[] ans = new int[n];
        if(len == 0 || n == 0){
            return ans;
        }
        int[] xor = new int[len];
        xor[0] = arr[0];
        for(int i=1;i<len;i++){
            xor[i] = xor[i-1]^arr[i];
        }
        for(int i=0;i<n;i++){
            ans[i] = xor[queries[i][1]]^xor[queries[i][0]]^arr[queries[i][0]];
        }
        return ans;
    }

    public int minInsertions(String s) {
        int len = s.length();
        if(len == 0){
            return 0;
        }
        int[][] dp = new int[len+2][len+2];
        for(int i=len;i>=1;i--){
            for(int j=i+1;j<=len;j++){
                if(s.charAt(i-1) == s.charAt(j-1)){
                    dp[i][j] = dp[i+1][j-1];
                }else{
                    if((j-i) == 1){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i+1][j-1]+2;
                    }
                }
            }
        }
        return dp[1][len];
    }

    public static void main(String[] args){
        String s = "mbadm";
        解码字母到字符串 test = new 解码字母到字符串();
        test.minInsertions(s);
    }
}

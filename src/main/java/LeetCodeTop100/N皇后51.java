package LeetCodeTop100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName N皇后51
 * @Author zhangxinkun
 * @Date 2020/1/30  5:41 PM
 * @Version 1.0
 */

/**
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * N皇后问题：其实和数独问题比较类似。
 * 这里需要注意的一个点就是：用斜率判断是不是和前面的皇后重复，需要把坐标转化为double类型的进行判断。
 */
public class N皇后51 {
    public List<List<String>> solveNQueens(int n) {
        char[][] chear = new char[n][n];
        boolean[] lineVisit = new boolean[n];
        int[] tan = new int[n];
        List<List<String>> ans = new ArrayList();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chear[i][j] = '.';
            }
        }
        dfs(chear,0,lineVisit,tan,n,ans);
        return ans;
    }

    public boolean check(int step,boolean[] lineVisit,int[] tan,int now){
        for(int i=0;i<step;i++){
            if(Math.abs(now - tan[i])*1.0/(step - i) == 1.0){
                return false;
            }
        }
        return !lineVisit[now];
    }

    public void dfs(char[][] chear,int step,boolean[] lineVisit,int[] tan,int n, List<List<String>> ans){
        if(step >= n){
            List<String> rowAns = new ArrayList();
            for(int i=0;i<n;i++){
                String temp = String.valueOf(chear[i]);
                rowAns.add(temp);
            }
            ans.add(rowAns);
            return ;
        }
        for(int i=0;i<n;i++){
            if(chear[step][i] == '.'){
                if(check(step,lineVisit,tan,i)){
                    tan[step] = i;
                    lineVisit[i] = true;
                    chear[step][i] = 'Q';
                    dfs(chear,step+1,lineVisit,tan,n,ans);
                    lineVisit[i] = false;
                    chear[step][i] = '.';
                }
            }
        }
    }

    public static void main(String[] args){
        int n = 5;
        N皇后51 test = new N皇后51();
        test.solveNQueens(n);
    }
}

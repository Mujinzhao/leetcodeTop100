package LeetCodeTop100;

/**
 * @ClassName 解数独37
 * @Author zhangxinkun
 * @Date 2020/1/30  11:50 AM
 * @Version 1.0
 */

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 * 解析：这里主要学习一些如何在递归找到正确解后，让正在进行递归的函数全部退出。
 */
public class 解数独37 {
    public void solveSudoku(char[][] board) {
        boolean[][] rowVisit = new boolean[10][10];
        boolean[][] lineVisit = new boolean[10][10];
        boolean[][][] squreVisit = new boolean[10][10][10];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    rowVisit[i][num] = true;
                    lineVisit[j][num] = true;
                    squreVisit[i/3][j/3][num] = true;
                }
            }
        }
        dfs(board,rowVisit,lineVisit,squreVisit,0,0);
    }

    //将递归函数设置为bool类型的函数，即可
    public boolean dfs(char[][] board,boolean[][] rowVisit,boolean[][] lineVisit,boolean[][][] squreVisit,int row,int line){
        if(line > 8){
            row++;
            line = 0;
            if(row > 8){
                return true;
            }
        }
        if(board[row][line] == '.'){
            for(int i=1;i<=9;i++){
                if(!rowVisit[row][i] && !lineVisit[line][i] && !squreVisit[row/3][line/3][i]){
                    rowVisit[row][i] = true;
                    lineVisit[line][i] = true;
                    squreVisit[row/3][line/3][i] = true;
                    board[row][line] = (char) ('0' + i);
                    //配合bool类型进行使用。
                    if(dfs(board,rowVisit,lineVisit,squreVisit,row,line+1)){
                        return true;
                    }
                    board[row][line] = '.';
                    rowVisit[row][i] = false;
                    squreVisit[row/3][line/3][i] = false;
                    lineVisit[line][i] = false;
                }
            }
        }else{
            return dfs(board,rowVisit,lineVisit,squreVisit,row,line+1);
        }
        return false;
    }
}

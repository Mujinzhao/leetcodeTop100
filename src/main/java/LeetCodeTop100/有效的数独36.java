package LeetCodeTop100;

/**
 * @ClassName 有效的数独36
 * @Author zhangxinkun
 * @Date 2020/1/31  9:51 AM
 * @Version 1.0
 */

/**
 * 只需要判断给出的矩阵中已经填入的数字是不是有效的数字即可
 */
public class 有效的数独36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowVisit = new boolean[10][10];
        boolean[][] lineVisit = new boolean[10][10];
        boolean[][][] squerVisit = new boolean[10][10][10];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    if(lineVisit[i][num] == true){
                        return false;
                    }else{
                        lineVisit[i][num] = true;
                    }
                    if(rowVisit[j][num] == true){
                        return false;
                    }else{
                        rowVisit[j][num] = true;
                    }
                    if(squerVisit[i/3][j/3][num] == true){
                        return false;
                    }else{
                        squerVisit[i/3][j/3][num] = true;
                    }
                }
            }
        }
        return true;
    }
}

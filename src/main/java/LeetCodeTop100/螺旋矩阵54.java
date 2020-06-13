package LeetCodeTop100;

/**
 * @ClassName 螺旋矩阵54
 * @Author zhangxinkun
 * @Date 2020/4/13  11:24 PM
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class 螺旋矩阵54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList();
        int N = matrix.length;
        if(N == 0){
            return ans;
        }
        int M = matrix[0].length;
        int r1 = 0;
        int c1 = 0;
        int r2 = N-1;
        int c2 = matrix[0].length-1;
        while(r1 <= r2 && c1 <= c2){
            for(int i=c1;i<=c2;i++){
                ans.add(matrix[r1][i]);
            }
            for(int i=r1+1;i<=r2;i++){
                ans.add(matrix[i][c2]);
            }
            if(c2 > c1 && r2 > r1){
                for(int j=c2-1;j>=c1;j--){
                    ans.add(matrix[r2][j]);
                }
                for(int i=r2-1;i>=r1+1;i--){
                    ans.add(matrix[i][c1]);
                }
            }
            r1++;
            c1++;
            r2--;
            c2--;
        }
        return ans;
    }
}

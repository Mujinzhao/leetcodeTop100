package LeetCodeTop100;

/**
 * @ClassName 矩阵中的最长递增路径329
 * @Author zhangxinkun
 * @Date 2020/2/12  8:50 PM
 * @Version 1.0
 */

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定一个整数矩阵，找出最长递增路径的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 *
 * 示例 1:
 *
 * 输入: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * 示例 2:
 *
 * 输入: nums =
 * [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 *
 * 解析：每个cell都进行深度优先遍历，会超时。所以使用记忆化搜索，记忆化搜索，这个当做模板题，背下来。
 */
public class 矩阵中的最长递增路径329 {
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;
    Queue<Integer> queue = new ArrayDeque<>();

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        m = matrix.length; n = matrix[0].length;
        int[][] cache = new int[m][n];
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans = Math.max(ans,dfs(matrix,i,j,cache));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if(cache[i][j] != 0){
            return cache[i][j];
        }
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j]){
                cache[i][j] = Math.max(cache[i][j],dfs(matrix,x,y,cache));
            }
        }
        //这里的加一操作可以这么理解：每次上面的Math.max操作，得到的都是下一步能走的结果中，最大的值，所以这里自身的结果需要加上自身的这一步。
        return ++cache[i][j];
    }
}

package LeetCodeTop100;

/**
 * @ClassName 不同岛屿的数量694
 * @Author zhangxinkun
 * @Date 2020/4/20  11:47 PM
 * @Version 1.0
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个非空01二维数组表示的网格，一个岛屿由四连通（上、下、左、右四个方向）的 1 组成，你可以认为网格的四周被海水包围。
 *
 * 请你计算这个网格中共有多少个形状不同的岛屿。两个岛屿被认为是相同的，当且仅当一个岛屿可以通过平移变换（不可以旋转、翻转）和另一个岛屿重合。
 *
 *  
 *
 * 样例 1:
 *
 * 11000
 * 11000
 * 00011
 * 00011
 * 给定上图，返回结果 1。
 *
 *  
 *
 * 样例 2:
 *
 * 11011
 * 10000
 * 00001
 * 11011
 * 给定上图，返回结果 <font color="#c7254e" face="Menlo, Monaco, Consolas, Courier New, monospace">3</font>。
 *
 * 注意:
 *
 * 11
 * 1
 * 和
 *
 *  1
 * 11
 * 是不同的岛屿，因为我们不考虑旋转、翻转操作。
 *
 *  
 *
 * 注释 :  二维数组每维的大小都不会超过50。
 *
 * 解析：这一题真的需要好好看看怎么记录路径的，神来之笔
 */
public class 不同岛屿的数量694 {
    private int row;

    private int col;

    private int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private Set<String> set;

    public int numDistinctIslands(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        set = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder path = new StringBuilder();
                    dfs(grid, i, j, path);
                    set.add(path.toString());
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int i, int j, StringBuilder path) {
        grid[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + directions[k][0];
            int y = j + directions[k][1];
            if (verify(x, y) && grid[x][y] == 1) {
                path.append(k);
                dfs(grid, x, y, path);
                // 代表往回走了一步
                path.append("-");
            }
        }
    }

    private boolean verify(int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }
}

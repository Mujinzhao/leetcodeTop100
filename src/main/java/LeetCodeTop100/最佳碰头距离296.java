package LeetCodeTop100;

/**
 * @ClassName 最佳碰头距离296
 * @Author zhangxinkun
 * @Date 2020/2/24  10:09 PM
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 有一队人（两人或以上）想要在一个地方碰面，他们希望能够最小化他们的总行走距离。
 *
 * 给你一个 2D 网格，其中各个格子内的值要么是 0，要么是 1。
 *
 * 1 表示某个人的家所处的位置。这里，我们将使用 曼哈顿距离 来计算，其中 distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|。
 *
 * 示例：
 *
 * 输入:
 *
 * 1 - 0 - 0 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 *
 * 输出: 6
 *
 * 解析: 给定的三个人分别住在(0,0)，(0,4) 和 (2,2):
 *      (0,2) 是一个最佳的碰面点，其总行走距离为 2 + 2 + 2 = 6，最小，因此返回 6。
 *
 * 解析：分别找行列中位数，即可。
 */
public class 最佳碰头距离296 {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        if(m == 0){
            return 0;
        }
        int n = grid[0].length;
        List<Integer> dirX = new ArrayList();
        List<Integer> dirY = new ArrayList();
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    count++;
                    dirX.add(i);
                    dirY.add(j);
                }
            }
        }
        Collections.sort(dirX);
        Collections.sort(dirY);
        int targetX = dirX.get(count/2);
        int targetY = dirY.get(count/2);
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    ans += (Math.abs(i-targetX) + Math.abs(j-targetY));
                }
            }
        }
        return ans;
    }
}

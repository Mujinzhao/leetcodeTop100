package LeetCodeTop100;

/**
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 *
 * 请你返回最终形体的表面积。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[[2]]
 * 输出：10
 * 示例 2：
 *
 * 输入：[[1,2],[3,4]]
 * 输出：34
 * 示例 3：
 *
 * 输入：[[1,0],[0,2]]
 * 输出：16
 * 示例 4：
 *
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 示例 5：
 *
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 *  
 *
 * 提示：
 *
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50

 */
public class Area892 {
    public int surfaceArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                int x = i;
                int y = j;
                if(grid[x][y] == 1){
                    sum += 6;
                }else if(grid[x][y] > 1){
                    sum += (6+(grid[x][y]-1)*4);
                }
                //上
                if(checkOut(x-1,y,m,n)){
                    sum -= Math.min(grid[x][y],grid[x-1][y]);
                }
                if(checkOut(x+1,y,m,n)){
                    sum -= Math.min(grid[x][y],grid[x+1][y]);
                }
                if(checkOut(x,y-1,m,n)){
                    sum -= Math.min(grid[x][y],grid[x][y-1]);
                }
                if(checkOut(x,y+1,m,n)){
                    sum -= Math.min(grid[x][y],grid[x][y+1]);
                }
            }
        }
        return sum;
    }

    public boolean checkOut(int x,int y,int m,int n){
        if(x < 0|| x>=m || y<0 || y>=n){
            return false;
        }
        return true;
    }
}

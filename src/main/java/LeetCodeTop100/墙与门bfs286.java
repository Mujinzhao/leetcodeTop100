package LeetCodeTop100;

/**
 * @ClassName 墙与门bfs286
 * @Author zhangxinkun
 * @Date 2020/2/22  10:09 PM
 * @Version 1.0
 */

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 你被给定一个 m × n 的二维网格，网格中有以下三种可能的初始化值：
 *
 * -1 表示墙或是障碍物
 * 0 表示一扇门
 * INF 无限表示一个空的房间。然后，我们用 231 - 1 = 2147483647 代表 INF。你可以认为通往门的距离总是小于 2147483647 的。
 * 你要给每个空房间位上填上该房间到 最近 门的距离，如果无法到达门，则填 INF 即可。
 *
 * 示例：
 *
 * 给定二维网格：
 *
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 * 运行完你的函数后，该网格应该变成：
 *
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 *
 *   解析：多个点进行bfs就行了
 */
public class 墙与门bfs286 {
    int[][] drict = {{-1,0},{1,0},{0,-1},{0,1}};
    int m;
    int n;
    public void wallsAndGates(int[][] rooms) {
        m = rooms.length;
        if(m == 0){
            return;
        }
        n = rooms[0].length;
        int[][] ans = new int[m][n];
        int[][] visit = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[i][j] = 2147483647;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rooms[i][j] == 0){
                    visit = new int[m][n];
                    bfs(visit,rooms,ans,i,j);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rooms[i][j] == 2147483647){
                    rooms[i][j] = ans[i][j];
                    // System.out.print(rooms[i][j]+" ");
                }
            }
            // System.out.println();
        }
    }

    public void bfs(int[][] visit,int[][] rooms,int[][] ans,int startx,int starty){
        class Point{
            public int x;
            public int y;
            public int step = 0;
        }
        Queue<Point> queue = new ArrayDeque();
        Point point = new Point();
        point.x = startx;
        point.y = starty;
        point.step = 0;
        visit[startx][starty] = 1;
        queue.offer(point);
        while(!queue.isEmpty()){
            Point now = queue.peek();
            queue.poll();
            for(int i=0;i<4;i++){
                Point next = new Point();
                next.step = now.step+1;
                next.x = now.x + drict[i][0];
                next.y = now.y + drict[i][1];
                if(isOK(visit,rooms,next.x,next.y)){
                    visit[next.x][next.y] = 1;
                    ans[next.x][next.y] = Math.min(next.step,ans[next.x][next.y]);
                    queue.offer(next);
                }
            }
        }
    }

    public boolean isOK(int[][] visit,int[][] rooms,int x,int y){
        if(x>=0&&x<m &&y>=0 && y<n && visit[x][y] == 0 &&  rooms[x][y] == 2147483647){
            return true;
        }
        return false;
    }
}

package LeetCodeTop100;

/**
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 * <p>
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * 说明:
 * <p>
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 * <p>
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 */
public class torpeSort207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] into = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            into[prerequisites[i][1]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            int temp = 0;
            boolean flag = true;
            for (int j = 0; j < numCourses; j++) {
                if (into[j] == 0) {
                    into[j] = -1;
                    temp = j;
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return false;
            }
            for (int j = 0; j < prerequisites.length; j++) {
                if (prerequisites[j][0] == temp) {
                    into[prerequisites[j][1]]--;
                }
            }
        }
        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] into = new int[numCourses];
        int[] ans = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            into[prerequisites[i][0]]++;
        }
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            int temp = 0;
            boolean flag = true;
            for (int j = 0; j < numCourses; j++) {
                if (into[j] == 0) {
                    into[j] = -1;
                    temp = j;
                    flag = false;
                    ans[count++] = temp;
                    break;
                }
            }
            if(flag){
                int[] tempnum = new int[0];
                return tempnum;
            }
            for (int j = 0; j < prerequisites.length; j++) {
                if (prerequisites[j][1] == temp) {
                    into[prerequisites[j][0]]--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        torpeSort207 test = new torpeSort207();
        int n = 2;
        int[][] num = {{1, 0}, {0,1}};
        test.findOrder(n, num);
    }
}

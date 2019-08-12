package LeetCodeTop100.DynamicMethod;

/**
 * @ClassName MinPathSum64
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/8/8  5:40 PM
 * @Version 1.0
 */

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 思路1：用搜索的方式进行，广度优先（优先队列）的方式遍历所有的路径，取其中最小的一个路径即可。
 * 思路2：DP，每一个节点，能到达这个节点的上一个节点，要么在它的上面，要么在它的左边，所以如果把每个节点看做是一个最终的目的地，那到达这个节点的最小路径就是：MIN（左边节点，上面节点）
 * 这样的话，只需要从上到下，从左到右遍历所有的节点即可。
 * 下面用两种方式分别实现。
 */
public class MinPathSum64 {
    private int[][] dp;

    private static int[] dirX = {0,1};

    private static int[] dirY = {1,0};

    public int minPathSum1(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        for(int i=0;i<dp.length;i++){
            for(int j=0; j<dp[i].length ;j++){
                if(i-1 >= 0 && j-1 >= 0){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
                }else if(i==0 && j==0){
                    continue;
                }else if(i-1>=0 && j-1<0){
                    dp[i][j] = grid[i][j] + dp[i-1][0];
                }else if(i-1<0 && j-1 >= 0){
                    dp[i][j] = grid[i][j] + dp[0][j-1];
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    /******************  下面开始用优先队列求解   ***********/

//    public int minPathSum(int[][] grid) {
//        Queue<Integer> queue = new PriorityQueue<>();
//        Comparator<ListNode> com = new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//
//            }
//        }
//
//    }

    public static void main(String[] args){
        MinPathSum64 instance = new MinPathSum64();
        int[][] nums = {{1,2},{5,6},{1,1}};
        System.out.println(instance.minPathSum1(nums));
    }
}

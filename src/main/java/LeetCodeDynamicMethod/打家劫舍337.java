package LeetCodeDynamicMethod;

/**
 * @ClassName 打家劫舍337
 * @Author zhangxinkun
 * @Date 2019/12/23  11:42 PM
 * @Version 1.0
 */

import LeetCodeBaseDate.TreeNode;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 *
 * 解析：树形DP：专门用来解决这种，树节点之间有互斥关系的题目。
 * 树形DP 可以理解为后序遍历 的一种解法。每次都是先递归，然后从子节点向上进行DP！！！
 * 树形DP 的关键就是  某个DP【0】 DP【1】的含义：代表，第I个节点不选择的时候，子树能获得的最大值；和第I个节点选择的时候，子树获得的最大值。
 *
 * 那么dp[0] = (for 每一个i的子节点 sum（max（dp[son][0],dp[son][1]）)）
 * dp[1] = sum(dp[son][0]) + val[i];
 */
public class 打家劫舍337 {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0],res[1]);
    }

    public int[] dfs(TreeNode root){
        int[] res = new int[2];
        if(root == null){
            return res;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        res[1] = left[0] + right[0] + root.val;
        return res;
    }
}

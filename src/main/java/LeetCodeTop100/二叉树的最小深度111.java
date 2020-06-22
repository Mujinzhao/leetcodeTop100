package LeetCodeTop100;

/**
 * @ClassName 二叉树的最小深度111
 * @Author zhangxinkun
 * @Date 2020/2/8  10:42 AM
 * @Version 1.0
 */

import LeetCodeBaseDate.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * dfs 递归即可。
 */
public class 二叉树的最小深度111 {
    int ans =0 ;
    public int minDepth(TreeNode root) {
        ans = Integer.MAX_VALUE;
        dfs(root,1);
        return ans==Integer.MAX_VALUE?0:ans;
    }
    public void dfs(TreeNode root, int step){
        if(root == null){
            return ;
        }
        if(root.left == null && root.right == null){
            ans = Math.min(ans,step);
            return;
        }
        dfs(root.left,step+1);
        dfs(root.right,step+1);
    }
}

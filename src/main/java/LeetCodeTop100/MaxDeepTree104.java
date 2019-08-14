package LeetCodeTop100;

/**
 * @ClassName MaxDeepTree104
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/8/14  4:10 PM
 * @Version 1.0
 */

import LeetCodeBaseDate.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 */
public class MaxDeepTree104 {
    public static int Max = -1;
    public int maxDepth(TreeNode root) {
        Max = -1;
        if(root == null) return 0;
        Solve(root,1);
        return Max;
    }

    public void Solve(TreeNode root,int deep){
        if(root.left != null){
            Solve(root.left,deep+1);
        }
        if(root.right != null){
            Solve(root.right,deep+1);
        }
        if(Max < deep){
            Max = deep;
        }
    }

    public static void main(String[] args){
        MaxDeepTree104 instacne = new MaxDeepTree104();
        TreeNode root = new TreeNode(0);
//        TreeNode roo2 = new TreeNode(2);
//        TreeNode roo3 = new TreeNode(3);
//        TreeNode roo4 = new TreeNode(4);
//        TreeNode roo5 = new TreeNode(5);

//        root.left = roo2;
//        root.right = roo3;
//        roo3.right = roo4;
//        roo4.left = roo5;
        System.out.println(instacne.maxDepth(root));
    }
}

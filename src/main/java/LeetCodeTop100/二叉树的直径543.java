package LeetCodeTop100;

/**
 * @ClassName 二叉树的直径543
 * @Author zhangxinkun
 * @Date 2020/3/10  4:34 PM
 * @Version 1.0
 */

import LeetCodeBaseDate.TreeNode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * 解析：找每个节点左右子树的高度和的最大值
 */
public class 二叉树的直径543 {
    int ans ;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        ans = 0;
        deep(root);
        return ans;
    }

    public int deep(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDeep = deep(root.left);
        int rightDeep = deep(root.right);
        ans = Math.max(ans,leftDeep+rightDeep);
        return Math.max(leftDeep,rightDeep)+1;
    }
}

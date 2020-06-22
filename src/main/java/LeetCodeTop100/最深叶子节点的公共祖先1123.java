package LeetCodeTop100;

/**
 * @ClassName 最深叶子节点的公共祖先1123
 * @Author zhangxinkun
 * @Date 2020/2/12  8:23 PM
 * @Version 1.0
 */

import LeetCodeBaseDate.TreeNode;

/**
 * 给你一个有根节点的二叉树，找到它最深的叶节点的最近公共祖先。
 *
 * 回想一下：
 *
 * 叶节点 是二叉树中没有子节点的节点
 * 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
 * 如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。
 *  
 *
 * 示例 1：
 *
 * 输入：root = [1,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 *
 * 输入：root = [1,2,3,4]
 * 输出：[4]
 * 示例 3：
 *
 * 输入：root = [1,2,3,4,5]
 * 输出：[2,4,5]
 *  
 *
 * 提示：
 *
 * 给你的树中将有 1 到 1000 个节点。
 * 树中每个节点的值都在 1 到 1000 之间。
 *
 * 解析：画一下图，就可以很方便的看出来，最深节点的公共祖先，一定是左右两边的子树，深度相同的，所以就从上往下找，
 * 找到第一个左右两个子树深度相同的节点就行了。
 */
public class 最深叶子节点的公共祖先1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null){
            return null;
        }
        int left = deep(root.left);
        int right = deep(root.right);
        if(left == right){
            return root;
        }else if(left > right){
            return lcaDeepestLeaves(root.left);
        }else{
            return lcaDeepestLeaves(root.right);
        }
    }

    public int deep(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = deep(root.left);
        int right = deep(root.right);
        return Math.max(left,right)+1;
    }
}

package LeetCodeTop100;

import LeetCodeBaseDate.TreeNode;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 * 在真实的面试中遇到过这道题？
 *
 *  解析：所有节点中，只有一个公共祖先节点能满足，大于最小的，小于最大的。所以后序遍历节点即可。
 *
 *  当然也可以进行优化，都大于根节点的时候，只遍历右子树，都小于的时候，只遍历左子树即可。
 */
public class LCA_BST235 {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        LCA(root,p,q);
        return ans;
    }

    public void LCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return ;
        }
        LCA(root.left,p,q);
        LCA(root.right,p,q);
        if(root.val >= Math.min(p.val,q.val) && root.val <= Math.max(p.val,q.val)){
            ans = root;
        }
    }

    public void LCA2(TreeNode root, TreeNode p, TreeNode q){
        if(root.val> Math.max(p.val,q.val)){
            LCA2(root.left,p,q);
        }else if(root.val < Math.min(p.val,q.val)){
            LCA2(root.right,p,q);
        }else {
            ans = root;
        }
    }
}

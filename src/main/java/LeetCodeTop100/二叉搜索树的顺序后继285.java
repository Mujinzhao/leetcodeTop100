package LeetCodeTop100;

/**
 * @ClassName 二叉搜索树的顺序后继
 * @Author zhangxinkun
 * @Date 2019/12/25  11:01 PM
 * @Version 1.0
 */

import LeetCodeBaseDate.TreeNode;

import java.util.Stack;

/**
 *给你一个二叉搜索树和其中的某一个结点，请你找出该结点在树中顺序后继的节点。
 *
 * 结点 p 的后继是值比 p.val 大的结点中键值最小的结点。
 *
 *  
 *
 * 示例 1:
 *
 *
 *
 * 输入: root = [2,1,3], p = 1
 * 输出: 2
 * 解析: 这里 1 的顺序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
 * 示例 2:
 *
 *
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 * 输出: null
 * 解析: 因为给出的结点没有顺序后继，所以答案就返回 null 了。
 *  
 *
 * 注意:
 *
 * 假如给出的结点在该树中没有顺序后继的话，请返回 null
 * 我们保证树中每个结点的值是唯一的
 *
 *
 * 解析：利用二叉树的排序特性，找到从根节点到制定节点的路径，用于代替，指向父节点的指针。
 *
 */
public class 二叉搜索树的顺序后继285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if(p.right != null){
            TreeNode right = p.right;
            while(right.left != null){
                right = right.left;
            }
            return right;
        }
        Stack<TreeNode> s = new Stack();
        TreeNode node = root;
        while(node != p){
            s.push(node);
            if(node.val > p.val){
                node = node.left;
            }else if(node.val < p.val){
                node = node.right;
            }
        }
        node = p;
        TreeNode fa = null;
        while(!s.empty()){
            fa = s.peek();
            s.pop();
            if(node == fa.left){
                return fa;
            }
            node = fa;
        }
        return null;
    }
}

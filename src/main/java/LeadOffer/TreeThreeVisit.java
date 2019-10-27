package LeadOffer;

import LeetCodeBaseDate.TreeNode;

import java.util.Stack;

/**
 * 二叉树的三种非递归遍历方式
 */
public class TreeThreeVisit {

    public void preVisit(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.empty() || root!=null){
            if(root != null){
                System.out.println(root.val);
                stack.push(root);
                root = root.left;
            }else {
                root = stack.peek();
                stack.pop();
                root = root.right;
            }
        }
    }

    public static void main(String[] args){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.right = treeNode4;
        treeNode2.right = treeNode5;
        TreeThreeVisit test = new TreeThreeVisit();
        test.preVisit(treeNode1);
    }
}

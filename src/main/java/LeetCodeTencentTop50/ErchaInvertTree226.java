package LeetCodeTencentTop50;

/**
 * @ClassName ErchaInvertTree226
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/10/23  11:10 PM
 * @Version 1.0
 */

import LeetCodeBaseDate.TreeNode;

/**
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 */
public class ErchaInvertTree226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
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
        ErchaInvertTree226 test = new ErchaInvertTree226();
        test.invertTree(treeNode1);
        int a = 0;
    }
}

package LeetCodeTop100;

/**
 * @ClassName TreeToList114
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/11/7  11:44 PM
 * @Version 1.0
 */

import LeetCodeBaseDate.TreeNode;

/**
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 解析 ： 这一题 就是将先序遍历的结果变成链表，画完图就可知，采用后序遍历的方式，然后把每一个节点  由节点换一下就行了。
 */
public class TreeToList114 {
    public void flatten(TreeNode root) {
        if(root!=null){
            flatten(root.left);
            flatten(root.right);
            TreeNode tempRight = root.right;
            if(root.left!=null){
                root.right = root.left;
                TreeNode tempLeft = root.left;
                root.left = null;
                while(tempLeft.right!=null){
                    tempLeft = tempLeft.right;
                }
                tempLeft.right = tempRight;
            }
        }
    }
}

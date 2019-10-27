package LeetCodeTop100;

/**
 * @ClassName ErChaTreeRightView199
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/10/18  4:21 PM
 * @Version 1.0
 */

/**
 * //给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * //
 * // 示例:
 * //
 * // 输入: [1,2,3,null,5,null,4]
 * //输出: [1, 3, 4]
 * //解释:
 * //
 * //   1            <---
 * // /   \
 * //2     3         <---
 * // \     \
 * //  5     4       <---
 * //
 * // Related Topics 树 深度优先搜索 广度优先搜索
 *
 *
 *
 * //leetcode submit region begin(Prohibit modification and deletion)
 * /**
 *  * Definition for a binary tree node.
 *  * public class TreeNode {
 *  *     int val;
 *  *     TreeNode left;
 *  *     TreeNode right;
 *  *     TreeNode(int x) { val = x; }
 *  * }
 *  */
/**
 * 这一题的解题思路：直接二叉树的层次遍历，然后取每一层的最后一个节点。就是我自己写的这种方式。
 * 这里学习一下别人写的一种层次遍历的方式，直接while(size -- )，每次入账新的一层的节点的时候，强制将之前的所有节点都pop出去
 * vector<int> rightSideView(TreeNode* root) {
 * 	vector<int> res;
 * 	if (!root) return res;
 * 	queue<TreeNode*> q;
 * 	q.push(root);
 * 	while (!q.empty())
 *        {
 * 		int size = q.size();
 * 		res.push_back(q.front()->val);
 * 		while (size--)
 *        {
 * 			TreeNode* temp = q.front();
 * 			q.pop();
 * 			if (temp->right) q.push(temp->right);
 * 			if (temp->left) q.push(temp->left);
 *        }
 *    }
 * 	return res;
 * }
 */

import LeetCodeBaseDate.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ErChaTreeRightView199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root.right == null && root.left == null){
            ans.add(root.val);
            return ans;
        }

        class Node{
            public TreeNode tree;
            public int level;

            public TreeNode getTree() {
                return tree;
            }

            public void setTree(TreeNode tree) {
                this.tree = tree;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }
        }

        //二叉树的层次遍历，并且记录每个节点入队列的层次
        Queue<Node> queue = new ArrayDeque<>();
        Node first = new Node();
        first.level = 1;
        first.tree = root;
        Node cache = first;
        queue.offer(first);
        while(!queue.isEmpty()){
            Node now = queue.peek();

            if(now.level > cache.level){
                ans.add(cache.tree.val);
            }
            queue.poll();
            cache = now;
            if(now.tree.left != null){
                Node right = new Node();
                right.tree = now.tree.left;
                right.level = now.level + 1;
                queue.offer(right);
            }
            if(now.tree.right != null){
                Node left = new Node();
                left.tree = now.tree.right;
                left.level = now.level + 1;
                queue.offer(left);
            }
        }
        ans.add(cache.tree.val);
        return ans;
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
         ErChaTreeRightView199 test = new ErChaTreeRightView199();
         test.rightSideView(treeNode1);
     }
}

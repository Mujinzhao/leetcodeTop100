package LeetCodeTop100;

/**
 * @ClassName BinaryTree
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/10/4  5:18 PM
 * @Version 1.0
 */

import LeetCodeBaseDate.TreeNode;
import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class BinaryTree102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

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
        Queue<Node> queue = new ArrayDeque<>();
        if(root == null){
            return ans;
        }
        if(root.left == null && root.right == null){
            List<Integer> tempAns = new ArrayList<>();
            tempAns.add(root.val);
            ans.add(tempAns);
            return ans;
        }
        List<Node> queueResult = new ArrayList<>();
        Node first = new Node();
        first.setLevel(1);
        first.setTree(root);
        queue.offer(first);
        int Max = -1;
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            queueResult.add(temp);
            if(temp.tree.left != null){
                Node next = new Node();
                next.tree = temp.tree.left;
                next.level = temp.level+1;
                if(Max < next.level){
                    Max = next.level;
                }
                queue.offer(next);
            }
            if(temp.tree.right != null){
                Node next = new Node();
                next.tree = temp.tree.right;
                next.level = temp.level+1;
                if(Max < next.level){
                    Max = next.level;
                }
                queue.offer(next);
            }
        }
        for(int i=1 ;i <= Max ;i++){
            List<Integer> tempAns = new ArrayList<>();
            for(int j=0 ;j<queueResult.size() ;j++){
                if(queueResult.get(j).level == i){
                    tempAns.add(queueResult.get(j).getTree().val);
                }
            }
            ans.add(tempAns);
        }
        return ans;
    }
    public static void main(String[] args){
        BinaryTree102 instance = new BinaryTree102();
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        instance.levelOrder(treeNode1);
    }
}

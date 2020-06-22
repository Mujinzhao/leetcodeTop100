package LeetCodeTop100;

/**
 * @ClassName HowManySearchTree95
 * @Author zhangxinkun
 * @Date 2019/11/19  7:20 AM
 * @Version 1.0
 */

import LeetCodeBaseDate.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 解析：先用直观的方法写一遍，搜索方法
 */
public class HowManySearchTree95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans=new ArrayList();
        if(n == 0){
            return ans;
        }
        if(n == 1){
            ans.add(new TreeNode(1));
            return ans;
        }
        return help(1,n);
    }

    public List<TreeNode> help(int start,int end){
        List<TreeNode> ans=new ArrayList();;
        if(start > end){
            ans.add(null);
            return ans;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> left = help(start,i-1);
            List<TreeNode> right = help(i+1,end);
            for(TreeNode temp:left){
                for(TreeNode tr:right){
                    TreeNode root = new TreeNode(i);
                    root.left = temp;
                    root.right = tr;
                    ans.add(root);
                }
            }
        }
        return ans;
    }



    public void pintTree(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode first = queue.peek();
            queue.poll();
            System.out.println(first.val);
            if(first.left != null){
                queue.offer(first.left);
            }
            if(first.right != null){
                queue.offer(first.right);
            }
        }
    }

    public static void main(String[] args){
        HowManySearchTree95 test = new HowManySearchTree95();
        test.generateTrees(3);
    }
}

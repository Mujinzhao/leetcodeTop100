package LeetCodeTop100;

/**
 * @ClassName 二叉树的中序遍历
 * @Author zhangxinkun
 * @Date 2019/12/25  11:14 PM
 * @Version 1.0
 */

import LeetCodeBaseDate.Node;

/**
 * 对比285顺序遍历的后一个节点，这一题相对还简单一些，因为直接给出了parent指针。
 */
public class 二叉树的中序遍历后继节点510 {
    public Node inorderSuccessor(Node x) {
        if(x == null){
            return null;
        }
        if(x.right != null){
            Node node = x.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }

        Node node = x;
        while(node.parent != null && node.parent.left != node ){
            node = node.parent;
        }
        return node.parent;
    }
}

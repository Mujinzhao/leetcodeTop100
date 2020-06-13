package LeetCodeTop100;

import LeetCodeBaseDate.TreeNode;

/**
 * @ClassName 二叉树是否镜像offer
 * @Author zhangxinkun
 * @Date 2020/4/25  8:51 AM
 * @Version 1.0
 */
public class 二叉树是否镜像offer {
    public boolean isMinor(TreeNode root1,TreeNode root2){
        if(root1 == null && root2==null){
            return true;
        }
        if(root1 == null && root2!=null || root1!=null && root2==null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return isMinor(root1.left,root2.right) && isMinor(root1.right,root2.left);
    }
}

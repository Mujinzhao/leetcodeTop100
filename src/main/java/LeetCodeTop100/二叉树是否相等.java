package LeetCodeTop100;

import LeetCodeBaseDate.TreeNode;

/**
 * @ClassName 判断二叉树是否相等
 * @Author zhangxinkun
 * @Date 2020/1/29  11:35 AM
 * @Version 1.0
 */
public class 二叉树是否相等 {
    public boolean isEquel(TreeNode root1, TreeNode root2){
        if(root1 == null || root2 == null){
            return true;
        }
        if(root1 == null && root2!=null){
            return false;
        }
        if(root1 != null && root2 == null){
            return false;
        }

        boolean left = isEquel(root1.left,root2.left);
        boolean right = isEquel(root1.right,root2.right);
        if(root1.val == root2.val && left && right){
            return true;
        }else{
            return false;
        }
    }

    public boolean isEquel1(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if((root1 == null && root2!=null) || (root1 != null && root2 == null) || root1.val != root2.val){
            return false;
        }
        boolean isLeft = isEquel1(root1.left,root2.left);
        boolean isRight = isEquel1(root1.right,root2.right);
        return isLeft&&isRight;
    }
}

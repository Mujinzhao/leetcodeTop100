package LeetCodeTop100;

import LeetCodeBaseDate.TreeNode;

/**
 * @ClassName 判断一个树是不是另一个树的子结构offer
 * @Author zhangxinkun
 * @Date 2020/4/25  8:29 AM
 * @Version 1.0
 */
public class 判断一个树是不是另一个树的子结构offer {


    public boolean isSubStruct(TreeNode root1,TreeNode root2){
        if(root1==null || root2==null){
            return false;
        }
        if(root1.val != root2.val){
            return isSubStruct(root1.left,root2) || isSubStruct(root1.right,root2);
        }
        return solve(root1,root2);
    }

    public boolean solve(TreeNode root1,TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        if(root1.val == root2.val){
            return solve(root1.left,root2.left) && solve(root1.right,root2.right);
        }
        return false;
    }
}

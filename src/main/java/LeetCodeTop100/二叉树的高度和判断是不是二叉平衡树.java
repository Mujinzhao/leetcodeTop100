package LeetCodeTop100;

import LeetCodeBaseDate.TreeNode;
import apple.laf.JRSUIUtils;

/**
 * @ClassName 二叉树的高度和判断是不是二叉平衡树
 * @Author zhangxinkun
 * @Date 2020/2/7  10:21 PM
 * @Version 1.0
 */
public class 二叉树的高度和判断是不是二叉平衡树 {

    //求二叉树的高度
    public int height(TreeNode root){
        if(root != null){
            int leftH = height(root.left);
            int rightH = height(root.right);
            if(leftH >= rightH){
                return leftH + 1;
            }else{
                return rightH + 1;
            }
        }
        return 0;
    }

    //判断二叉树是不是平衡二叉树
    //用高度进行求解，高度为-1就不是
    public boolean isBalance(TreeNode root){
        int H = heightTWo(root);
        return H >= 0;
    }

    public int heightTWo(TreeNode root){
        if(root != null){
            int leftH = heightTWo(root.left);
            int rightH = heightTWo(root.right);
            if(Math.abs(leftH-rightH) <= 1 && leftH > 0 && rightH > 0){
                if(leftH >= rightH){
                    return leftH + 1;
                }else{
                    return rightH + 1;
                }
            }else{
                return -1;
            }
        }
        return 0;
    }

}

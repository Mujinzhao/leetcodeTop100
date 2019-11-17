package LeetCodeTop100;

import LeetCodeBaseDate.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证二叉搜索数
 * 直接中序遍历即可
 */
public class VerifyErchaSearchTree98 {
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        flag = true;
        List<Integer> list = new ArrayList();
        midVisit(root,list);
        return flag;
    }

    public boolean midVisit(TreeNode root,List<Integer> list){
        if(root != null){
            midVisit(root.left,list);
            if(list.size() == 0){
                list.add(root.val);
            }else{
                if(root.val > list.get(list.size()-1)){
                    list.add(root.val);
                }else{
                    flag = false;
                    return flag;
                }
            }
            midVisit(root.right,list);
        }
        return flag;
    }
}

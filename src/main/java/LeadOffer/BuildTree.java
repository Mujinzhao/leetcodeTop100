package LeadOffer;

import LeetCodeBaseDate.TreeNode;
import apple.laf.JRSUIUtils;

/**
 * 根据前序、中序 或者 后序，中序，建立唯一二叉树
 */
public class BuildTree {
    /**
     * 根据  前序、中序  建立二叉树
     * @param before
     * @param middle
     * @return
     */
    public TreeNode buildTreeAsPreAndMiddle(String before,String middle){
        if(middle.length() == 0){
            return null;
        }
        TreeNode root = new TreeNode(-1);
        for(int i=0 ;i<before.length();i++){
            if(middle.contains(String.valueOf(before.charAt(i)))){
                int index = middle.indexOf(before.charAt(i));
                String leftMiddle = middle.substring(0,index);
                String rightMiddle = middle.substring(index+1,middle.length());
                root.val = Long.valueOf(String.valueOf(before.charAt(i))).intValue();
                root.left = buildTreeAsPreAndMiddle(before,leftMiddle);
                root.right = buildTreeAsPreAndMiddle(before,rightMiddle);
                return root;
            }
        }
        return root;
    }

    /**
     * 根据中序和后序建立二叉树
     * @param last
     * @param middle
     * @return
     */
    public TreeNode buildTreeAsLastAndMiddle(String last,String middle){
        if(middle.length() == 0){
            return null;
        }
        TreeNode root = new TreeNode(-1);
        for(int i =last.length()-1 ;i >= 0 ;i--){
            boolean flag = true;
            for(int j=0;j<middle.length();j++){
                if(last.charAt(i) == middle.charAt(j)){
                    root.val = Long.valueOf(String.valueOf(last.charAt(i))).intValue();
                    String subMiddleLeft = middle.substring(0,j);
                    String subMiddleRight = middle.substring(j+1,middle.length());
                    root.left = buildTreeAsLastAndMiddle(last,subMiddleLeft);
                    root.right = buildTreeAsLastAndMiddle(last,subMiddleRight);
                    flag = false;
                    break;
                }
            }
            if(flag == false){
                break;
            }
        }
        return root;
    }

    public static void main(String[] args){
        String before = "1245367";
        String middle = "2541637";
        String last = "5426731";
        TreeNode root = new TreeNode(-1);
        BuildTree test = new BuildTree();
        root = test.buildTreeAsPreAndMiddle(before,middle);
        root = test.buildTreeAsLastAndMiddle(last,middle);
        int a = 0;
    }
}

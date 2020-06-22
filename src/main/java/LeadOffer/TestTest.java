package LeadOffer;

import LeetCodeBaseDate.TreeNode;
import lombok.Synchronized;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName TestTest
 * @Author zhangxinkun
 * @Date 2020/4/27  7:16 PM
 * @Version 1.0
 */
public class TestTest {

    boolean flag = true;
    public int solve(TreeNode root){
        if(root == null){
            return 0;
        }
        if(!flag){
            return 0;
        }
        int leftH = solve(root.left);
        int rightH = solve(root.right);
        if(Math.abs(leftH - rightH) > 1){
            flag = false;
        }
        return Math.max(leftH,rightH)+1;
    }

    public static void main(String[] args){
//        TestTest testTest = new TestTest();
    }
}

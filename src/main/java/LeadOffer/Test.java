package LeadOffer;

import LeetCodeBaseDate.TreeNode;

import java.util.*;

/**
 * @ClassName Test
 * @Author zhangxinkun
 * @Date 2020/4/1  7:30 PM
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args){
        Test test = new Test();
        System.out.println(test.xorOperation(5,0));
        System.out.println(test.xorOperation(1,7));
        System.out.println(test.xorOperation(4,3));
    }

    public int xorOperation(int n, int start) {
        int temp = 0;
        int ans = 0;
        if(n == 1){
            return start;
        }
        ans = start;
        for(int i=1; i< n;i++){
            ans = ans^(start+i*2);
        }
        return ans;
    }
}

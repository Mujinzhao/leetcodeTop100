package LeetCodeTencentTop50;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName GOUGUNumber
 * @Author zhangxinkun
 * @Date 2019/11/21  6:18 PM
 * @Version 1.0
 */
public class GOUGUNumber {

    public boolean solve(int[] number){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<number.length;i++){
            number[i] = number[i]*number[i];
            map.put(number[i],i);
        }
        boolean ans = false;
        return ans;
    }

    public static void main(String[] args){
        int[] number = {3,6,4,7,5};
        GOUGUNumber test = new GOUGUNumber();
        test.solve(number);
    }
}

package LeetCodeTop100;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 解析：定义一个比较器，S1+S2 大 还是 S2+S1大就行了，
 */
public class MaxNumber179 {
    public String largestNumber1(int[] nums) {
        String[] number = new String[nums.length];
        int begin = 0;
        int sum = 0;
        for (int temp:nums
             ) {
            number[begin++] = String.valueOf(temp);
            sum += temp;
        }
        if(sum == 0){
            return "0";
        }
        for(int i=0;i<number.length;i++){
            for(int j=i+1;j<number.length;j++){
                if(bigger(number[j],number[i])){
                    String temp = number[i];
                    number[i] = number[j];
                    number[j] = temp;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<number.length;i++){
            ans.append(number[i]);
        }
        return ans.toString();
    }

    private boolean bigger(String a,String b){
        if((a+b).compareTo(b+a) > 0){
            return true;
        }else{
            return false;

        }
    }

    public String largestNumber(int[] nums){
        return Arrays.stream(nums).boxed().map(p -> {
            return String.valueOf(p);
        }).sorted((a,b) -> {
            return (a+b).compareTo(b+a);
        }).reduce(String::concat).filter(s->!s.startsWith("0"))
                .orElse("0");
    }

    public static void main(String[] args){
        int[] num = {3,30,34,5,9};
        MaxNumber179 test = new MaxNumber179();
        String result = test.largestNumber1(num);

        System.out.println(test.bigger("34","3"));
        System.out.println(test.bigger("30","3"));
        System.out.println(test.bigger("5","9"));
        int a = 0;
    }
}

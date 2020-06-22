package LeetCodeBaseDate;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName Test
 * @Author zhangxinkun
 * @Date 2020/3/27  3:34 PM
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args){
        int[] number1 = {1,4,6,6,6,6,7,9,10};
        int[] number2 = {2,3,5,6,7,7,7,11,19};
        int len1 = number1.length;
        int len2 = number2.length;
        int[] ans = new int[len1+len2];
        int count = 0;
        int start1 = 0;
        int start2 = 0;
        while(start1 < len1 &&start2 < len2){
            if(number1[start1] < number2[start2]){
                if(count>=1 && ans[count-1] == number1[start1]){
                    start1++;
                }else {
                    ans[count++] = number1[start1++];
                }
            }
            else if(count>=1 && number1[start1] >= number2[start2]){
                if(ans[count-1] == number2[start2]){
                    start2++;
                }else{
                    ans[count++] = number2[start2++];
                }

            }
        }
        while(start1 < len1){
            if(ans[count-1] == number1[start1]){
                start1++;
            }else{
                ans[count++] = number1[start1++];
            }
        }
        while(start2 < len2){
            if(ans[count-1] == number2[start2]){
                start2++;
            }else{
                ans[count++] = number2[start2++];
            }
        }
        System.out.println(JSON.toJSONString(ans));
    }
}

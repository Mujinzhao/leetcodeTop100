package LeetCodeTop100;

/**
 * @ClassName OnlyOne136
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/8/1  12:17 AM
 * @Version 1.0
 */
public class OnlyOne136 {
    public int singleNumber(int[] nums) {
        int temp = 0;
        for (int onece:nums
             ) {
            temp = temp^onece;
        }
        return temp;
    }



    public static void main(String[] args){
        OnlyOne136 instance = new OnlyOne136();
        int[] nums = {4,1,2,1,2};
        System.out.println(instance.singleNumber(nums));
    }
}

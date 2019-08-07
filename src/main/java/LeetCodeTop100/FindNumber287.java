package LeetCodeTop100;

/**
 * @ClassName FindNumber287
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/8/1  12:52 AM
 * @Version 1.0
 */
public class FindNumber287 {
    public int findDuplicate(int[] nums) {
        int sum = 0;
        for (int one:nums
             ) {
            sum += one;
        }
        return sum - (nums.length)*(nums.length-1)/2;
    }

    public static void main(String[] args){
        FindNumber287 instance = new FindNumber287();
        int[] nums = {5,4,3,2,1,2};
        System.out.println(instance.findDuplicate(nums));
    }
}

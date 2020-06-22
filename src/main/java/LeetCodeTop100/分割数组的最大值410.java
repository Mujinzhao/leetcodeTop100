package LeetCodeTop100;

/**
 * @ClassName 分割数组的最大值410
 * @Author zhangxinkun
 * @Date 2020/1/31  8:17 PM
 * @Version 1.0
 */

/**
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 * 注意:
 * 数组长度 n 满足以下条件:
 *
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 示例:
 *
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 *
 * 输出:
 * 18
 *
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 */
public class 分割数组的最大值410 {
    public int splitArray(int[] nums, int m) {
        long len = nums.length;
        long left = Integer.MAX_VALUE;
        long right = 0;
        long ans = 0;
        for(int i=0;i<len;i++){
            right += nums[i];
            left = Math.min(left,nums[i]);
        }
        ans = right;
        while(left <= right){
            long mid = (left + right) >> 1;
            long sum = 0;
            long count = 0;
            for(int i=0;i<len;i++){
                if(sum + nums[i] <= mid){
                    sum += nums[i];
                }else{
                    count++;
                    sum = nums[i];
                    if(i == (len-1) && sum <= mid){
                        count++;
                    }
                }
            }
            if(count <= m){
                ans = Math.min(ans,mid);
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return (int)ans;
    }

    public static void main(String[] args){
        分割数组的最大值410 test = new 分割数组的最大值410();
        int[] nums = {1,2147483647};
        test.splitArray(nums,2);
    }
}

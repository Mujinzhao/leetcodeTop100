package LeetCodeTop100;

/**
 * @ClassName MulityList238
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/11/5  10:45 PM
 * @Version 1.0
 */

/**
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * 解析：答案 = 左边的乘积 * 右边的乘积
 *
 * 进阶：用一个数字去存左边和右边的乘积
 *
 */
public class MulityList238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] ans = new int[len];
        if(len == 2){
            ans[0] = nums[1];
            ans[1] = nums[0];
            return ans;
        }
        left[0] = 1;
        right[len-1] = 1;
        for(int i=1;i<nums.length;i++){
            left[i] = left[i-1] * nums[i-1];
            right[len -i -1] = right[len -i] * nums[len -i];
        }
        for(int i=0;i<len;i++){
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    public int[] productExceptSelfUp(int[] nums) {
        int len = nums.length;
        int sum = 1;
        int[] ans = new int[len];
        if(len == 2){
            ans[0] = nums[1];
            ans[1] = nums[0];
            return ans;
        }
        ans[0] = 1;
        ans[len-1] = 1;
        for(int i=1;i<nums.length;i++){
            ans[i] = sum * nums[i-1];
            sum = ans[i];
        }
        sum = 1;
        for(int i= len-2;i>=0;i--){
            ans[i] = ans[i] * nums[i+1]* sum;
            sum = nums[i+1] * sum;
        }
        return ans;
    }

    public static void main(String[] args){
        MulityList238 test = new MulityList238();
        int[] nums = {1,2,3,4};
        test.productExceptSelf(nums);
    }
}

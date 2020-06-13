package LeetCodeTop100;

/**
 * @ClassName 下一个排列31
 * @Author zhangxinkun
 * @Date 2020/3/15  12:16 PM
 * @Version 1.0
 */

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 就是找大于给定数字的下一个比它大的数字。
 *
 * 题干的意思是：找出这个数组排序出的所有数中，刚好比当前数大的那个数
 *
 * 比如当前 nums = [1,2,3]。这个数是123，找出1，2，3这3个数字排序可能的所有数，排序后，比123大的那个数 也就是132
 *
 * 如果当前 nums = [3,2,1]。这就是1，2，3所有排序中最大的那个数，那么就返回1，2，3排序后所有数中最小的那个，也就是1，2，3 -> [1,2,3]
 *
 * 这个看官方的题解最清晰，就不再赘述。
 */
public class 下一个排列31 {
    public void nextPermutation(int[] nums) {
        int i=0;
        int j=0;
        int len = nums.length - 1;
        i = len-1;
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i >= 0){
            j = len;
            while(i < j && nums[j]<= nums[i]){
                j--;
            }
            swap(nums,i,j);
            reverse(nums,i+1,len);
        }else{
            reverse(nums,0,len);
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums,int i,int j){
        while(i <= j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}

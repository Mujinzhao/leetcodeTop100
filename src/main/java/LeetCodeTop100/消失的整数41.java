package LeetCodeTop100;

/**
 * @ClassName 消失的整数41
 * @Author zhangxinkun
 * @Date 2019/12/24  9:53 PM
 * @Version 1.0
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 *
 * 用数组本身做hash，这里有技巧的是，这个while怎么写。   765
 */
public class 消失的整数41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 1;
        }
        for(int i=0;i<len;i++){
            //这里的while写的方式就是，直到不能交换为止，不交换。
            while(nums[i]>=1 && nums[i] <=len && nums[nums[i]-1] != nums[i]){
                swap(nums,nums[i]-1,i);
            }
        }
        for(int i=0;i<len;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return len+1;
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

package LeetCodeTop100;

/**
 * @ClassName 三数之和15
 * @Author zhangxinkun
 * @Date 2019/12/30  6:41 PM
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * 解析：这一题的关键点就是如何去除重复，
 */
public class 三数之和15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if(len<3){
            return ans;
        }
        int left = 0;
        int right = 0;
        for(int i=0;i<len;i++){
            if(nums[i] > 0){
                break;
            }
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            left = i+1;
            right = len-1;
            while(left < right){
                int sum = (nums[i] + nums[left] + nums[right]);
                if(sum < 0){
                    left++;
                }else if(sum > 0){
                    right--;
                }else{
                    while(left<right && nums[left+1] == nums[left]){
                        left++;
                    }
                    while(left<right && nums[right-1] == nums[right]){
                        right--;
                    }
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        三数之和15 test = new 三数之和15();
        test.threeSum(nums);
    }
}

package LeetCodeTop100;

/**
 * 给你一个无序的数组 nums, 将该数字 原地 重排后使得 nums[0] <= nums[1] >= nums[2] <= nums[3]...。
 *
 * 示例:
 *
 * 输入: nums = [3,5,2,1,6,4]
 * 输出: 一个可能的解答是 [3,5,1,6,2,4]
 *
 * 这一题可以直观的 先把数组排个序，然后交换相邻的位置就可以，
 * 但是也可以不排序，一遍扫描，相邻的位置，如果顺序正确就跳过，如果顺序不对就交换即可。
 */
public class SwingSort280 {
    public void wiggleSort(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return;
        }
        boolean less = true;
        for(int i=0 ;i+1<nums.length;i++){
            if(less){
                if(nums[i] > nums[i+1]){
                    swap(nums,i,i+1);
                }
            }else{
                if(nums[i] < nums[i+1]){
                    swap(nums,i,i+1);
                }
            }
            less = !less;
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

package LeetCodeTop100;

/**
 * @ClassName ThreeAsc334
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/11/12  11:48 PM
 * @Version 1.0
 */

/**
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 数学表达式如下:
 *
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 *
 * 输入: [5,4,3,2,1]
 * 输出: false
 *
 * 解析：先找到连续递增的两个数，再去看有没有在这两个递增后面更大的。
 * 说一下为什么这种情况能覆盖所有的情况：
 * 首先如果循环中一直都找不到第二大的数，说明这个数组是递减的，所以不可能有连续三个递增的。
 * 当第一次找到目前为止最小的，和第二大（连续两个数字挨着的递增）时，
 */
public class ThreeAsc334 {
    public boolean increasingTriplet(int[] nums) {
        int i=0;
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        while(i<nums.length){
            if(nums[i] <= small){
                small = nums[i];
            }else if(nums[i] <= big){
                big = nums[i];
            }else{
                return true;
            }
            i++;
        }
        return false;
    }
}

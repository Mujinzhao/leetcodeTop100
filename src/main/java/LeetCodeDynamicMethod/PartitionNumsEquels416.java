package LeetCodeDynamicMethod;

/**
 * leetcode 416 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * 解题思路：动态规划中的 01背包 问题变种，每一个物品只有选或者不选，并且当前的状态（dp(i~j);当前）只会从 上一个状态（）
 */
public class PartitionNumsEquels416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int temp : nums){
            sum += temp;
        }
        if(sum%2 == 1) return false;
        else sum = sum/2;

        boolean[][] dp = new boolean[sum+1][nums.length+1];
        int[] NewNums = new int[nums.length+1];
        int pos = 1;
        for (int temp:nums
             ) {
            NewNums[pos++] = temp;
        }
        dp[0][0] = true;

        for(int i=1; i<=sum; i++){
            for(int j=1; j < NewNums.length ;j++){
                if(i >= NewNums[j]){
                    dp[i][j] = dp[i][j-1] || dp[i-NewNums[j]][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        for(int i=0; i<dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }

        int a=1;
        return dp[sum][nums.length];
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        PartitionNumsEquels416 instance = new PartitionNumsEquels416();
        System.out.println(instance.canPartition(nums));
    }
}

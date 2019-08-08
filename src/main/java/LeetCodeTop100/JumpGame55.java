package LeetCodeTop100;

/**
 * @ClassName JumpGame55
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/8/8  3:46 PM
 * @Version 1.0
 */

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 思路：  从第一个数字开始，如果发现在这个数字能到达的范围内的数字，没有比它更强的数字（能到达更远的地方），并且这个时候还没有到达最后数字的能力，
 * 这个时候就可以断定，不可能走到最后一个数字。
 *
 *
 * 这一题可以用DP求解，还没掌握！
 */
public class JumpGame55 {

    public boolean canJump(int[] nums) {
        int i=0,j=0;
        for(;i<nums.length ;){
            if((nums[i] + i + 1) >= nums.length){
                return true;
            }
            boolean flag = false;
            if(nums[i] == 0) {
                return false;
            }
            for(j=i+1; j <= nums[i]+i; j++){
                if(nums[j] + j <= nums[i] + i){
                    continue;
                }else{
                    flag = true;
                    i = j;
                    break;
                }
            }
            if(!flag){
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args){
        JumpGame55 instance = new JumpGame55();
        int[] nums = {2,5,0,0};
        System.out.println(instance.canJump(nums));
    }
}

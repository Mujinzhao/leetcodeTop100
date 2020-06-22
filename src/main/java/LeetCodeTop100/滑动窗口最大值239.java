package LeetCodeTop100;

/**
 * @ClassName 滑动窗口最大值239
 * @Author zhangxinkun
 * @Date 2020/4/15  8:52 AM
 * @Version 1.0
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 *
 *  
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *  解析：剑指offer原题
 */
public class 滑动窗口最大值239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque();
        int n = nums.length;
        int[] ans = new int[1];
        if(n == 0){
            return ans;
        }
        if(n<k){
            int max = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                max = Math.max(max,nums[i]);
            }
            ans = new int[1];
            ans[0] = max;
            return ans;
        }
        ans = new int[n-k+1];
        queue.offer(0);
        for(int i=1;i<k;i++){
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            queue.offer(i);
        }
        ans[0] = nums[queue.peekFirst()];
        for(int i=k;i<n;i++){
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            queue.offerLast(i);
            while(!queue.isEmpty() && queue.peekFirst() < i-k+1){
                queue.pollFirst();
            }
            ans[i-k+1] = nums[queue.peekFirst()];
        }
        return ans;
    }
}

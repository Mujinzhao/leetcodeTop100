package LeetCodeMedia;

/**
 * @ClassName 旋转数组189
 * @Author zhangxinkun
 * @Date 2020/1/29  5:08 PM
 * @Version 1.0
 */

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * 解析：这个问题的关键是需要进行原地旋转。
 * 方法一：找一个元素，直接把它放到正确的位子上，但是这个被覆盖的元素用一个temp保存下来，然后这个temp再去放到争取的位子上，循环N次即可。
 * 方法二：旋转数组，然后前K个元素再翻转，后面的翻转，然后就结束了。！！！！这个方法极其巧妙。
 */
public class 旋转数组189 {
    //方法一：
    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        int now;
        int count = 0;
        for(int i=0;count<len;i++){
            now = i;
            int preNum = nums[now];
            do{
                int next = (now+k)%len;
                int temp = nums[next];
                nums[next] = preNum;
                preNum = temp;
                now = next;
                count++;
            }while(i!=now);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
    }




    //方法二：
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);
    }

    public void reverse(int[] nums,int begin,int end){
        while(begin < end){
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }
}

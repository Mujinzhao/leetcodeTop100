package LeetCodeTop100;

/**
 * @ClassName FindNumber287
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/8/1  12:52 AM
 * @Version 1.0
 */

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次
 *
 * 和剑指offer 面试3 4 一个类型。
 * 这一题解法很多，
 *
 * 首先对比一下这几题的题干：
 * 1、剑指offer 面试3：  在一个长度n的数组中，所有的数字都在 0-n-1的范围内。数组中某一些数字是重复的，但不知道有几个重复了，也不知道每个数字
 * 重复了多少次。请找出任意一个重复的数字。
 * 2、剑指offer 面试4：  在一个长度N+1的数组中，所有的数字都在1-n的范围内，所以数组中至少有一个是重复的。请找出数组中任意一个重复的数字。
 *
 * 然后就是LeetCode这一题。
 *
 * 分析一下题干，可以发现，目前又很大的不同之处是：数组的长度和数组内数字的范围，造成了这三体本质上的不一样。
 * offer的第三题  可以理解为，就是N 的数组，范围也是小于等于N，所以这一题，可以利用，数组中每个数应该在那个位子上去解决。
 * offer的第四题，和LeetCode这一题，都是在讲鸽巢定理，解决方案：
 * 二分数组的取值范围，去找在这个范围内，数组中出现了多少次，如果符合一个萝卜一个坑，那么就在更大的范围，如果不符合继续缩小此范围。代码如下：
 *
 */
public class 寻找重复数287 {
    public int findDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right - left) >> 1;
            int count = 0;
            for(int temp:nums){
                if(temp <= mid){
                    count++;
                }
            }
            if(count > mid){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args){
        寻找重复数287 instance = new 寻找重复数287();
        int[] nums = {5,4,3,2,1,2};
        System.out.println(instance.findDuplicate(nums));
        class Point{
            int x;
            int y;
            int step = 0;

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }

            public int getStep() {
                return step;
            }

            public void setStep(int step) {
                this.step = step;
            }
        }
    }
}

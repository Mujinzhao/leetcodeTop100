package LeetCodeTop100;

/**
 * @ClassName RandomIndex398
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/8/7  3:16 PM
 * @Version 1.0
 */

/**
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 *
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 *
 * 示例:
 *
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 *
 * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
 * solution.pick(3);
 *
 * // pick(1) 应该返回 0。因为只有nums[0]等于1。
 * solution.pick(1);
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-pick-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RandomIndex398 {
    private int index;
    private int[] temp;
    public RandomIndex398(int[] nums) {
        temp = nums;
        index = 0;
    }

    public int pick(int target) {
        do{
            index++;
            index = index % temp.length;
        }while(temp[index] != target);
        return index;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,3,3};
        RandomIndex398 instance = new RandomIndex398(nums);

        System.out.println(instance.pick(2));
        System.out.println(instance.pick(3));
        System.out.println(instance.pick(3));
        System.out.println(instance.pick(3));
        System.out.println(instance.pick(3));
        System.out.println(instance.pick(3));

    }
}

/**
 * 这一题还是比较简单的，但是这里引申出一个算法，叫做蓄水池算法：
 * 蓄水池算法用于，不确定总规模情况下的抽检问题，
 * 例如：
 *
 * 1、从 100000 份调查报告中抽取 1000 份进行统计。
 * 2、从一本很厚的电话簿中抽取 1000 人进行姓氏统计。
 * 3、从 Google 搜索 "Ken Thompson"，从中抽取 100 个结果查看哪些是今年的。
 */
package LeetCodeTop100;

/**
 * @ClassName 只出现一次的数字137
 * @Author zhangxinkun
 * @Date 2019/12/30  3:57 PM
 * @Version 1.0
 */

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 *
 * 解析：普通解法：每一位都用一个数字保存一下，1出现了多少次，最后判断出现的次数是不是1的3倍即可
 *
 * 一般的写法：位运算，设计一个k进制的无进位加法计算器。
 */
public class 只出现一次的数字137 {
    public int singleNumber(int[] nums) {
        int[] bit = new int[32];
        int len = nums.length;
        int result = 0;
        for(int i=0;i<32;i++){
            int count=0;
            for(int j=0;j<len;j++){
                if((nums[j]&(1<<i)) != 0){
                    count++;
                }
            }
            if(count%3 != 0){
                result |= 1<<i;
            }
        }
        return result;
    }

    /**
     * 可以这么理解：
     * bit【i】表示的就是，第i位上的1的个数（是一个32位的整数，多个bit数字是一个整体，才能去表示整个nums数组中某一位的1的个数），每遇到出现3次就归零，重新开始计算。
     *
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        int bit1 = 0;
        int bit2 = 0;
        for(int i=0;i<nums.length;i++){
            //这一段是为了求最高位是否应该进位，只有后面低位的数字都是1的时候，才需要进位。
            bit2 = bit2^(bit1&nums[i]);
            bit1 = bit1^nums[i];
            //这一段是为了看整个数字是不是应该归零，只有所有的数字都是1的时候，整体才需要归零。
            int mask = ~(bit1&bit2);
            bit2 = bit2&mask;
            bit1 = bit1&mask;
        }
        return bit1;
    }
}

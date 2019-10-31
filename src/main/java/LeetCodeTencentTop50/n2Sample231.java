package LeetCodeTencentTop50;

/**
 * @ClassName n2Sample231
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/10/31  10:58 PM
 * @Version 1.0
 */

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 *
 *
 * 二进制中1的个数 可以这么理解：
 * 当这个数字减一的时候，从右往左看过去，一定是第一个不为零的数字被借位，变成0，n-1 变成了从第一个不为0的右边都为1的数字，两个数字相与，总是能
 * 把第一个不为0的1 变成0  如果这个时候整个数字还是不为0，那么这个数字中肯定还是有1！！！！
 */
public class n2Sample231 {
    public boolean isPowerOfTwo(int n) {
        int sum = 0;
        if(n <= 0){
            return false;
        }
        while(n != 0){
            n = n & (n-1);
            sum++;
        }
        if(sum == 1){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 判断数字是不是2的4次幂
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {
        int sum = 0;
        int temp = num;
        if(num == 4 || num == 1) {
            return true;
        }
        boolean n2 = false;
        if(num <= 0){
            return false;
        }
        while(num != 0){
            num = num & (num-1);
            sum++;
        }
        if(sum == 1){
            n2 = true;
        }else {
            return false;
        }
        int bit = 0;
        while(temp != 1){
            bit++;
            temp = temp>>1;
        }
        if(n2 && (bit&1) == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        n2Sample231 test = new n2Sample231();
        int n = 16;
        System.out.println(test.isPowerOfFour(n));
        System.out.println(test.isPowerOfFour(64));
        System.out.println(test.isPowerOfFour(32));
    }
}

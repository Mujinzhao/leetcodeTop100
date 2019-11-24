package LeetCodeTop100;

/**
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 *
 * 注意:
 * n 是正数且在32为整形范围内 ( n < 231)。
 *
 * 示例 1:
 *
 * 输入:
 * 3
 *
 * 输出:
 * 3
 * 示例 2:
 *
 * 输入:
 * 11
 *
 * 输出:
 * 0
 *
 * 说明:
 * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 * 在真实的面试中遇到过这道题？
 *
 * 解析：计算出各个位 数字总共有多少个数字  比如两位数字总共有 10到99 90个，总共有90*2 = 180个字符，
 * 三位数  100 - 999 工900个，共900*3  2700个字符。
 */
public class Nnumber400 {
    public int findNthDigit(int n) {
        if(n <= 9){
            return n;
        }
        if(n%10 == 0){
            return 1;
        }
        n -= 9;
        int i = 0;
        for(i=2; ;i++){
            if((n - 9*i*(int)Math.pow(10,i-1)) > 0){
                n = n - 9*i*(int)Math.pow(10,i-1);
            }else{
                break;
            }
        }
        int next = n/i;
        int nextBit = n%i;
        next = (int)Math.pow(10,i-1)+next;
        if(nextBit == 0){
            next--;
        }
        String number = String.valueOf(next);
        // System.out.println(next);
        if(nextBit == 0){
            return Integer.valueOf(String.valueOf(number.charAt(number.length()-1)));
        }else{
            // System.out.println(number.charAt(nextBit));
            return Integer.valueOf(String.valueOf(number.charAt(nextBit)));
        }
    }
}

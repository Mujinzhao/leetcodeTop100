package LeetCodeDynamicMethod;

/**
 * @ClassName DiffNumber357
 * @Author zhangxinkun
 * @Date 2019/11/19  11:33 PM
 * @Version 1.0
 */

/**
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 *
 * 示例:
 *
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 *
 * 解析，就是个排列的计算，比较简单
 */
public class DiffNumber357 {
    public int jisuan(int start,int time){
        if(time <= 0){
            return 1;
        }
        return start*jisuan(start-1,time-1);
    }
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 10;
        }
        int ans = 10;
        if(n<=10){
            for(int i=2;i<=n;i++){
                int temp = 9 * jisuan(9,i-1);
                ans += temp;
            }
        }

        return ans;
    }
}

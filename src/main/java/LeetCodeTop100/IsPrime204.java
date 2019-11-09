package LeetCodeTop100;

/**
 * @ClassName IsPrime204
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/11/7  10:44 PM
 * @Version 1.0
 */

/**
 * 求出 小于N 的所有素数的个数
 *
 * 就是判断一个数是不是素数,就是埃氏筛选法则；首先已2为 素数的底，那么素数的倍数都不可能为素数；
 * 所以每次循环 都不需要进入到素数的倍数里面进行判断，减少内循环次数。这个算法背下来。
 * 如果是题目改为 判断一个数是不是素数，直接代码不改变，返回flag[n]是真还是假就行了。
 */
public class IsPrime204 {
    public int countPrimes(int n) {
        if(n == 1){
            return 1;
        }
        boolean[] flag = new boolean[n];
        int count = 0;
        for(int i = 2;i<n;i++){
            if(!flag[i]){
                count++;
                System.out.println(i);
                for(int j=i+i;j<n;j+=i){
                    flag[j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        IsPrime204 test = new IsPrime204();
        System.out.println(test.countPrimes(12));
    }
}

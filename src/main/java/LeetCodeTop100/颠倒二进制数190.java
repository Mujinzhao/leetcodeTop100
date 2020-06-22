package LeetCodeTop100;

/**
 * @ClassName 颠倒二进制数190
 * @Author zhangxinkun
 * @Date 2020/1/12  9:44 PM
 * @Version 1.0
 */
public class 颠倒二进制数190 {
    public int reverseBits(int n) {
        int i = 32;
        int ans = 0;
        while(i>0){
            ans <<= 1;
            ans += n&1;
            n>>=1;
            i--;
        }
        return ans;
    }
}

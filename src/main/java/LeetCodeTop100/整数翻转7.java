package LeetCodeTop100;

/**
 * @ClassName 整数翻转7
 * @Author zhangxinkun
 * @Date 2020/1/12  8:33 PM
 * @Version 1.0
 */
public class 整数翻转7 {
    public int reverse(int x) {
        int ans = 0;
        int temp = x;
        x = Math.abs(x);
        while(x > 0){
            if(temp > 0 && ans > Integer.MAX_VALUE/10) {
                return 0;
            }
            if(temp < 0 && -ans < Integer.MIN_VALUE/10){
                return 0;
            }
            ans = ans * 10;
            int last = x%10;
            x /= 10;
            ans += last;
        }
        return temp>0?ans:-ans;
    }

    public static void main(String[] args){
        整数翻转7 test = new 整数翻转7();
        System.out.println(test.reverse(976));
        System.out.println(test.reverse(-76214));
    }
}

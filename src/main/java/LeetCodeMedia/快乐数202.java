package LeetCodeMedia;

/**
 * @ClassName 快乐数202
 * @Author zhangxinkun
 * @Date 2020/1/29  12:00 PM
 * @Version 1.0
 */

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例: 
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 解析：用hash或者set都会导致存储的数量过多，所以这种判断循环的方法，可以采用快慢指针的方式进行！！！！
 */
public class 快乐数202 {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = caculate(slow);
            fast = caculate(fast);
            fast = caculate(fast);
        }while(slow != fast);

        return slow == 1;
    }

    public int caculate(int n){
        int sum = 0;
        while(n>0){
            sum += (n%10)*(n%10);
            n = n/10;
        }
        return sum;
    }
}

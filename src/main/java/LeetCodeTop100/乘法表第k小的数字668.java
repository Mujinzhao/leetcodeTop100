package LeetCodeTop100;

/**
 * @ClassName 乘法表第k小的数字668
 * @Author zhangxinkun
 * @Date 2020/2/20  9:02 PM
 * @Version 1.0
 */

/**
 * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
 *
 * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
 *
 * 例 1：
 *
 * 输入: m = 3, n = 3, k = 5
 * 输出: 3
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 *
 * 第5小的数字是 3 (1, 2, 2, 3, 3).
 * 例 2：
 *
 * 输入: m = 2, n = 3, k = 6
 * 输出: 6
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 *
 * 第6小的数字是 6 (1, 2, 2, 3, 4, 6).
 * 注意：
 *
 * m 和 n 的范围在 [1, 30000] 之间。
 * k 的范围在 [1, m * n] 之间。
 */
public class 乘法表第k小的数字668 {
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m*n;
        while(left <= right){
            int mid = (left + right)>>1;
            if(isOK(m,n,k,mid)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }

    public boolean isOK(int m,int n,int k,int num){
        int sum = 0;
        for(int j=1;j<=m;j++){
            int left = 1;
            int right = n;
            while(left <= right){
                int mid = (left + right)>>1;
                if(mid*j >= num){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            sum += right;
        }
        return sum >=k;
    }
}

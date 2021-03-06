package LeetCodeTop100;

/**
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为 0 或 1 
 *
 * 解析：滑动窗口，遇到0，就用1替换。
 */
public class 最大连续1的个数1004 {
    public int longestOnes(int[] A, int K) {
        int len = A.length;
        if(len == 0){
            return 0;
        }
        int max = -1;
        int left = 0;
        int right = 0;
        for( ; right<len;){
            if(A[right] == 1){
                right++;
            }else{
                if(K > 0){
                    K--;
                    right++;
                }else{
                    while(A[left] == 1){
                        left++;
                    }
                    left++;
                    K++;
                }
            }
            max = Math.max(max,(right-left));
        }
        return max;
    }
}

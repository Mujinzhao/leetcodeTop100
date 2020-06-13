package LeetCodeMedia;

/**
 * @ClassName TopKMetrics378
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/10/24  6:28 PM
 * @Version 1.0
 */

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 *
 * 示例:
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 * 说明:
 * 你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。
 *
 *
 * 解析：left为matrix[0][0]，right为matrix[len][len];
 * 二分没一个数字，然后统计这个矩阵中小于这个数字的个数（每一行统计的时候又可以用二分），
 * 如果小于k个  left = mid+1；如果大于k个 right = mid - 1；如果恰好等于k个，还是要往左边逼近 所以 right = mid - 1;
 *
 * 返回的时候，需要返回我们找到的这个数字的左边一个。
 */
public class 矩阵中的第k小数字378 {

    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int max = matrix[len-1][len-1];
        int min = matrix[0][0];
        int left = min;
        int rigth = max;
        while(left <= rigth){
            int mid = left + (rigth-left)/2;
            if(isOK(matrix,mid,k)){
                rigth = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return rigth;
    }

    public boolean isOK(int[][] matrix,int num,int k){
        int len = matrix.length;
        int sum = 0;
        for(int i=0;i<len;i++){
            int left = 0;
            int right = len-1;
            while(left <= right){
                int mid = (left+right)>>1;
                if(matrix[i][mid] >= num){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            sum += (left>=len?len:left);
        }
        return sum>=k;
    }

    public static void main(String[] args){
        int[][] matrics = {{1,5,9},{10,11,13},{12,13,15}};
        矩阵中的第k小数字378 test = new 矩阵中的第k小数字378();
        int ans = test.kthSmallest(matrics,8);
    }
}

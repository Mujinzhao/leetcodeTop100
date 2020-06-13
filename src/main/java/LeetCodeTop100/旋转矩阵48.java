package LeetCodeTop100;

/**
 * @ClassName 旋转矩阵48
 * @Author zhangxinkun
 * @Date 2020/4/12  9:45 PM
 * @Version 1.0
 */

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class 旋转矩阵48 {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        if(N == 0){
            return ;
        }
        for(int i=0;i<(N+1)/2;i++){
            for(int j=i;j<N-i-1;j++){
                int store = matrix[i][j];
                int nextX = j;
                int nextY = N-i-1;
                int count = 0;
                while(count < 4){
                    int tempStore = matrix[nextX][nextY];
                    matrix[nextX][nextY] = store;
                    store = tempStore;
                    int tempX = nextX;
                    nextX = nextY;
                    nextY = N-tempX-1;
                    count++;
                }
            }
        }
    }
}

package LeetCodeDynamicMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName TriangleSum120
 * @Author zhangxinkun
 * @Date 2019/11/19  8:42 AM
 * @Version 1.0
 */

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * 动态规划：和三种费用涂颜料的题目很像，每个状态只能从 上面和左边过来，dp[n] = min(dp[n-1],dp[n]) ，排除掉当n =0 和 n = 最后一个的情况.
 */
public class TriangleSum120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        if(size == 0){
            return 0;
        }
        if(size == 1){
            return triangle.get(0).get(0);
        }
        int[] dp = new int[size];
        int[] dp1 = new int[size];
        dp[0] = triangle.get(0).get(0);
        dp1[0] = dp[0];
        for(int i=1;i<size;i++){
            int j=0;
            for(j=0;j<triangle.get(i).size()-1;j++){
                if(j == 0){
                    dp1[j] = dp[j]+triangle.get(i).get(j);
                }
                else{
                    dp1[j] = Math.min(dp[j],dp[j-1]) + triangle.get(i).get(j);
                }
            }
            dp1[j] = dp[j-1] + triangle.get(i).get(j);
            int temp = 0;
            while(temp<size){
                dp[temp] = dp1[temp];
                temp++;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<size;i++){
            min = Math.min(dp[i],min);
        }
        return min;
    }

    public static void main(String[] args){
        TriangleSum120 test = new TriangleSum120();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        //[[2],[3,4],[6,5,7],[4,1,8,3]]
        temp.add(2);
        ans.add(temp);
        temp = new ArrayList<>();
        temp.add(3);
        temp.add(4);
        ans.add(temp);
        temp = new ArrayList<>();
        temp.add(6);
        temp.add(5);
        temp.add(7);
        ans.add(temp);
        temp = new ArrayList<>();
        temp.add(4);
        temp.add(1);
        temp.add(8);
        temp.add(3);
        ans.add(temp);
        test.minimumTotal(ans);
    }
}

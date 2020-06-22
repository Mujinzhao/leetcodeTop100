package LeetCodeTop100;

/**
 * @ClassName 合并区间56
 * @Author zhangxinkun
 * @Date 2020/1/30  9:25 PM
 * @Version 1.0
 */

import java.util.*;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 解析：最直观的方法：先按照x进行从小到大的排序，然后一个个往后面找，直到找不到能覆盖的区间，这个时候就找到了一个新的覆盖。
 */
public class 合并区间56 {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        List<int[]> arr = new ArrayList();
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[0] - b[0];
            }
        });
        for(int i=0;i<len;){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while(i+1<len && right >= intervals[i+1][0]){
                right = Math.max(intervals[i+1][1],right);
                i++;
            }
            arr.add(new int[]{left,right});
            i++;
        }
        int[][] ans = new int[arr.size()][2];
        for(int i=0;i<arr.size();i++){
            ans[i] = arr.get(i);
        }
        return ans;
    }
}

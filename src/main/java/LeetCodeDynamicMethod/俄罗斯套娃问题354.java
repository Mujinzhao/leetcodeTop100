package LeetCodeDynamicMethod;

import java.util.Arrays;
import java.util.Comparator;

/**
 *给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 *
 * 解析 ： 先宽度排序，然后高度排序，然后对高度数组进行 计算最长上升序列
 */
public class 俄罗斯套娃问题354 {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // 按宽度升序排列，如果宽度一样，则按高度降序排列
        Arrays.sort(envelopes, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ?
                        b[1] - a[1] : a[0] - b[0];
            }
        });
        // 对高度数组寻找 LIS
        int[] height = new int[n];
        for (int i = 0; i < n; i++)
            height[i] = envelopes[i][1];
        return lengthOfLIS(height);
    }

    public int lengthOfLIS(int[] height){
        int len = height.length;
        if(len == 0){
            return 0;
        }
        int[] top = new int[len];
        int piples = 0;
        for(int i=0;i<len;i++){
            int left = 0;
            int right = piples;
            while(left < right){
                int mid = (left + right) >> 1;
                if(top[mid] < height[i]){
                    left = mid+1;
                }else{
                    right = mid;
                }
            }
            if(left == piples){
                piples++;
            }
            top[left] = height[i];
        }
        return piples;
    }
}

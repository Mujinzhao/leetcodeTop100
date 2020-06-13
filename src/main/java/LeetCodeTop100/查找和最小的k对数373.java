package LeetCodeTop100;

/**
 * @ClassName 查找和最小的k对数373
 * @Author zhangxinkun
 * @Date 2020/2/20  2:42 PM
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 *
 * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 *      [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 示例 2:
 *
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 *      [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 示例 3:
 *
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 *
 *
 * 解析：直接用堆进行求解，基本上是堆的模板题

 */
public class 查找和最小的k对数373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(k,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return (a[0]+a[1]) - (b[0]+b[1]);
            }
        });
        List<List<Integer>> ans = new ArrayList();
        int len1 = nums1.length;
        int len2 = nums2.length;
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                int[] temp = new int[2];
                temp[0] = nums1[i];
                temp[1] = nums2[j];
                queue.offer(temp);
            }
        }
        for(int i=0;!queue.isEmpty()&&i<k;i++){
            List<Integer> inner = new ArrayList();
            int[] temp = queue.peek();
            inner.add(temp[0]);
            inner.add(temp[1]);
            queue.poll();
            ans.add(inner);
        }
        return ans;
    }
}

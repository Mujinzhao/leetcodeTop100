package LeetCodeTop100;

/**
 * @ClassName 前K个高频元素347
 * @Author zhangxinkun
 * @Date 2020/1/12  10:23 PM
 * @Version 1.0
 */

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 *
 * 解析：使用java自带的最小堆即可。
 */
public class 前K个高频元素347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numMap = new HashMap<>();
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(numMap.containsKey(nums[i])){
                numMap.put(nums[i],numMap.get(nums[i])+1);
            }else {
                numMap.put(nums[i],1);
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer p1, Integer p2) {
                if(numMap.get(p1).equals(numMap.get(p2))){
                    return p1.intValue() - p2.intValue();
                }else{
                    return numMap.get(p2).intValue() - numMap.get(p1).intValue();
                }
            }
        });
        for(Integer temp : numMap.keySet()){
            queue.offer(temp);
        }
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty() && k>0){
            ans.add(queue.poll());
            k--;
        }
        return ans;
    }
}

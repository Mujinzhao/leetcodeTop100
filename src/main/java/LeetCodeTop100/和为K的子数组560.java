package LeetCodeTop100;

/**
 * @ClassName 和为K的子数组560
 * @Author zhangxinkun
 * @Date 2020/2/10  9:29 PM
 * @Version 1.0
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 解析：从头到尾扫描数组，记录扫描到的位子的和，然后用Map进行存储sum出现的次数，没到一个位子，就看sum-k出现过没，出现过说明有子数组和为k
 *
 * 本题可以类比974，思路更清奇。
 * */
public class 和为K的子数组560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> sumMap = new HashMap();
        int sum = 0;
        int ans = 0;
        sumMap.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(sumMap.containsKey(sum - k)){
                ans += sumMap.get(sum-k);
            }
            if(sumMap.containsKey(sum)){
                sumMap.put(sum,sumMap.get(sum)+1);
            }else{
                sumMap.put(sum,1);
            }
        }
        return ans;
    }
}

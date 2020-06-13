package LeetCodeTop100;

/**
 * @ClassName 全排列无重复47
 * @Author zhangxinkun
 * @Date 2020/3/15  10:41 AM
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 解析：理解了全排列的算法，这个就不难理解，（在选定索引是i的位置的数字的时候，用过的数字无需重复使用）
 */
public class 全排列无重复47 {
    List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList();
        int len = nums.length;
        solve(nums,0,len);
        return ans;
    }

    public void solve(int[] nums,int index,int len){
        if(index >= len){
            List<Integer> tempAns = new ArrayList();
            for(int i=0;i<len;i++){
                tempAns.add(nums[i]);
            }
            ans.add(tempAns);
            return;
        }
        Set<Integer> numberSet = new HashSet();
        for(int i=index;i<len;i++){
            if(!numberSet.contains(nums[i])){
                numberSet.add(nums[i]);
                swap(nums,i,index);
                solve(nums,index+1,len);
                swap(nums,i,index);
            }
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

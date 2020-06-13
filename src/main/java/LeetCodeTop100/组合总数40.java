package LeetCodeTop100;

/**
 * @ClassName 组合总数40
 * @Author zhangxinkun
 * @Date 2020/4/19  8:58 PM
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class 组合总数40 {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList();
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList();
        solve(0,candidates,target,0,temp);
        return ans;
    }

    public void solve(int step,int[] candidates,int target,int sum,List<Integer> tempAns){
        if(sum > target){
            return;
        }
        if(sum == target){
            if(!ans.contains(tempAns)){
                ans.add(new ArrayList(tempAns));
                return ;
            }
        }
        for(int i=step;i<candidates.length;i++){
            //这里就可以简单的理解为 ，同一层不要选一样的节点就行了。为什么是不等于step呢，因为其实step-1是上一层选的节点值，这一层不需要和上一层的值进行比较
            if(i!=step && candidates[i] == candidates[i-1]){
                continue;
            }
            tempAns.add(candidates[i]);
            solve(i+1,candidates,target,sum+candidates[i],tempAns);
            tempAns.remove(tempAns.size()-1);
        }
    }
}

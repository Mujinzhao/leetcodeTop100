package LeetCodeTencentTop50;

/**
 * @ClassName PartitionLabels763
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/10/18  12:02 AM
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "ababcbacadefegdehijhklij"
 * 输出: [9,7,8]
 * 解释:
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * 注意:
 * <p>
 * S的长度在[1, 500]之间。
 *
 *
 * 解题思路：先把每个字符出现的最后位置确定，然后从第一个字符开始，
 * 一直走到这个字符出现的最后位置，这个过程中，如果没有字符的最后位置
 * ，比这个字符的结束位置更大，那这个字符结束的位置就是一个划分，
 * 如果有更大的，那就以更大的结束位置为基准，重新开始。
 */
public class PartitionLabels763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        char[] tempS = S.toCharArray();
        Map<Character, Integer> numRecord = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            numRecord.put(tempS[i], i);
        }
        int j;
        int i;
        for(i = 0;i<S.length() ; ){
            int end = numRecord.get(tempS[i]);
            j = i;
            for(; j<end ;j++){
                if(numRecord.get(tempS[j]) <= end){
                    continue;
                }else{
                    end = numRecord.get(tempS[j]);
                }
            }
            ans.add(end+1);
            i = end+1;
        }
        if(ans.size() == 1){
            return ans;
        }else {
            for(int num=ans.size()-1 ;num >= 1 ; num--){
                ans.set(num,ans.get(num) - ans.get(num-1));
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        PartitionLabels763 test = new PartitionLabels763();
        List<Integer> ans = test.partitionLabels("ababcbacadefegdehijhklij");
        int a= 0;
    }
}

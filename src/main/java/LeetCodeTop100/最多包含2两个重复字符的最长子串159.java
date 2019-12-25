package LeetCodeTop100;

/**
 * @ClassName 最多包含2两个重复字符的最长子串159
 * @Author zhangxinkun
 * @Date 2019/12/24  11:43 PM
 * @Version 1.0
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t 。
 *
 * 示例 1:
 *
 * 输入: "eceba"
 * 输出: 3
 * 解释: t 是 "ece"，长度为3。
 * 示例 2:
 *
 * 输入: "ccaabbb"
 * 输出: 5
 * 解释: t 是 "aabbb"，长度为5。
 *
 * 解析：滑动窗口思想，map去存，区间内出现的字符的最右位置，当出现超过两个字符重复的时候，选一个其中重复出现的最右位置最小的字符剔除。
 */
public class 最多包含2两个重复字符的最长子串159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int ll = s.length();
        if(ll <= 2){
            return ll;
        }
        Map<Character,Integer> map = new HashMap();
        int left = 0;
        int right = 2;
        int max = 2;
        int len = 2;
        map.put(s.charAt(0),0);
        map.put(s.charAt(1),1);
        while(right < s.length()){
            map.put(s.charAt(right),right);
            if(map.size() < 3){
                len++;
            }
            if(map.size() == 3){
                int del_index = Collections.min(map.values());
                map.remove(s.charAt(del_index));
                left = del_index;
                len = right - left;
            }
            right++;
            max = Math.max(max,len);
        }
        return max;
    }
}

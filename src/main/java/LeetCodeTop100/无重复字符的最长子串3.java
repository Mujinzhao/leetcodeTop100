package LeetCodeTop100;

/**
 * @ClassName 无重复字符的最长子串3
 * @Author zhangxinkun
 * @Date 2019/12/24  10:43 PM
 * @Version 1.0
 */

import java.util.HashMap;
import java.util.Map;

/**
 *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 解析：滑动窗口，每次判断，新加入的字符串在窗口范围内是不是有重复的，如果有重复的，直接将left指针移动到重复出现的那个位置的下一个即可。
 *
 */
public class 无重复字符的最长子串3 {
    public int lengthOfLongestSubstring(String s) {
        int max = 1;
        char[] chars = s.toCharArray();
        if(chars.length == 0){
            return 0;
        }
        if(chars.length == 1){
            return 1;
        }
        Map<Character,Integer> map = new HashMap();
        int len = 1;
        int left = 0;
        map.put(chars[left],0);
        int right = 1;
        while(right < chars.length){
            if(map.containsKey(chars[right]) && map.get(chars[right])>=left){
                int tempIndex = map.get(chars[right]);
                left = tempIndex+1;
                len = right - left + 1;
                max = Math.max(max,len);
            }else{
                len++;
                max = Math.max(max,len);
            }
            map.put(chars[right],right);
            right++;
        }
        return max;
    }

    public static void main(String[] args){
        String temp = "abcabcbb";
        无重复字符的最长子串3 test = new 无重复字符的最长子串3();
        test.lengthOfLongestSubstring(temp);
    }
}

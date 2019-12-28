package LeetCodeTop100;

/**
 * @ClassName 至多包含k个不同字符的最长子串
 * @Author zhangxinkun
 * @Date 2019/12/24  11:53 PM
 * @Version 1.0
 */

import java.util.*;

/**
 * 给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。
 *
 * 示例 1:
 *
 * 输入: s = "eceba", k = 2
 * 输出: 3
 * 解释: 则 T 为 "ece"，所以长度为 3。
 * 示例 2:
 *
 * 输入: s = "aa", k = 1
 * 输出: 2
 * 解释: 则 T 为 "aa"，所以长度为 2。
 *
 * 解析：和159一样
 */
public class 至多包含k个不同字符的最长子串 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int ll = s.length();
        if(ll == 0){
            return 0;
        }
        if(ll <= k){
            return ll;
        }
        Map<Character,Integer> map = new HashMap();
        int left = 0;
        int right = 0;
        int max = -1;
        int len = 0;
        while(right < s.length()){
            map.put(s.charAt(right),right);
            if(map.size() < k+1){
                len++;
            }
            if(map.size() == k+1){
                int del_index = Collections.min(map.values());
                map.remove(s.charAt(del_index));
                left = del_index;
                len = right - left;
            }
            right++;
            max = Math.max(max,len);
        }
        List<Integer> integerList = new ArrayList<>();
        Iterator iterator = integerList.iterator();
        iterator.hasNext();
        iterator.next();
        Stack<Integer> stack = new Stack<>();
        stack.empty();
        stack.peek();
        return max;
    }
}

package LeetCodeTop100;

/**
 * @ClassName 最小覆盖子串76
 * @Author zhangxinkun
 * @Date 2020/1/31  9:33 PM
 * @Version 1.0
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 解析：这个题目一看就很容易想到是滑动窗口问题，主要是不同的字符可能会出现很多次，这个如何解决。
 */
public class 最小覆盖子串76 {
    public String minWindow(String s, String t) {
        Map<Character,Integer> key = new HashMap();
        int length = t.length();
        for(int i=0;i<t.length();i++){
            if(key.containsKey(t.charAt(i))){
                key.put(t.charAt(i),key.get(t.charAt(i))+1);
            }else{
                key.put(t.charAt(i),1);
            }
        }
        int hasBean = 0;
        String ans = new String();
        int left = 0;
        int right = 0;
        int minAns = Integer.MAX_VALUE;
        while(right < s.length()){
            //如果这个字符是目标字符
            if(key.containsKey(s.charAt(right))){
                if(key.get(s.charAt(right)) > 0){
                    hasBean++;
                }
                key.put(s.charAt(right),key.get(s.charAt(right))-1);

            }
            //如果是一个可行的窗口
            if(hasBean == length){
                while(hasBean == length){
                    if(minAns > right - left){
                        minAns = right - left + 1;
                        ans = s.substring(left,right+1);
                    }
                    if(key.containsKey(s.charAt(left))){
                        key.put(s.charAt(left),key.get(s.charAt(left))+1);
                        if(key.get(s.charAt(left)) > 0){
                            hasBean--;
                            right++;
                        }
                    }
                    left++;
                }
            }else{
                right++;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        最小覆盖子串76 test = new 最小覆盖子串76();
        test.minWindow("ADOBECODEBANC","ABC");
    }
}

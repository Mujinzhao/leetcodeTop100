package LeetCodeTop100;

/**
 * @ClassName 验证回文680
 * @Author zhangxinkun
 * @Date 2020/1/13  11:54 PM
 * @Version 1.0
 */

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 */
public class 验证回文680 {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                return ishui(s.substring(left+1,right+1))||ishui(s.substring(left,right));
            }
        }
        return true;
    }

    public boolean ishui(String a){
        int left = 0;
        int right = a.length()-1;
        while(left<right){
            if(a.charAt(left) != a.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

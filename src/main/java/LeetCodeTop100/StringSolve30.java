package LeetCodeTop100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName StringSolve30
 * @Author zhangxinkun
 * @Date 2019/11/22  9:19 AM
 * @Version 1.0
 */

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 *
 * 滑动窗口，判断两个数组的hashCode是否相等
 */
public class StringSolve30 {
    public List<Integer> findSubstring(String s, String[] words) {
        int len = words.length;
        List<Integer> ans = new ArrayList();
        if(len == 0){
            return ans;
        }
        int totleLength = len * words[0].length();
        int everyLength = words[0].length();
        int[] sHashCode = new int[len];
        for(int i=0;i<len;i++){
            sHashCode[i] = words[i].hashCode();
        }
        for(int i=0;i + totleLength <= s.length();i++){
            int temp = 1;
            int[] tempHashCode = new int[len];
            while(temp*everyLength <= totleLength){
                String fetch = s.substring(i+(temp-1)*everyLength,i+temp*everyLength);
                System.out.println(fetch);
                // System.out.println("start:"+ (i+(temp-1)*everyLength) + "end: " + (i+temp*everyLength));
                tempHashCode[temp-1] = fetch.hashCode();
                temp++;
            }
            System.out.println("helloesaefasfesaf");
            if(isEqual(sHashCode,tempHashCode)){
                ans.add(i);
            }
            // System.out.println("asdf");
        }
        return ans;
    }

    public boolean isEqual(int[] a,int[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i=0;i<a.length;i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        StringSolve30 test = new StringSolve30();
        String s = "barfoothefoobarman";
        String[] num = {"foo","bar"};
        test.findSubstring(s,num);
    }
}

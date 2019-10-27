package LeetCodeTencentTop50;

/**
 * @ClassName RevertString557
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/10/23  11:25 PM
 * @Version 1.0
 */

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 *
 * 241 翻转字符串  一并放到一起讲
 *
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 *
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 * 要求:
 *
 * 该字符串只包含小写的英文字母。
 * 给定字符串的长度和 k 在[1, 10000]范围内。
 *
 *
 */
public class RevertString557 {
    public String reverseWords(String s) {
        String[] list = s.split(" ");
        String result = new String();
        for(String temp:list){
            StringBuffer buffer = new StringBuffer(temp);
            result += buffer.reverse() + " ";
        }
        return result.trim();
    }

    public String reverseStr(String s, int k) {
        char[] resource = s.toCharArray();
        for(int i=0 ;i < resource.length ;i = i+2*k){
            reverchar(resource,i,(i+k-1 < resource.length) ? (i+k-1) : resource.length - 1);
        }
        return new String(resource);
    }

    public void reverchar(char[] resource,int start,int end){
        while(start < end){
            char temp = resource[start];
            resource[start] = resource[end];
            resource[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args){
        String name = "helloworldxinkin";
        RevertString557 test = new RevertString557();
        String a = test.reverseStr(name,3);
        int t = 0;
    }
}

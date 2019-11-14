package LeetCodeTop100;

/**
 * @ClassName MarsWords269
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/11/12  10:50 PM
 * @Version 1.0
 */

/**
 * 现有一种使用字母的全新语言，这门语言的字母顺序与英语顺序不同。
 *
 * 假设，您并不知道其中字母之间的先后顺序。但是，会收到词典中获得一个 不为空的 单词列表。因为是从词典中获得的，所以该单词列表内的单词已经 按这门新语言的字母顺序进行了排序。
 *
 * 您需要根据这个输入的列表，还原出此语言中已知的字母顺序。
 *
 * 示例 1：
 *
 * 输入:
 * [
 *   "wrt",
 *   "wrf",
 *   "er",
 *   "ett",
 *   "rftt"
 * ]
 *
 * 输出: "wertf"
 * 示例 2：
 *
 * 输入:
 * [
 *   "z",
 *   "x"
 * ]
 *
 * 输出: "zx"
 * 示例 3：
 *
 * 输入:
 * [
 *   "z",
 *   "x",
 *   "z"
 * ]
 *
 * 输出: "" 
 *
 * 解释: 此顺序是非法的，因此返回 ""。
 * 注意：
 *
 * 你可以默认输入的全部都是小写字母
 * 假如，a 的字母排列顺序优先于 b，那么在给定的词典当中 a 定先出现在 b 前面
 * 若给定的顺序是不合法的，则返回空字符串即可
 * 若存在多种可能的合法字母顺序，请返回其中任意一种顺序即可
 *
 *
 * 解析：从上到下，每两个字符串第一个不想的字符 建立有向边。最后拓扑排序。
 */
public class MarsWords269 {
    public String alienOrder(String[] words) {
        int[] degree = new int[28];
        int[][] map = new int[28][28];
        for(int i=0;i<degree.length;i++){
            degree[i] = -1;
        }
        for(String temp:words){
            char[] chars = temp.toCharArray();
            for(int i=0;i<chars.length;i++){
                degree[chars[i]-'a'] = 0;
            }
        }
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                int index = this.findDiff(words[i],words[j]);
                if(index != -1){
                    if(map[words[j].charAt(index) - 'a'][words[i].charAt(index) - 'a']!=0){
                        return null;
                    }
                    map[words[i].charAt(index) - 'a'][words[j].charAt(index) - 'a']++;
                    degree[words[j].charAt(index) - 'a']++;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while(true){
            boolean flag = false;
            for(int i=0;i<26;i++){
                if(degree[i] == 0){
                    flag = true;
                    ans.append((char)('a'+i));
                    System.out.println(ans.toString());
                    int j=0;
                    while(j<26){
                        if(map[i][j] != 0){
                            degree[j] -= map[i][j];
                        }
                        j++;
                    }
                    degree[i] = -1;
                }
            }
            if(!flag){
                break;
            }
        }
        return ans.toString();
    }

    private int findDiff(String a,String b){
        int lenA = a.length();
        int lenB = b.length();
        int i;
        i =0;
        while(i<Math.min(lenA,lenB)&&a.charAt(i) == b.charAt(i)){
            i++;
        }
        return i>=Math.min(lenA,lenB) ? -1:i;
    }

    public static void main(String[] args){
        MarsWords269 test = new MarsWords269();
        String[] words = {"x","y","x"};
        test.alienOrder(words);
    }
}

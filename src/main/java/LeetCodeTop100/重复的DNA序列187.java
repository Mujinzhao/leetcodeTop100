package LeetCodeTop100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName 重复的DNA序列187
 * @Author zhangxinkun
 * @Date 2020/1/12  9:57 PM
 * @Version 1.0
 */

/**
 * 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。
 *
 *  
 *
 * 示例：
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC", "CCCCCAAAAA"]
 *
 */
public class 重复的DNA序列187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> setAns = new HashSet();
        Set<String> ansSet = new HashSet();
        List<String> ans = new ArrayList();
        if(s.length() < 10){
            return ans;
        }
        for(int i=0;i+9<s.length();i++){
            String temp = s.substring(i,i+10);
            if(setAns.contains(temp)){
                ansSet.add(temp);
            }else{
                setAns.add(temp);
            }
        }
        ans = ansSet.stream().collect(Collectors.toList());
        return ans;
    }
}

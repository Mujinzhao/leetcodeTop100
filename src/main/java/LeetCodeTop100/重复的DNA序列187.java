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

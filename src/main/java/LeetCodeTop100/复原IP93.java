package LeetCodeTop100;

/**
 * @ClassName 复原IP93
 * @Author zhangxinkun
 * @Date 2020/1/9  8:07 AM
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class 复原IP93 {
    List<String> ans = new ArrayList();
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        ans = new ArrayList();
        if(s.length() > 12){
            return ans;
        }
        help(s,1);
        return ans;
    }

    public void help(String s,int step){
        if(step >= 4){
            if(check(s)){
                char[] chars = s.toCharArray();
                for(int i=0;i<s.length();i++){
                    if(s.charAt(i) == ','){
                        chars[i] = '.';
                    }
                }
                String tempAns = String.valueOf(chars);
                if(!ans.contains(tempAns)){
                    ans.add(tempAns);
                }
            }
            return ;
        }
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1) != ',' && s.charAt(i)!=','){
                String temp = s.substring(0,i)+','+s.substring(i,s.length());
                if(check(s.substring(0,i))){
                    help(temp,step+1);
                }
            }
        }
    }

    public boolean check(String s){
        String[] ips = s.split(",");
        for(int i=0;i<ips.length;i++){
            if(Long.valueOf(ips[i]) <0 || Long.valueOf(ips[i]) > 255 || (ips[i].length() > 1 && ips[i].startsWith("0"))){
                return false;
            }
        }
        return true;
    }
}

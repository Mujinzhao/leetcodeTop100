package LeetCodeDynamicMethod;

/**
 * @ClassName 翻转游戏294
 * @Author zhangxinkun
 * @Date 2020/1/8  11:10 PM
 * @Version 1.0
 */

/**
 * 你和朋友玩一个叫做「翻转游戏」的游戏，游戏规则：给定一个只有 + 和 - 的字符串。你和朋友轮流将 连续 的两个 "++" 反转成 "--"。 当一方无法进行有效的翻转时便意味着游戏结束，则另一方获胜。
 *
 * 请你写出一个函数来判定起始玩家是否存在必胜的方案。
 *
 * 示例：
 *
 * 输入: s = "++++"
 * 输出: true
 * 解析: 起始玩家可将中间的 "++" 翻转变为 "+--+" 从而得胜。
 * 延伸：
 * 请推导你算法的时间复杂度。
 *
 * 解析：翻转游戏，其实就可以看做是一个简单的暴利求解，暴利递归，和求排列组合那种性质一样的问题。
 */
public class 翻转游戏294 {
    public boolean canWin(String s) {
        char[] arr = s.toCharArray();
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i) == '+' && s.charAt(i+1) == '+'){
                arr[i] = '-';
                arr[i+1] = '-';
                if(!canWin(String.valueOf(arr))){
                    return true;
                }
                arr[i] = '+';
                arr[i+1] = '+';
            }
        }
        return false;
    }
}

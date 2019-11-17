package LeetCodeTop100;

import java.util.Stack;

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 *
 * 解析 ： 单调栈：  无论是单调递增栈 还是单调递减栈，都需要明白单调栈的本质是什么：
 * （对于单调递增栈，每一个能够入栈的元素，那么当前栈顶的元素一定是，这个即将入站的元素往前数，离他最近的小于它的元素，并且在找这个
 * 能够入栈的过程中，弹出来的元素，对这些弹出来的元素而言，当前即将入栈的元素，就他们右边第一个比他们大的元素。）
 *
 *
 *
 *
 * 单调栈的本质 可以多想想
 *
 *
 * 所以这一题，找某个数字后面第一个比他们大的元素，可以有两种解法：
 * 1、从左向右，维护一个单调递减的栈，每次入一个新元素的时候，对弹出来的元素进行更新。
 * 2、从右向左，维护一个单调递减的栈，每次入栈都能直接找到对应的答案。
 *
 * 对比 496
 */
public class Nexttemperature739 {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length-1;
        Stack<Integer> stack = new Stack();
        int[] ans = new int[len+1];
        ans[len] = 0;
        stack.push(len);
        for(int i=len-1 ; i>=0;i--){
            while(!stack.empty() && T[stack.peek()] <= T[i]){
                stack.pop();
            }
            if(stack.empty()){
                ans[i] = 0;
            }else{
                ans[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return ans;
    }


    public int[] dailyTemperatures1(int[] T) {
        Stack<Integer> stack = new Stack();
        int[] ans = new int[T.length];
        int len = T.length;
        if(len == 0){
            return ans;
        }
        if(len == 1){
            ans[0] = 0;
            return ans;
        }
        stack.push(0);
        for(int i=1;i<len;i++){
            while(!stack.empty() && T[stack.peek()] < T[i]){
                int temp = stack.peek();
                ans[temp] = i - temp;
                stack.pop();
            }
            stack.push(i);
        }
        if(!stack.empty()){
            ans[stack.peek()] = 0;
            stack.pop();
        }
        return ans;
    }
}

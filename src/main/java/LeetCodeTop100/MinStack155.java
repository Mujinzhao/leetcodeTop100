package LeetCodeTop100;

/**
 * @ClassName MinStack155
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/10/15  3:07 PM
 * @Version 1.0
 */
//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
//
//
// push(x) -- 将元素 x 推入栈中。
// pop() -- 删除栈顶的元素。
// top() -- 获取栈顶元素。
// getMin() -- 检索栈中的最小元素。
//
//
// 示例:
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
//
// Related Topics 栈 设计

/**
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 */

import java.util.Stack;

/**
 * 最小栈的设计
 */
public class MinStack155 {
    public Stack<Integer> stackNum;

    public Stack<Integer> stackMin;

//    int Min = Integer.MAX_VALUE;
    /**
     * 这一题不能用一个全局的最小值去保存当前的最小值，因为会pop更改当前栈中的最小值
     */

    /** initialize your data structure here. */
    public MinStack155() {
        stackNum = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int x) {
        if(stackMin.empty() || stackMin.peek() >= x){
            stackMin.push(x);
        }else {
            stackMin.push(stackMin.peek());
        }
        stackNum.push(x);
    }

    public void pop() {
        stackNum.pop();
        stackMin.pop();
    }

    public int top() {
        int temp = stackNum.peek();
        return temp;
    }

    public int getMin() {
        return stackMin.peek();
    }

    public static void main(String[] args){
        MinStack155 minStack155 = new MinStack155();
        minStack155.push(-2);
        minStack155.push(0);
        minStack155.push(-3);
        minStack155.push(8);
        minStack155.push(-5);
        minStack155.push(-1);
    }
}

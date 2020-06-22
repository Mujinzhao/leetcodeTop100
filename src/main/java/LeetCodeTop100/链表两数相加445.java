package LeetCodeTop100;

/**
 * @ClassName 链表两数相加445
 * @Author zhangxinkun
 * @Date 2020/4/14  8:40 AM
 * @Version 1.0
 */

import LeetCodeBaseDate.ListNode;

import java.util.Stack;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *  
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 */
public class 链表两数相加445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode ans = new ListNode(-1);
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        while(l1!=null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        Stack<Integer> puls = new Stack();
        int bit = 0;
        while(!stack1.empty() && !stack2.empty()){
            // System.out.println("a="+stack1.peek()+"b="+stack2.peek());
            int nextVal = (stack1.peek()+stack2.peek()+bit)%10;
            puls.push(nextVal);
            bit = (stack1.peek()+stack2.peek()+bit)/10;
            stack1.pop();
            stack2.pop();
        }
        while(!stack1.empty()){
            int nextVal = (stack1.peek()+bit)%10;
            puls.push(nextVal);
            bit = (stack1.peek()+bit)/10;
            stack1.pop();
        }
        while(!stack2.empty()){
            int nextVal = (stack2.peek()+bit)%10;
            puls.push(nextVal);
            bit = (stack2.peek()+bit)/10;
            stack2.pop();
        }
        // System.out.println("bit="+bit);
        if(bit != 0){
            puls.push(bit);
        }
        ListNode cur = ans;
        while(!puls.empty()){
            ListNode now = new ListNode(puls.peek());
            cur.next = now;
            cur = cur.next;
            puls.pop();
        }
        return ans.next;
    }
}

package LeetCodeBaseDate;

import lombok.Data;

/**
 * @ClassName ListNode
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/8/7  11:19 AM
 * @Version 1.0
 */
@Data
public class ListNode {
    private int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
}

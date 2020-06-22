package LeetCodeTop100;

import LeetCodeBaseDate.Node;

/**
 * 给定循环升序列表中的一个点，写一个函数向这个列表中插入一个新元素，使这个列表仍然是循环升序的。给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 *
 * 如果有多个满足条件的插入位置，你可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 *
 * 如果列表为空（给定的节点是 null），你需要创建一个循环有序列表并返回这个点。否则。请返回原先给定的节点。
 *
 * 下面的例子可以帮你更好的理解这个问题：
 *
 * [1,3,5]
 * 1
 * 输出
 *
 * [1,1,3,5]
 *
 * 解析：找到最小节点，有序插入即可
 */
public class 循环链表有序插入708 {
    public Node insert(Node head, int insertVal) {
        Node ins = new Node();
        ins.val = insertVal;
        //头节点是空，构造单节点循环链表返回
        if(null == head) {
            ins.next = ins;
            return ins;
        }
        //记录最大值节点
        Node max = head;
        Node temp = head;
        while(temp.next != head) {
            Node next = temp.next;
            //寻找符合升序条件的节点
            if(temp.val <= insertVal && insertVal <= next.val) {
                temp.next = ins;
                ins.next = next;
                return head;
            }

            temp = next;
            if(temp.val >= max.val) {
                max = temp;
            }
        }
        if(temp.val <= insertVal && insertVal <= temp.next.val) {
            Node next = temp.next;
            temp.next = ins;
            ins.next = next;
            return head;
        }

        //没有满足升序的节点，将insertVal插入到最大值节点后面
        Node next = max.next;
        max.next = ins;
        ins.next = next;
        return head;
    }
}

package LeetCodeTop100;

import LeetCodeBaseDate.ListNode;

import java.util.Random;

/**
 * @ClassName ReservoirSampling382
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/8/7  3:50 PM
 * @Version 1.0
 *
 *
 *
 * 蓄水池采样问题，这个问题比较简单，只有一个数字。注意：替换数据的依据是 k/i++ 这里的i 是变化的。
 *
 *
 *
 */
public class ReservoirSampling382 {
    private Random random;
    private ListNode HEAD;

    public int getRandom() {
        int temp = HEAD.val;
        ListNode cur = HEAD.next;
        int i = 2;

        while(cur != null){
            int rand = random.nextInt(i++);
            if(rand == 0){
                temp = cur.val;
            }
            cur = cur.next;
        }
        return temp;
    }

    public ReservoirSampling382(ListNode head) {
        HEAD = head;
        random = new Random();
    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;

        ReservoirSampling382 instance = new ReservoirSampling382(listNode1);


        for (int i = 0; i < 50; i++) {
            System.out.println(instance.getRandom());
        }
    }
}

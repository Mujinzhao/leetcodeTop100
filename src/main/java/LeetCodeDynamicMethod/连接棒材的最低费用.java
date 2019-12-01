package LeetCodeDynamicMethod;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 为了装修新房，你需要加工一些长度为正整数的棒材 sticks。
 *
 * 如果要将长度分别为 X 和 Y 的两根棒材连接在一起，你需要支付 X + Y 的费用。 由于施工需要，你必须将所有棒材连接成一根。
 *
 * 返回你把所有棒材 sticks 连成一根所需要的最低费用。注意你可以任意选择棒材连接的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：sticks = [2,4,3]
 * 输出：14
 * 解释：先将 2 和 3 连接成 5，花费 5；再将 5 和 4 连接成 9；总花费为 14。
 * 示例 2：
 *
 * 输入：sticks = [1,8,3,5]
 * 输出：30
 *  
 *
 * 提示：
 *
 * 1 <= sticks.length <= 10^4
 * 1 <= sticks[i] <= 10^4
 *
 * 解析：贪心算法，优先队列保持最小的 两个棒材进行相加，然后再放回队列中，
 * 再取出两根，直到队列为空。
 */
public class 连接棒材的最低费用 {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int len = sticks.length;
        if(len == 1 || len == 2){
            return len == 1?0:(sticks[0]+sticks[1]);
        }
        for(int i=0;i<len;i++){
            queue.offer(sticks[i]);
        }
        int ans = 0;
        while(!queue.isEmpty()){
            Integer first = queue.poll();
            if(queue.isEmpty()){
                return ans;
            }
            Integer second = queue.poll();
            int sum = (first.intValue() + second.intValue());
            queue.offer(sum);
            ans += sum;
        }
        return ans;
    }
}

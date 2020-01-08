package LeetCodeTop100;

/**
 * @ClassName 超级洗衣机517
 * @Author zhangxinkun
 * @Date 2020/1/6  11:24 PM
 * @Version 1.0
 */

/**
 * 假设有 n 台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。
 *
 * 在每一步操作中，你可以选择任意 m （1 ≤ m ≤ n） 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。
 *
 * 给定一个非负整数数组代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的最少的操作步数。如果不能使每台洗衣机中衣物的数量相等，则返回 -1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: [1,0,5]
 *
 * 输出: 3
 *
 * 解释:
 * 第一步:    1     0 <-- 5    =>    1     1     4
 * 第二步:    1 <-- 1 <-- 4    =>    2     1     3
 * 第三步:    2     1 <-- 3    =>    2     2     2
 * 示例 2：
 *
 * 输入: [0,3,0]
 *
 * 输出: 2
 *
 * 解释:
 * 第一步:    0 <-- 3     0    =>    1     2     0
 * 第二步:    1     2 --> 0    =>    1     1     1
 * 示例 3:
 *
 * 输入: [0,2,0]
 *
 * 输出: -1
 *
 * 解释:
 * 不可能让所有三个洗衣机同时剩下相同数量的衣物。
 *
 * 解析：由于每次操作每台洗衣机只能选择向左或者向右运送一件衣服，且多个洗衣机可以并行同时运送，故必定存在一个洗衣机，它运送的衣服数量等于答案。
 *
 * 我们可以枚举每一台洗衣机，计算经过它运送的衣服的数量。
 *
 * 首先如果衣服的总数量是洗衣机的整数倍，则必定存在一个解；否则返回 -1。
 *
 * 然后逐一枚举洗衣机，假设当前枚举的洗衣机编号为 i，则统计 left_sum = [0, i - 1] 中衣服的总数量和 right_sum = [i + 1, n - 1] 中衣服的总数量，若发现 left_sum < i * avg，即 i 左边的衣服数量少，故需要经过这台洗衣机从右向左运送的衣服数量为 r_2_l = i * avg - left_sum。从左向右运行的衣服数量 l_2_r 同理。
 *
 * r_2_l + l_2_r 求和就是这台洗衣机的工作量，对每一台洗衣机都这样求和得到工作量，取工作量最大的洗衣机
 */
public class 超级洗衣机517 {
    public int findMinMoves(int[] machines) {
        int len = machines.length;
        int sum = 0;
        int ans = 0;
        for(int i=0;i<len;i++){
            sum += machines[i];
        }
        if(sum % len != 0){
            return -1;
        }
        int left_sum = 0;
        int right_sum = sum;
        int avg = sum/len;
        for (int i = 0; i < len; i++) {
            right_sum -= machines[i];
            int r_2_l = Math.max(i * avg - left_sum, 0);
            int l_2_r = Math.max((len - i - 1) * avg - right_sum, 0);
            ans = Math.max(ans, l_2_r + r_2_l);
            left_sum += machines[i];

        }
        return ans;
    }
}

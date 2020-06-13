package LeetCodeTop100;

/**
 * @ClassName 会议室252
 * @Author zhangxinkun
 * @Date 2020/1/30  10:00 PM
 * @Version 1.0
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 *
 * 示例 1:
 *
 * 输入: [[0, 30],[5, 10],[15, 20]]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [[7,10],[2,4]]
 * 输出: 1
 *
 * 解析：先对会议进行排序；使用优先队列进行求解，每次都将结束时间放大优先队列中，然后判断会议开始时间是不是比队头的结束时间大，如果大的话，说明队头的会议室
 * 可以空出来一个，如果比队头的小，说明产生了重叠，答案加一。
 * 代码还是比较简洁的。
 */
public class 会议室252 {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a,Integer b){
                return a - b;
            }
        });
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[0] - b[0];
            }
        });
        int ans = 0;
        for(int i=0;i<intervals.length;i++){
            queue.offer(intervals[i][1]);
            if(intervals[i][0] < queue.peek()){
                ans++;
            }else{
                queue.poll();
            }
        }
        return ans;
    }
}

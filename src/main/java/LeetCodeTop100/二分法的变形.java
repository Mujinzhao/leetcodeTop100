package LeetCodeTop100;

/**
 * @ClassName 二分法的变形
 * @Author zhangxinkun
 * @Date 2020/1/31  8:58 PM
 * @Version 1.0
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 二分法查找第一次出现的位子 和 最后一次出现的位子
 *
 *
 * 二分法的变形可以这么去记忆：while(left <= right)这个是一定的，if 。。。else里面怎么写，也很容易想，最不好理解的就是返回left还是right，
 * 以及返回的left right是不是有效的解。
 *
 * 返回什么：可以这样记忆，当返回的值是在当前比较元素的右边的时候，反而返回left，当返回值在当前比较元素的左边的时候，反而返回right。
 * 那么至于是不是有效解，直接去比较返回的值在不在数组的范围内即可。
 *
 * 其实这个记忆更方便：比如数组1，2，3，5，5，5，7，8，9
 * 对于5这个数字，它前面的那个数字3，返回right，后面的那个数字7 返回left
 * 第一个5，返回left，最后一个5 返回right  ！！！
 *
 * https://blog.csdn.net/bat67/article/details/72049104
 */
public class 二分法的变形 {
    //第一次出现的位置
    int getLower(int[] data, int k){
        int start = 0, end = data.length - 1;
        int mid = (start + end) / 2;
        while (start <= end){
            if (data[mid] < k){
                start = mid + 1;
            }
            else{  // data[mid] >= k
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return start;
    }
    // 最后一次出现的位置
    int getUpper(int[] data, int k){
        int start = 0, end = data.length - 1;
        int mid = (start + end) / 2;
        while (start <= end){
            if (data[mid] <= k){ // data[mid] == k
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return end;
    }

    public static void main(String[] args){
        int[] nums = {2,4,8,8,8,8,8,12,12,14,15,17,18,27,27,109};
        二分法的变形 test = new 二分法的变形();
        int low = test.getLower(nums,8);
//        low = test.getLower2(nums,8);
//        low = test.getLower(nums,12);
//        low = test.getLower2(nums,12);
//        low = test.getLower(nums,16);
        int a = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(5, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });
    }
}

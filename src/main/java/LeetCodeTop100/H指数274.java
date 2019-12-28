package LeetCodeTop100;

/**
 * @ClassName H指数274
 * @Author zhangxinkun
 * @Date 2019/12/24  12:08 AM
 * @Version 1.0
 */

/**
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
 *
 * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）至多有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）”
 *
 *  
 *
 * 示例:
 *
 * 输入: citations = [3,0,6,1,5]
 * 输出: 3
 * 解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 *      由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。
 *  
 *
 * 说明: 如果 h 有多种可能的值，h 指数是其中最大的那个。
 *
 * 从大到小排序即可
 */
public class H指数274 {
    public int hIndex(int[] citations) {
        quickSort(citations,0,citations.length-1);
        int i=0;
        for(i=0;i<citations.length;i++){
            if(citations[i] < (i+1)){
                break;
            }
        }
        return i;
    }

    public void quickSort(int[] nums,int start,int end){
        if(start < end){
            int p = partition(nums,start,end);
            quickSort(nums,start,p-1);
            quickSort(nums,p+1,end);
        }
    }

    public int partition(int[] nums,int start,int end){
        int x = nums[end];
        int i = start;
        for(int j=start;j<end;j++){
            if(nums[j] > x){
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i,end);
        return i;
    }

    public void swap(int[] nums,int x,int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}

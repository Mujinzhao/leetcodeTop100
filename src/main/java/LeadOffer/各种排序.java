package LeadOffer;

import com.alibaba.fastjson.JSON;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName 各种排序
 * @Author zhangxinkun
 * @Date 2020/3/24  9:37 PM
 * @Version 1.0
 */
public class 各种排序 {

    public static void main(String[] args){
        int[] number = {4,3,6,1,54,234,543,412,23,2,3,1,5,3,6,5,3};
//        mergeSort(number,0,number.length-1);
//        System.out.println(JSON.toJSONString(number));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.intValue() - o2.intValue();
            }
        });
        for(int i=0;i<number.length;i++){
            priorityQueue.offer(number[i]);
        }
        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.peek());
            priorityQueue.poll();
        }
    }

    /**
     * 快排
     */
    public static void quickSort(int[] number,int left,int right){
        if(left < right){
            int p = partition(number,left,right);
            quickSort(number,left,p-1);
            quickSort(number,p+1,right);
        }
    }

    public static int partition(int[] number,int left,int right){
        int x = number[right];
        int j = left;
        for(int i=left;i<right;i++){
            if(x > number[i]){
                swap(number,i,j);
                j++;
            }
        }
        swap(number,j,right);
        return j;
    }

    public static void swap(int[] number,int x,int y){
        int temp = number[x];
        number[x] = number[y];
        number[y] = temp;
    }

    /**
     * 归并排序
     */
    public static void mergeSort(int[] number,int left,int right){
        if(left < right){
            int mid = (left + right) >> 1;
            mergeSort(number,left,mid);
            mergeSort(number,mid+1,right);
            merge(number,left,mid,right);
        }
    }

    public static void merge(int[] number,int left,int mid,int right){
        int[] temp = new int[right - left + 1];
        int start1 = left;
        int start2 = mid+1;
        int count = 0;
        while(start1 <= mid && start2 <=right){
            if(number[start1] > number[start2]){
                temp[count++] = number[start2++];
            }else{
                temp[count++] = number[start1++];
            }
        }
        while(start1 <= mid){
            temp[count++] = number[start1++];
        }
        while(start2 <= right){
            temp[count++] = number[start2++];
        }
        int start = left;
        for(int i=left;i<=right;i++){
            number[i] = temp[i-left];
        }
    }
}

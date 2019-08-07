package LeetCodeTop100;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MaxNum169
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/7/31  11:49 PM
 * @Version 1.0
 */
public class MaxNum169 {
    public int majorityElement(int[] nums) {
//        Map<Integer,Integer> result = new HashMap<>();
//        for (int temp:nums
//             ) {
//            if(result.containsKey(temp)){
//                result.put(temp,result.get(temp)+1);
//            }else{
//                result.put(temp,1);
//            }
//        }
//        Integer max = -1;
//        Integer indexNum = 0;
//        for (Map.Entry<Integer,Integer> e:result.entrySet()
//             ) {
//            if(e.getValue() > max){
//                max = e.getValue();
//                indexNum = e.getKey();
//            }
//        }
//        return indexNum.intValue();
        QuickSort(nums,0,nums.length-1);
        return nums[nums.length / 2];
    }

    public void QuickSort(int[] nums,int start,int end){
        if(start < end){
            int p = partition(nums,start,end);
            QuickSort(nums,start,p-1);
            QuickSort(nums,p+1,end);
        }
    }

    public int partition(int[] nums,int start,int end){
        int i = start;
        int x = nums[end];

        for(int j=i ; j<end ;j++){
            if (nums[j] < x) {
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

    public static void main(String[] args){
        MaxNum169 instance = new MaxNum169();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(instance.majorityElement(nums));
    }
}

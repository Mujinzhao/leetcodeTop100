package Unitls;

/**
 * @ClassName SortTool
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/7/22  5:47 PM
 * @Version 1.0
 */
public class SortTool {
    public static void quickSort(int[] nums){
        quickRealSort(nums,0,nums.length-1);
    }

    public static void mergeSort(int[] nums){
        realMergeSort(nums,0,nums.length-1);
    }

    public static void quickRealSort(int[] nums,int start,int end){
         if(start <= end){
             int p = partition(nums,start,end);
             quickRealSort(nums,start,p-1);
             quickRealSort(nums,p+1,end);
         }
    }

    public static int partition(int[] nums,int start,int end){
        int x = nums[end];
        int i = start;
        for (int j=start ; j < end ; j++){
            if(nums[j] < x){
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i,end);
        return i;
    }

    public static void swap(int[] nums,int x,int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void realMergeSort(int[] nums,int start,int end){
        if(start < end){
            int mid = (start + end) >> 1;
            realMergeSort(nums,start,mid);
            realMergeSort(nums,mid+1,end);
            merge(nums,start,mid,end);
        }
    }

    public static void merge(int[] nums,int start,int mid,int end){
        int lengthLeft = mid - start + 1;
        int[] left = new int[lengthLeft];
        int lengthRight = end - mid;
        int[] right = new int[lengthRight];
        int[] sortedNum = new int[end - start + 1];
        int i=0,   j=0,  sorted = 0;
        while(i<lengthLeft) {
            left[i] = nums[start + i];
            i++;
        }
        while(j<lengthRight) {
            right[j] = nums[mid + j + 1];
            j++;
        }
        i=0;
        j=0;
        while(i<lengthLeft && j<lengthRight){
            if(left[i] > right[j]){
                sortedNum[sorted++] = right[j++];
            } else if (left[i] <= right[j]){
                sortedNum[sorted++] = left[i++];
            }
        }
        while (i < lengthLeft) {
            sortedNum[sorted++] = left[i++];
        }
        while (j < lengthRight) {
            sortedNum[sorted++] = right[j++];
        }
        i=0;
        for(int k=start ; k <= end ;k++){
            nums[k] = sortedNum[i++];
        }
    }
}

package LeetCodeTop100;

/**
 * @ClassName 结果不超过阈值的最小除数
 * @Author zhangxinkun
 * @Date 2019/12/9  5:17 PM
 * @Version 1.0
 */
public class 结果不超过阈值的最小除数 {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = -1;
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        for(int i=0;i<len;i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }

        int left = 1;
        int right = max;

        while(left < right){
            int mid = (left+right) >> 1;
            int tempSum = this.calculate(nums,mid);
            if(tempSum > threshold){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public int calculate(int[] nums,int mid){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            int temp = (int)Math.ceil((double)nums[i] / mid);
            sum += temp;
        }
        return sum;
    }

    public static void main(String[] args){
        结果不超过阈值的最小除数 test = new 结果不超过阈值的最小除数();
        int[] nums = {2,3,5,7,11};
        int threshold = 11;
        test.smallestDivisor(nums,threshold);
    }
}

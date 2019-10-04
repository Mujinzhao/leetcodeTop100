package LeetCodeTop100;

/**
 * @ClassName MoveZores
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/8/1  12:40 AM
 * @Version 1.0
 */
public class MoveZores283 {
    public void moveZeroes(int[] nums) {
        int numberOfZore = 0;
        for (int one:nums
             ) {
            if(one == 0){
                numberOfZore++;
            }
        }
        int j = 0;
        for(int i=0;i<nums.length ; i++){
            if(nums[i] != 0){
                swap(nums,i,j);
                j++;
            }
        }
        for( ; j<nums.length; j++){
            nums[j] = 0;
        }
    }

    public void swap(int[] nums,int x,int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args){
        MoveZores283 instance = new MoveZores283();
        int[] nums = {4,0,0,1,2};
        instance.moveZeroes(nums);
        for (int one:nums
             ) {
            System.out.println(one);
        }
        System.out.println(System.currentTimeMillis());
    }
}

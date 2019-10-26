package LeetCodeTop100;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 *
 * 或者用所谓的三路归并，遇到0往左边放，遇到2往右边放就行
 *
 */
public class ColorSort75 {

    public void sortColors(int[] nums) {
        int oneNum = 0;
        int twoNum = 0;
        int sum = 0;
        int i;
        for(i=0;i< nums.length ;i++){
            sum += nums[i];
            if(nums[i] == 2){
                twoNum += nums[i] ;
            }
        }
        oneNum = sum - twoNum;
        for(i=0 ;i<nums.length - oneNum - twoNum/2;i++){
            nums[i] = 0;
        }
        for(;i<nums.length - twoNum/2;i++){
            nums[i] = 1;
        }
        for( ; i<nums.length ; i++){
            nums[i] = 2;
        }
    }

    public void sortColors2(int[] nums) {
        int left,right;
        left = 0;
        right = nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                swap(nums,i,left++);
            }else if(nums[i] == 2){
                swap(nums,i,right--);
                i--;
            }
        }
        int a = 0;
    }

    public void swap(int[] nums,int x,int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args){
        int[] nums = {1,1,2,2,0,0};
        ColorSort75 test = new ColorSort75();
        test.sortColors2(nums);
    }
}

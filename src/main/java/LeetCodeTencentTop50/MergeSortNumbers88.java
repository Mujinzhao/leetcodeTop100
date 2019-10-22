package LeetCodeTencentTop50;

/**
 * @ClassName MergeSortNumbers88
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/10/22  11:13 PM
 * @Version 1.0
 */

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 */
public class MergeSortNumbers88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int insert = nums1.length - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j>= 0){
            if(nums1[i] >= nums2[j]){
                nums1[insert--] = nums1[i];
                i--;
            }else{
                nums1[insert--] = nums2[j];
                j--;
            }
        }
        while(i >= 0){
            nums1[insert--] = nums1[i];
            i--;
        }
        while(j >= 0){
            nums1[insert--] = nums2[j];
            j--;
        }
        int a = 0;
    }

    public static void main(String[] args){
        MergeSortNumbers88 test = new MergeSortNumbers88();
        int[] num1 = {1,3,5,7,9,0,0,0,0,0};
        int[] num2 = {2,4,6,8,10};
        test.merge(num1,5,num2,num2.length);
    }
}

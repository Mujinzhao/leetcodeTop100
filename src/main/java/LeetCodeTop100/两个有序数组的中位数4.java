package LeetCodeTop100;

/**
 * @ClassName 两个有序数组的中位数4
 * @Author zhangxinkun
 * @Date 2019/12/31  12:44 PM
 * @Version 1.0
 */

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 解析：理解一点，中位数不管怎么取，这个中位数，肯定能把两个数组分别分成 前后两个部分，我们的任务就是找怎么分把这两个数组分别分成两个部分，并且
 * 满足两个数组的前半部分相加 = (n+m)/2 （中位数的要求），并且前半部分的最大值，小于后半部分的最小值。即可
 */
public class 两个有序数组的中位数4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 > len2){
            return findMedianSortedArrays(nums2,nums1);
        }
        int l1=0,r1=0,l2=0,r2=0;
        int c1,c2;
        int left;
        int right;
        left = 0;
        right = 2*len1;
        while(left <= right){
            c1 = (left + right)>>1;
            c2 = len1+len2-c1;
            l1 = c1==0?Integer.MIN_VALUE:nums1[(c1-1)/2];
            r1 = c1==2*len1?Integer.MAX_VALUE:nums1[c1/2];
            l2 = c2==0?Integer.MIN_VALUE:nums2[(c2-1)/2];
            r2 = c2==2*len2?Integer.MAX_VALUE:nums2[c2/2];

            if(l1 > r2){
                right = c1-1;
            }else if(l2 > r1){
                left = c1+1;
            }else{
                break;
            }
        }
        return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
    }
}

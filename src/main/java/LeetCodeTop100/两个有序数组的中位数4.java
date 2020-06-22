package LeetCodeTop100;

/**
 *
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
    public static void main(String[] args){
        int[] nums1 = {2};
        int[] nums2 = {1,3};
        两个有序数组的中位数4 test = new 两个有序数组的中位数4();
        test.findMedianSortedArrays(nums1,nums2);
    }
}

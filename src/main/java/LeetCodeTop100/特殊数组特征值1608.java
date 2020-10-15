/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package LeetCodeTop100;

import java.util.Arrays;

/**
 * @author zhangxinkun
 * @version : 特殊数组特征值1608.java, v 0.1 2020年10月15日 11:44 zhangxinkun Exp $
 */
public class 特殊数组特征值1608 {
    public int specialArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int ans = 1;
        int length = nums.length;
        Arrays.sort(nums);
        if (nums[0] >= length) {
            return length;
        }
        for (int j = length - 1; j >= 0; j--) {
            if (nums[j] < ans) {
                return -1;
            }
            if (j - 1 >= 0 && nums[j - 1] < ans) {
                return ans;
            }
            ans++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] number = {5, 5, 5, 5, 5};
        特殊数组特征值1608 test = new 特殊数组特征值1608();
        System.out.println(test.specialArray(number));
    }
}
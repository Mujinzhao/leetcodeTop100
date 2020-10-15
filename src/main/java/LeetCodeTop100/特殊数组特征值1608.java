/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package LeetCodeTop100;

import java.util.Arrays;

/**
 * @author zhangxinkun
 * @version : 特殊数组特征值1608.java, v 0.1 2020年10月15日 11:44 zhangxinkun Exp $
 *
 *
 *
 * 给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。
 *
 * 注意： x 不必 是 nums 的中的元素。
 *
 * 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的 。
 *
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
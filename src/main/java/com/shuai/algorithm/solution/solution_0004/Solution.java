package com.shuai.algorithm.solution.solution_0004;

public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 组装成新数组并排序
     *
     * 如果新数组长度为奇数， 则取中间元素
     * 如果新数组长度为偶数， 则取中间的两个元素的平均值
     * */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int newLength = nums1.length + nums2.length;
        int[] newNums = new int[newLength];

        int i = 0;
        int j = 0;
        int m = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && j >= nums2.length) {
                newNums[m] = nums1[i];
                m++;
                i++;
                continue;
            }
            if (i >= nums1.length && j < nums2.length) {
                newNums[m] = nums2[j];
                m++;
                j++;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                newNums[m] = nums1[i];
                i++;
            } else {
                newNums[m] = nums2[j];
                j++;
            }
            m++;
        }
        if (newLength % 2 == 1) {
            return newNums[newLength / 2];
        } else {
            return (newNums[newLength / 2] + newNums[newLength / 2 - 1]) / 2D;
        }
    }
}

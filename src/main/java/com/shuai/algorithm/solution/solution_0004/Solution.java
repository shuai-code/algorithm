package com.shuai.algorithm.solution.solution_0004;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1和nums2。请你找出并返回这两个正序数组的中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * */
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

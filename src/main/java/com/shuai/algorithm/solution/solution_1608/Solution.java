package com.shuai.algorithm.solution.solution_1608;

import java.util.Arrays;

/**
 * 给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。
 *
 * 注意： x 不必 是 nums 的中的元素。
 *
 * 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的 。
 *
 * 输入：nums = [3,5]
 * 输出：2
 * 解释：有 2 个元素（3 和 5）大于或等于 2 。
 *
 * 输入：nums = [0,0]
 * 输出：-1
 * 解释：没有满足题目要求的特殊数组，故而也不存在特征值 x 。
 * 如果 x = 0，应该有 0 个元素 >= x，但实际有 2 个。
 * 如果 x = 1，应该有 1 个元素 >= x，但实际有 0 个。
 * 如果 x = 2，应该有 2 个元素 >= x，但实际有 0 个。
 * x 不能取更大的值，因为 nums 中只有两个元素。
 *
 * 输入：nums = [0,4,3,0,4]
 * 输出：3
 * 解释：有 3 个元素大于或等于 3 。
 *
 * 输入：nums = [3,6,7,7,0]
 * 输出：-1
 * */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 5};
        System.out.println(specialArrayWithSort(nums));
    }

    /**
     * 根据题意直接模拟
     *
     * 已知结果最大为数组长度
     * 则从1开始一直到数组长度，依次去判断
     *
     * 数组中有x个大于x的数，多了或少了都不对
     * */
    public static int specialArray(int[] nums) {
        for (int i = 1; i <= nums.length; i++) {
            int count = 0;
            for (int num : nums) {
                if (num >= i) {
                    count++;
                }
            }
            // 有count个大于i的数, 同时count == i
            if (count == i) {
                return count;
            }
        }
        return -1;
    }

    /**
     * 升序排序
     *
     * 如果第一个数大于长度，则特殊数就是数组长度
     *
     * */
    public static int specialArrayWithSort(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] >= nums.length) {
            return nums.length;
        }
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res = nums.length - i;
            if (nums[i] >= res && nums[i - 1] < res) {
                return res;
            }
        }
        return -1;
    }
}

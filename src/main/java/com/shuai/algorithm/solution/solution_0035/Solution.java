package com.shuai.algorithm.solution.solution_0035;


/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;

        System.out.println(searchInsertWithTwo(nums, target));
    }

    /**
     * 遍历寻找, 先判断相等. 则找第一个比目标值大的元素返回
     *
     * 遍历结束都没有比目标值大的元素， 则插入位置未元素末尾
     * */
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target || nums[i] > target) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 二分查找
     * */
    public static int searchInsertWithTwo(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}

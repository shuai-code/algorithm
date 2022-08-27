package com.shuai.algorithm.solution.solution_0283;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 输入: nums = [0]
 * 输出: [0]
 * */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 双指针
     * 一次遍历, 碰到非0就进行交换
     * */
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int r = nums[i];
                nums[i] = nums[j];
                nums[j++] = r;
            }
        }
    }

    /**
     * 双指针。先将非0的都移动到最左边
     * 再次遍历，把其他位置设置为0
     * */
    public static void moveZeroesWithDouble(int[] nums) {
        int j = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
            i++;
        }
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }
}

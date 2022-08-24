package com.shuai.algorithm.solution.solution_0977;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {-5,-3,-2,-1};
        System.out.println(Arrays.toString(sortedSquaresWithDesc(nums)));
    }

    /**
     * 计算后排序
     * */
    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 原数组是有序的
     * 则如果是正数，那么平方后顺序不变
     * 如果是负数， 则平方后顺序相反
     * 1. 找到正负数的临界点
     * 2. 然后用双指针，分别向左和向右各取一个平方计算。
     * 3. 比较后放入新数组，同时移动较小的一个方向继续比较
     * */
    public static int[] sortedSquaresWithOne(int[] nums) {
        int[] res = new int[nums.length];
        int l = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            l = i;
        }
        int r = l + 1;
        int n = 0;
        while (l >= 0 || r < nums.length) {
            if (l == -1) {
                res[n] = nums[r] * nums[r];
                r++;
            } else if (r == nums.length) {
                res[n] = nums[l] * nums[l];
                l--;
            } else if (nums[l] * nums[l] < nums[r] * nums[r]) {
                res[n] = nums[l] * nums[l];
                l--;
            } else {
                res[n] = nums[r] * nums[r];
                r++;
            }
            n++;
        }
        return res;
    }

    /**
     * 数组两侧的值一定是最大的
     * 例如：
     *   1，  2， 3， 4， 5     5的平方是最大的
     * -10， -2， 3， 5， 8     -10和8的平方是最大的
     * -10， -9，-3            -10德平方是最大的
     *
     * 则每次取数组两侧的值， 平方比较。从大到小放入新数组
     * */
    public static int[] sortedSquaresWithDesc(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int index = nums.length - 1;
        while (i <= j) {
            if (nums[i] * nums[i] < nums[j] * nums[j]) {
                res[index] = nums[j] * nums[j];
                j--;
            } else {
                res[index] = nums[i] * nums[i];
                i++;
            }
            index--;
        }
        return res;
    }
}

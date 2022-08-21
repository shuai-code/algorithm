package com.shuai.algorithm.solution.solution_1480;

import java.util.Arrays;

/**
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。

 * 请返回 nums 的动态和。

 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。

 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 *
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 10, 1};
        System.out.println(Arrays.toString(runningSumWithOriginal(nums)));
    }

    /**
     * 每次记录上一个结果， 用于下一个循环累加使用
     */
    public static int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        int prevNum = 0;
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] + prevNum;
            prevNum = res[i];
        }
        return res;
    }


    /**
     * 和上一个方法思路一样， 在原数组上操作， 不申请新的数组
     */
    public static int[] runningSumWithOriginal(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }
}

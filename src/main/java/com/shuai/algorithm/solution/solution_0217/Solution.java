package com.shuai.algorithm.solution.solution_0217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicateWithSet(nums));
    }

    /**
     * 排序后两两比较
     */
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        // 只有一个元素的数组
        if (nums.length == 1) {
            return false;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 利用集合特性，放入成功表示没有此元素，放入失败表示集合已经存在此元素，直接返回true
     * */
    public static boolean containsDuplicateWithSet(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            if (!numsSet.add(num)) {
                return true;
            }
        }
        return false;
    }
}

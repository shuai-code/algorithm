package com.shuai.algorithm.solution.solution_0001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[]{0, 1};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int i1 = target - nums[i];
            if (map.containsKey(i1)) {
                return new int[]{i, map.get(i1)};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }
}

package com.shuai.algorithm.solution.solution_0219;

import java.util.*;

/**
 * 给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个 不同的索引i和j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 *
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 *
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 *
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 * */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
        System.out.println(containsNearbyDuplicateWithWindow(nums, 2));
    }

    /**
     * 使用Hash表, 记录每个元素的索引。出现已存在的元素时计算索引之间的差。满足则返回true
     * */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    /**
     * 滑动窗口
     * 以窗口形式向前移动, 移除窗口最左的, 然后判断最后添加的是否已存在
     * */
    public static boolean containsNearbyDuplicateWithWindow(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果到达边界则移除集合对应数组最左元素
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}

package com.shuai.algorithm.solution.solution_0169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组nums.返回其中的多数元素。多数元素是指在数组中出现次数大于n/2的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {6, 6, 6, 7, 7};
        System.out.println(majorityElementWithMoore(nums));
    }

    /**
     * 使用Map统计每个元素的出现次数, 再找次数超过半数的元素
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * 排序后, 依次判断相同一段元素的个数, 超过半数就返回, 否则初始化次数继续累计
     */
    public static int majorityElementWithSort(int[] nums) {
        Arrays.sort(nums);

        int count = 1;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count > nums.length / 2) {
                return nums[i];
            }
            i++;
        }
        return 0;
    }

    /**
     * 排序
     * 滑动窗口, 因为相同元素超过半数, 则窗口的左右也应该是相同的
     */
    public static int majorityElementWithWindow(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length / 2 + 1;

        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                return nums[i];
            } else {
                i++;
                j++;
            }
        }
        return 0;
    }

    /**
     * 考虑如果将数组平均分成两个, 则目标元素一定出现在两个数组中
     */
    public static int majorityElementWithTwo(int[] nums) {
        return 0;
    }

    /**
     * 摩尔投票法
     * 如果次数为0, 则选取当前元素, 准备投票
     * 如果碰到相同的元素就投一票
     * 如果碰到不同的就减一票
     * 如果票数为0就换一个元素
     *
     * 因为需要找到的元素, 一定会得到半数以上的票
     * */
    public static int majorityElementWithMoore(int[] nums) {
        int count = 0;
        int result = -1;
        for (int num : nums) {
            if (count == 0) {
                result = num;
            }
            if (num == result) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
}

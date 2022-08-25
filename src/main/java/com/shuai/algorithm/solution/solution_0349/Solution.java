package com.shuai.algorithm.solution.solution_0349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个数组nums1和nums2 ，返回 它们的交集。输出结果中的每个元素一定是 唯一 的。我们可以不考虑输出结果的顺序
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 * */
public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    /**
     * 使用集合, 因为题目每个元素是唯一的. 所以不用考虑重复问题
     * */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        int[] r = new int[nums1.length];
        int n = 0;
        for (int i : nums2) {
            if (set.contains(i)) {
                r[n++] = i;
                set.remove(i);
            }
        }
        return Arrays.copyOf(r, n);
    }

    /**
     * 排序后双指针, 注意相同元素只取一次, 可以用集合, 也可以在取值时和前一个值比较
     * */
    public static int[] intersectionWithSort(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        int n = 0;
        int[] r = new int[nums1.length];
        Set<Integer> set = new HashSet<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (!set.contains(nums1[i])) {
                    r[n++] = nums1[i];
                }
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOf(r, n);
    }
}

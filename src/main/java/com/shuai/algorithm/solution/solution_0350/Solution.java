package com.shuai.algorithm.solution.solution_0350;


import java.util.*;

/**
 * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 * 
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        System.out.println(Arrays.toString(intersectWithSort(nums1, nums2)));
    }

    /**
     * 利用Hash表, 可能有相同元素出现多次, 需要统计次数
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int j = 0;
        int[] r = new int[nums2.length];
        for (int k : nums2) {
            if (map.containsKey(k) && map.get(k) > 0) {
                r[j++] = k;
                int i = map.get(k) - 1;
                map.put(k, i);
            }
        }
        return Arrays.copyOf(r, j);
    }

    /**
     * 如果数组是有序的
     * 则双指针，依次在两个已排序的数组中找相同的元素，如果相同则双指针同时移动，否则移动元素小的指针
     */
    public static int[] intersectWithSort(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        int n = 0;
        int[] r = new int[nums2.length];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                r[n++] = nums1[i];
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

    /**
     * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     * 使用方法1, 然后依次读取num2来判断。
     */
    public static int[] intersectWithLong(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int j = 0;
        int[] r = new int[nums1.length];
        for (int k : nums2) {
            // map没有元素, 后续的nums2不用再判断
            if (map.isEmpty()) {
                break;
            }
            if (map.containsKey(k) && map.get(k) > 0) {
                r[j++] = k;
                int i = map.get(k) - 1;
                // 等于0表示此元素已经没有交集了
                if (i == 0) {
                    map.remove(k);
                } else {
                    map.put(k, i);
                }
            }
        }
        return Arrays.copyOf(r, j);
    }
}

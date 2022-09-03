package com.shuai.algorithm.solution.solution_0646;

import java.util.*;

/**
 * 给出n个数对。在每一个数对中，第一个数字总是比第二个数字小。
 *
 * 现在，我们定义一种跟随关系，当且仅当b < c时，数对(c, d)才可以跟在(a, b)后面。我们用这种形式来构造一个数对链。
 *
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 *
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 * */
public class Solution {

    public static void main(String[] args) {
        int[][] pairs2 = {{1, 2}, {4, 5}, {7, 8}};
        System.out.println(findLongestChain(pairs2));
    }

    /**
     * 对数组根据第二个元素进行排序
     *
     * 则移除重叠的部分。 剩下的就是最长数对链
     * */
    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int current = Integer.MIN_VALUE;
        int result = 0;
        for (int[] pair : pairs) {
            if (pair[0] > current) {
                current = pair[1];
                result++;
            }
        }
        return result;
    }
}

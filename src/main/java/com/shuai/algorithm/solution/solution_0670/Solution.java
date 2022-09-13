package com.shuai.algorithm.solution.solution_0670;

/**
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 *
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 *
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * */
public class Solution {

    public static void main(String[] args) {
        int num = 22341345;
        System.out.println(maximumSwapWithSort(num));
    }

    /**
     * 无脑遍历, 对所有可能的结果取最大值
     *
     * 因为题目要求，只有8位才可以
     * */
    public static int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                swap(chars, i, j);
                max = Math.max(max, Integer.parseInt(new String(chars)));
                swap(chars, i, j);
            }
        }
        return max;
    }

    public static void swap(char[] chars, int m, int n) {
        char s = chars[n];
        chars[n] = chars[m];
        chars[m] = s;
    }


    /**
     * 基于选择排序的思想, 从后向前选择一个比当前大的值
     *
     * 从前开始遍历, 记录当前索引为最大索引
     *
     * 然后再进行遍历, 从后向前找最大的值
     *
     * 当找到最大值就更新索引, 同时更新索引后触发交换操作
     * 返回结果
     * */
    public static int maximumSwapWithSort(int num) {
        char[] chars = String.valueOf(num).toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int maxIndex = i;

            for (int j = chars.length - 1; j >= i + 1; j--) {
                if (chars[j] > chars[maxIndex]) {
                    maxIndex = j;
                }
            }
            // 相等说明找到了比当前值更大的
            if (maxIndex != i) {
                char s = chars[maxIndex];
                chars[maxIndex] = chars[i];
                chars[i] = s;
                return Integer.parseInt(new String(chars));
            }
        }
        return num;
    }
}

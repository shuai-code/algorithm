package com.shuai.algorithm.solution.solution_1539;

/**
 * 给你一个 严格升序排列的正整数数组 arr和一个整数k。
 *
 * 请你找到这个数组里第k个缺失的正整数。
 *
 * 输入：arr = [2,3,4,7,11], k = 5
 * 输出：9
 * 解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
 *
 * 输入：arr = [1,2,3,4], k = 2
 * 输出：6
 * 解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6
 * */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {2};
        System.out.println(findKthPositive(arr, 1));
    }

    /**
     * 如果最后一个元素大于数组长度, 表明数组内有空。那么判断数组内的空是否够k个， 不够则在数组后递增
     * 如果数组内的空够k取值
     * 那么在里面循环找空出现的位置
     * */
    public static int findKthPositive(int[] arr, int k) {
        int length = arr.length;
        int x = arr[length - 1] - length;
        if (x < k) {
            return arr[length - 1] + k - x;
        }
        int i = 0;
        while (i < length) {
            int c = arr[i] - i - 1;
            if (c >= k) {
                return arr[i] - (c - k + 1);
            }
            i++;
        }
        return 0;
    }
}

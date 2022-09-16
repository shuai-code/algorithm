package com.shuai.algorithm.solution.solution_1624;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
 *
 * 子字符串 是字符串中的一个连续字符序列。
 *
 * 输入：s = "aa"
 * 输出：0
 * 解释：最优的子字符串是两个 'a' 之间的空子字符串。
 *
 * 输入：s = "abca"
 * 输出：2
 * 解释：最优的子字符串是 "bc" 。
 *
 * 输入：s = "cbzxy"
 * 输出：-1
 * 解释：s 中不存在出现出现两次的字符，所以返回 -1 。
 *
 * 输入：s = "cabbac"
 * 输出：4
 * 解释：最优的子字符串是 "abba" ，其他的非最优解包括 "bb" 和 "" 。
 * */
public class Solution {
    public static void main(String[] args) {
        String s = "cabbac";
        System.out.println(maxLengthBetweenEqualCharacters(s));
    }

    /**
     * 遍历字符串, 记录每个字符串的索引
     *
     * 当出现重复的字符时计算差值, 因为要最大的跨度, 所以保留第一次放入map的元素
     * */
    public static int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int max = -1;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                Integer index = map.get(chars[i]);
                max = Math.max(i - index - 1, max);
            } else {
                map.put(chars[i], i);
            }
        }
        return max;
    }
}

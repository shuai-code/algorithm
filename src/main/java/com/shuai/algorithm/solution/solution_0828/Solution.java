package com.shuai.algorithm.solution.solution_0828;

import java.util.*;

/**
 * 我们定义了一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符，并返回唯一字符的个数。
 *
 * 例如：s = "LEETCODE" ，则其中 "L", "T","C","O","D" 都是唯一字符，因为它们只出现一次，所以 countUniqueChars(s) = 5 。
 *
 * 本题将会给你一个字符串 s ，我们需要返回 countUniqueChars(t) 的总和，其中 t 是 s 的子字符串。输入用例保证返回值为32 位整数。
 *
 * 注意，某些子字符串可能是重复的，但你统计时也必须算上这些重复的子字符串（也就是说，你必须统计 s 的所有子字符串中的唯一字符）。
 *
 * 输入: s = "ABC"
 * 输出: 10
 * 解释: 所有可能的子串为："A","B","C","AB","BC" 和 "ABC"。
 *      其中，每一个子串都由独特字符构成。
 *      所以其长度总和为：1 + 1 + 1 + 2 + 2 + 3 = 10
 *
 * 输入: s = "ABA"
 * 输出: 8
 * 解释: 除了 countUniqueChars("ABA") = 1 之外，其余与示例 1 相同。
 *
 * 输入：s = "LEETCODE"
 * 输出：92
 * */
public class Solution {

    public static void main(String[] args) {
        System.out.println(uniqueLetterStringWithWindow("LEETCODE"));
    }

    /**
     * 双重遍历
     * */
    public static int uniqueLetterString(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            count++;
            Set<Character> set = new HashSet<>();
            Set<Character> no = new HashSet<>();
            set.add(chars[i]);
            for (int j = i + 1; j < chars.length; j++) {
                if (!set.add(chars[j])) {
                    no.add(chars[j]);
                }
                count += set.size();
                if (no.size() > 0) {
                    count -= no.size();
                }
            }
        }
        return count;
    }

    /**
     * 根据公式计算
     * 每一段字符有多少个子字符串的公式为（当前索引 - 头索引）* （结尾索引 - 当前索引）
     * */
    public static int uniqueLetterStringWithWindow(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], new ArrayList<>());
            }
            map.get(chars[i]).add(i);
        }
        int count = 0;
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            int header = -1;
            List<Integer> indexList = entry.getValue();
            for (int i = 0; i < indexList.size(); i++) {
                int tail;
                if (i < indexList.size() - 1) {
                    tail = indexList.get(i + 1);
                } else {
                    tail = s.length();
                }
                count += (indexList.get(i) - header) * (tail - indexList.get(i));
                header = indexList.get(i);
            }
        }
        return count;
    }
}

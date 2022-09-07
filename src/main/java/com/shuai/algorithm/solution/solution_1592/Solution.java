package com.shuai.algorithm.solution.solution_1592;

import java.util.*;

/**
 * 给你一个字符串 text ，该字符串由若干被空格包围的单词组成。每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。题目测试用例保证 text 至少包含一个单词 。
 *
 * 请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。如果不能重新平均分配所有空格，请 将多余的空格放置在字符串末尾 ，这也意味着返回的字符串应当与原 text 字符串的长度相等。
 *
 * 返回 重新排列空格后的字符串 。
 *
 *
 * 输入：text = "  this   is  a sentence "
 * 输出："this   is   a   sentence"
 * 解释：总共有 9 个空格和 4 个单词。可以将 9 个空格平均分配到相邻单词之间，相邻单词间空格数为：9 / (4-1) = 3 个。
 *
 * 输入：text = " practice   makes   perfect"
 * 输出："practice   makes   perfect "
 * 解释：总共有 7 个空格和 3 个单词。7 / (3-1) = 3 个空格加上 1 个多余的空格。多余的空格需要放在字符串的末尾。
 *
 * 输入：text = "hello   world"
 * 输出："hello   world"
 *
 * 输入：text = "  walks  udp package   into  bar a"
 * 输出："walks  udp  package  into  bar  a "
 *
 * 输入：text = "a"
 * 输出："a"
 * */
public class Solution {

    public static void main(String[] args) {
        String text = " practice   makes   perfect";

        System.out.println(reorderSpaces(text));
    }

    /**
     * 模拟，求出空格和单词的数量
     * 然后根据公式计算，最后再按公式对单词进行拼接。 注意结尾的空格
     * */
    public static String reorderSpaces(String text) {
        int count = 0;

        List<String> list = new ArrayList<>();
        char[] chars = text.toCharArray();
        int i = 0;
        while (i < chars.length) {
            if (chars[i] == ' ') {
                count++;
                i++;
            } else {
                int j = i;
                while (j < chars.length) {
                    if (chars[j] == ' ') {
                        break;
                    }
                    if (j == chars.length - 1) {
                        j++;
                        break;
                    }
                    j++;
                }
                list.add(text.substring(i, j));
                i = j;
            }
        }
        StringBuilder result = new StringBuilder();
        int c = list.size() == 1 ? count : count / (list.size() - 1);
        for (String s : list) {
            result.append(s);
            int n = 0;
            while (n < c && count > 0) {
                result.append(" ");
                count--;
                n++;
            }
        }
        while (count > 0) {
            result.append(" ");
            count--;
        }
        return result.toString();
    }
}

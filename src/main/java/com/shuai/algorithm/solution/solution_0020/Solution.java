package com.shuai.algorithm.solution.solution_0020;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 输入：s = "()"
 * 输出：true
 *
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 输入：s = "(]"
 * 输出：false
 *
 * 输入：s = "([)]"
 * 输出：false
 *
 * 输入：s = "{[]}"
 * 输出：true
 * */
public class Solution {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    /**
     * 利用栈, 如果栈顶和要入栈的相匹配. 则移除这两个。 否则入栈
     * 如果最后栈内移空, 则说明结果为true
     * */
    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (!stack.empty() && stack.peek() == doGetCharacter(aChar)) {
                stack.pop();
            } else {
                stack.add(aChar);
            }
        }
        return stack.empty();
    }

    private static Character doGetCharacter(Character c) {
        switch (c) {
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
        }
        return null;
    }
}

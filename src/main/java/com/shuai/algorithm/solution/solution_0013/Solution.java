package com.shuai.algorithm.solution.solution_0013;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1 。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。
 *
 * 输入:s = "III"
 * 输出: 3
 *
 * 输入:s = "IV"
 * 输出: 4
 *
 * 输入:s = "IX"
 * 输出: 9
 *
 * 输入:s = "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 *
 * 输入:s = "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * */
public class Solution {
    public static void main(String[] args) {
        String s = "III";
        System.out.println(romanToIntWithMath(s));
    }

    /**
     * 双指针, 发现相连的两个元素右边比左边大, 则做减法。
     * 否则左边就是单独的， 直接累加
     *
     * MAP替换成下边的switch方法
     * */
    public static int romanToIntWithMath(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] chars = s.toCharArray();
        int j = 0;
        int sum = 0;
        while (j < chars.length) {
            if (j == chars.length - 1 || map.get(chars[j]) >= map.get(chars[j + 1])) {
                sum += map.get(chars[j]);
            } else {
                sum += map.get(chars[j + 1]) - map.get(chars[j]);
                j++;
            }
            j++;
        }
        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}

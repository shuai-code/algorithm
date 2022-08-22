package com.shuai.algorithm.solution.solution_0118;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负整数numRows，生成「杨辉三角」的前numRows行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 * */
public class Solution {

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
    }

    /**
     * 模拟， 初始化第一层的1
     * 然后依次取出上一个列表。
     * */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> nList = result.get(result.size() - 1);

            List<Integer> res = new ArrayList<>(Collections.singletonList(1));
            for (int i1 = 1; i1 < nList.size(); i1++) {
                res.add(nList.get(i1) + nList.get(i1 - 1));
            }
            res.add(1);
            result.add(res);
        }
        return result;
    }
}

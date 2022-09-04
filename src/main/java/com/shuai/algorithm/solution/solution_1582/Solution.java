package com.shuai.algorithm.solution.solution_1582;

/**
 * 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵mat 中特殊位置的数目 。
 *
 * 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
 *
 * 输入：mat = [[1,0,0],
 *            [0,0,1],
 *            [1,0,0]]
 * 输出：1
 * 解释：(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
 *
 * 输入：mat = [[1,0,0],
 *            [0,1,0],
 *            [0,0,1]]
 * 输出：3
 * 解释：(0,0), (1,1) 和 (2,2) 都是特殊位置
 *
 * 输入：mat = [[0,0,0,1],
 *            [1,0,0,0],
 *            [0,1,1,0],
 *            [0,0,0,0]]
 * 输出：2
 *
 * 输入：mat = [[0,0,0,0,0],
 *            [1,0,0,0,0],
 *            [0,1,0,0,0],
 *            [0,0,1,0,0],
 *            [0,0,0,1,1]]
 * 输出：3
 *
 * */
public class Solution {

    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0}
        };

        System.out.println(numSpecial(mat));
    }

    /**
     * 先预处理数据, 找出所有只有1个1的行和列
     * 再对这些点进行判断
     * */
    public static int numSpecial(int[][] mat) {
        int count = 0;
        // 保存行数据, 每行有几个1
        int[] row = new int[mat.length];
        // 保存列数据, 每列有几个1
        int[] col = new int[mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                // 如果当前坐标是1, 则行和列的计数都+1
                if (mat[i][j] == 1) {
                    row[i] += 1;
                    col[j] += 1;
                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            // 此行不止1个1, 跳过
            if (row[i] != 1) {
                continue;
            }
            for (int j = 0; j < col.length; j++) {
                // 此列不止1个1, 可能是0个或者多个
                if (col[j] != 1) {
                    continue;
                }
                // 因为i和j只是表示当前行或者列有1个1, 但是这个1不一定行列相交, 所以判断结果累加1
                if (mat[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}

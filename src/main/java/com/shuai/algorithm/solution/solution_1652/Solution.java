package com.shuai.algorithm.solution.solution_1652;

import java.util.Arrays;

/**
 * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为n的循环数组code以及一个密钥k。
 *
 * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会同时被替换。
 *
 * 如果k > 0，将第i个数字用 接下来k个数字之和替换。
 * 如果k < 0，将第i个数字用 之前k个数字之和替换。
 * 如果k == 0，将第i个数字用0替换。
 * 由于code是循环的，code[n-1]下一个元素是code[0]，且code[0]前一个元素是code[n-1]。
 *
 * 给你 循环数组code和整数密钥k，请你返回解密后的结果来拆除炸弹！
 *
 * 输入：code = [5,7,1,4], k = 3
 * 输出：[12,10,16,13]
 * 解释：每个数字都被接下来 3 个数字之和替换。解密后的密码为 [7+1+4, 1+4+5, 4+5+7, 5+7+1]。注意到数组是循环连接的。
 *
 * 输入：code = [1,2,3,4], k = 0
 * 输出：[0,0,0,0]
 * 解释：当 k 为 0 时，所有数字都被 0 替换。
 *
 * 输入：code = [2,4,9,3], k = -2
 * 输出：[12,5,6,13]
 * 解释：解密后的密码为 [3+9, 2+3, 4+2, 9+4] 。注意到数组是循环连接的。如果 k 是负数，那么和为 之前 的数字。
 * */
public class Solution {
    public static void main(String[] args) {
        int[] code = {5, 7, 1, 4};
        System.out.println(Arrays.toString(decryptWithWindow(code, -3)));
    }

    /**
     * 模拟计算
     * */
    public static int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        if (k == 0) {
            return res;
        }
        for (int i = 0; i < code.length; i++) {
            int sum = 0;
            if (k > 0) {
                int c = i + 1;
                for (int j = 0; j < k; j++) {
                    if (c == code.length) {
                        c = 0;
                    }
                    sum += code[c];
                    c++;
                }
            } else {
                int c = i - 1;
                for (int j = 0; j < k * -1; j++) {
                    if (c == -1) {
                        c = code.length - 1;
                    }
                    sum += code[c];
                    c--;
                }
            }
            res[i] = sum;
        }
        return res;
    }

    /**
     * 滑动窗口
     * 计算一个窗口的合计, 那么后边的计算方式就是  这个合计移除第一个元素, 加上后一个元素的值
     * 1， 3， 4， 5， 6
     * [1, 3, 4] = 8
     * 8 - 1 + 5 = 12       这里只需要减去1加上5
     * 12 - 3 + 6 = 15      这里只需要减去3加上6
     *
     * 所有计算采用取模计算
     * */
    public static int[] decryptWithWindow(int[] code, int k) {
        int[] res = new int[code.length];
        if (k == 0) {
            return res;
        }
        int count = Math.abs(k);
        int head = k > 0 ? 0 : code.length - 1;
        int tail = k > 0 ? 1 : 0;
        // 计算第一个窗口的合计
        int sum = 0;
        while (count > 0) {
            if (k > 0) {
                head = (head + 1) % code.length;
                sum += code[head];
            } else {
                tail = (tail - 1 + code.length) % code.length;
                sum += code[tail];
            }
            count--;
        }
        // 第一个结果
        res[0] = sum;
        for (int i = 1; i < code.length; i++) {
            res[i] = sum + code[++head % code.length] - code[tail];
            sum = res[i];
            tail = ++tail % code.length;
        }
        return res;
    }
}

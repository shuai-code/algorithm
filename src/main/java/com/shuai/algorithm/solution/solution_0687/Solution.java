package com.shuai.algorithm.solution.solution_0687;

import com.shuai.algorithm.entity.TreeNode;

/**
 * 给定一个二叉树的root，返回最长的路径的长度 ，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 两个节点之间的路径长度由它们之间的边数表示。
 * */
public class Solution {
    public static int result = 0;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 1;
        System.out.println(longestUnivaluePath(treeNode));
    }

    public static int longestUnivaluePath(TreeNode root) {
        calculate(root);
        return result;
    }

    /**
     * 深度优先遍历
     * 找到最深的同时节点值相同的路线
     *
     * 递归左节点, 一直到底
     * 到底后开始找右节点, 到右节点也到底时
     * 判断: 左节点和父节点相同, 左+1
     * 右节点和父节点相同, 右+1
     * 左右相加和结果比较, 保留最大值。
     * */
    private static int calculate(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = calculate(root.left);
        int right = calculate(root.right);
        // 如果左节点和父节点相同就+1, 否则就是长度0
        left = root.left != null && root.left.val == root.val ? ++left : 0;
        // 如果右节点和父节点相同就+1, 否则就是长度0
        right = root.right != null && root.right.val == root.val ? ++right : 0;
        result = Math.max(result, left + right);
        return Math.max(left, right);
    }
}

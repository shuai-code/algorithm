package com.shuai.algorithm.solution.solution_0669;

import com.shuai.algorithm.entity.TreeNode;

/**
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
 * 修剪树 不应该改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在唯一的答案。
 *
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 * */
public class Solution {

    public static void main(String[] args) {

    }

    /**
     * 二叉搜索树特点：左节点小于父节点， 右节点大于父节点
     * 那么可知， 如果父节点小于low，那么这个节点的所有左节点都不满足。 剪切掉左节点，直接取右节点判断
     * 如果父节点大于high， 那么这个节点的所有右子节点都不满足， 剪切掉右节点，直接取左节点
     * 最后在low和high直接， 递归向下处理
     * */
    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }
}

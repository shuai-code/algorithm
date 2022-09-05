package com.shuai.algorithm.solution.solution_0652;

import com.shuai.algorithm.entity.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一棵二叉树 root，返回所有重复的子树。
 *
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 * */
public class Solution {

    List<TreeNode> result = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.right.left = new TreeNode(2);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.left.left = new TreeNode(4);
        Solution solution = new Solution();
        System.out.println(solution.findDuplicateSubtrees(treeNode));
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> map = new HashMap<>();
        find(root, map);
        return this.result;
    }

    /**
     * 二叉树的前序遍历
     * 每找到一个子节点, 就组装把子节点的所有节点组装成字符串保存到Hash表里
     * 当Hash表里有重复的, 就说明找到了一个重复节点
     * */
    private String find(TreeNode root, Map<String, Integer> map) {
        if (root == null) {
            return "";
        }
        String key = String.valueOf(root.val);
        String left = find(root.left, map);
        String right = find(root.right, map);
        key = key + "," + left + "," + right;
        if (map.getOrDefault(key, 0) == 1) {
            this.result.add(root);
        }
        map.put(key, map.getOrDefault(key, 0) + 1);
        return key;
    }
}

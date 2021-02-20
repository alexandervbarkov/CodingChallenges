package com.alexandervbarkov.codingchallenges.leetcode.p226InvertBinaryTree;

import com.alexandervbarkov.codingchallenges.common.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                4,
                new TreeNode(
                        2,
                        new TreeNode(3),
                        new TreeNode(5)),
                new TreeNode(
                        9,
                        null,
                        new TreeNode(7)));
        System.out.println(new Solution().invertTree(root));
    }
    
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}

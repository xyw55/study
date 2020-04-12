/*
 * @(#) DiameterBinaryTree.java 2020-04-12
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.xyw55.tree;

/**
 * leetcode 543. Diameter of Binary Tree
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * @author xyw55
 * @version 2020-04-12
 */
public class DiameterBinaryTree {

    /**
     * 分别遍历左右子树，获取左右子树的深度和左右子树最大的path
     * 因为需要返回两个值，所以用node的val暂存了树的深度
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftDepth = 0;
        int rightDepth = 0;
        int leftDiameter = 0;
        int rightDiameter = 0;
        if (null != root.left) {
            leftDiameter = diameterOfBinaryTree(root.left);
            leftDepth = root.left.val + 1;
        }
        if (null != root.right) {
            rightDiameter = diameterOfBinaryTree(root.right);
            rightDepth = root.right.val + 1;
        }
        root.val = Math.max(leftDepth, rightDepth);
        int subMaxDiameter = Math.max(leftDiameter, rightDiameter);
        return Math.max(leftDepth + rightDepth, subMaxDiameter);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        DiameterBinaryTree diameterBinaryTree = new DiameterBinaryTree();
        System.out.println(diameterBinaryTree.diameterOfBinaryTree(root));
    }

}

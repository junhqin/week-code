package com.junhqin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class problem113 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; }
    }
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return List.of();
        findPath(root,targetSum);
        return result;
    }

    public void findPath(TreeNode root, int targetSum) {
        if(root.val == targetSum) {
            targetSum -= root.val;
            path.add(root.val);
            System.out.println(path);
            result.add(path);
        }
        targetSum -= root.val;
        path.add(root.val);
        if(root.left!=null) findPath(root.left,targetSum);
        if(root.right!=null) findPath(root.right,targetSum);
        path.remove(path.size()-1);
    }
}

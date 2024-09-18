package com.junhqin.leetcode;

import com.sun.source.tree.TreeVisitor;

public class problem107{
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, problem112.TreeNode left, problem112.TreeNode right) { this.val = val; this.left = left; this.right = right; }
    }
    public TreeNode build(int[] inorder, int[] postorder, int inbegin,int inend, int postbegin, int postend){
        int insize = inend-inbegin+1;
        int postsize = postend-postbegin+1;
        if(insize <= 0 || postsize <=0) return null;
        if(insize==postsize && insize == 1) return new TreeNode(postorder[postbegin]);
        TreeNode root = new TreeNode();
        root.val = postorder[postend];
        int index = -1;
        for(int i=inbegin;i<=inend;i++){
            if(inorder[i] == root.val){
                index = i;
                break;
            }
        }
        int left_len = index-inbegin;
        root.left = build(inorder, postorder, inbegin,index-1,postbegin,postbegin+left_len-1);
        root.right = build(inorder, postorder, index+1, inend,postbegin+left_len,postend-1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0 || inorder.length == 0) return null;
        int rootValue = postorder[postorder.length-1];
        int index = -1;
        for(int i = 0;i< inorder.length;i++){
            if(rootValue == inorder[i]){
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootValue);
        root.left = build(inorder,postorder,0,index-1,0,index-1);
        root.right = build(inorder,postorder,index+1,inorder.length-1,index,postorder.length-2);
        return root;
    }
}

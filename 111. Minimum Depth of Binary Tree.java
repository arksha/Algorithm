// 111. Minimum Depth of Binary Tree

// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
// ----------------------------------------------------------------------------------------------------------------
// different from maximum depth of BST, when left child is empty, go to check right child min depth.
// otherwise, if both child are not null, compare and return the minimum depth.

public class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null) return minDepth(root.right)+1;
        if(root.right==null) return minDepth(root.left)+1;
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}
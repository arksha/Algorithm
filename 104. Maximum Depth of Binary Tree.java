// 104. Maximum Depth of Binary Tree
// Given a binary tree, find its maximum depth.

// The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
// --------------------------------------------------------------------------------------------------------------
// recursive
// 1. recursively compare left subtree and right subtree until leaf node
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    
}
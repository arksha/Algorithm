// 110. Balanced Binary Tree

// Given a binary tree, determine if it is height-balanced.

// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

// ---------------------------------------------------------------------------------------------------
// use dfs calculate height of tree, recursively
// if diff is more than 1, return -1
// check if the height is -1 in every level

// return -1 if this subtree is unbalanced and return the height if it is balanced.
// This will avoid much further search 

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return calheight(root)!=-1;
    }
    private int calheight(TreeNode root){
       if(root==null) return 0;
       int leftheight = calheight(root.left);
       if(leftheight==-1) return -1;
       int rightheight = calheight(root.right);
       if(rightheight==-1) return -1;
       if(leftheight-rightheight<-1||leftheight-rightheight>1)
       return -1;
       return Math.max(leftheight,rightheight)+1;
    }
}
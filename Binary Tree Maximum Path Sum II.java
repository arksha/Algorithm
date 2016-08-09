// Binary Tree Maximum Path Sum II

// Given a binary tree, find the maximum path sum from root.

// The path may end at any node in the tree and contain at least one node in it.

// Given the below binary tree:

//   1
//  / \
// 2   3
// return 4. (1->3)

// ------------------------------------------------------------------------------------------------
// Calculate sum root to any node in the tree, node value could be negative.

// NB: get left and right need to compare with zero to avoid if both left and right subtree < 0

public class Solution {
    /**
     * @param root the root of binary tree.
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        // Write your code here
        if(root == null){
            return 0;
        }

        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        
        // root -> anynode        
        return Math.max(0, Math.max(left, right)) + root.val;
    }
}
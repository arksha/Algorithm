// Complete Binary Tree

// Check a binary tree is completed or not. A complete binary tree is a binary tree that every level is completed filled except the deepest level. In the deepest level, all nodes must be as left as possible. See more definition

// Example
//     1
//    / \
//   2   3
//  /
// 4
// is a complete binary.

//     1
//    / \
//   2   3
//    \
//     4
// is not a complete binary.

// Challenge 
// Do it in O(n) time

// ----------------------------------------------------------------------------------------

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class CompleteType{
    public int height;
    public boolean isFull;
    public boolean isComp;
    public CompleteType(int height, boolean isFull, boolean isComp){
        this.height = height;
        this.isFull = isFull;
        this.isComp = isComp;
    }
}
public class Solution {
    /**
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */
    public boolean isComplete(TreeNode root) {
        return helper(root).isComp;
    }
    
    private CompleteType helper(TreeNode root){
        if(root == null){
            return new CompleteType(0, true, true);
        }
        CompleteType left = helper(root.left);
        CompleteType right = helper(root.right);
        
        if(!left.isComp){
            return new CompleteType(-1, false, false);
        }
        //same level
        if(left.height == right.height){
            if(!left.isFull || !right.isComp){
                return new CompleteType(-1, false, false);
            }
            return new CompleteType(left.height + 1, right.isFull, true);
        }
        //left in next level
        if(left.height == right.height + 1){
            if(!left.isComp || !right.isFull){
               return new CompleteType(-1, false, false); 
            }
            return new CompleteType(left.height + 1, false, true);
        }
        return new CompleteType(-1, false, false);
    }
}
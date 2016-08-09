// 98. Validate Binary Search Tree

// Given a binary tree, determine if it is a valid binary search tree (BST).

// Assume a BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
// Example 1:
//     2
//    / \
//   1   3
// Binary tree [2,1,3], return true.
// Example 2:
//     1
//    / \
//   2   3
// Binary tree [1,2,3], return false.
// -------------------------------------------------------------------------------------------------------------
// recursive dfs 
// 1. root.val should bigger than biggest in left subtree, smaller than smallest in right subtree
// 2. use Integer for max and min, initialize as null
// 3. if go left subtree, update max with root.val, right one update min with root.val 
// 4. use helper

// public class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return helper(root, null, null);
//     }
//     private boolean helper(TreeNode root, Integer min, Integer max){
//         if(root==null) return true;
//         if(min != null && root.val<=min || max!=null && root.val>=max ) return false;
//         return helper(root.left, min,root.val) && helper (root.right,root.val, max);
//     }
// }

// update: more clear version

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        return validHelper(root, null, null);
    }

    private boolean validHelper(TreeNode root, Integer max, Integer min){
        if(root == null){
            return true;
        }
        if(max != null && root.val >= max){
            return false;
        }
        if(min != null && root.val <= min){
            return false;
        }
        return validHelper(root.left, root.val, min) &&
                validHelper(root.right, max, root.val);
    }
}

// -------------------------------------------------------------------------------------------
// with return type
// 1. use helper, helper return returntype
// 2. Divide: let left and right figure out result
// 3. Conquer: return invalid condition first, then return valid condition
// 4. invalid condition: left is not valid or right is not balanced, set min and max into 0
// 					  left max >= root.val or right.min <= root.val
// 5. valid condition: return true and update max and min 

// NB: return class do not contain root.
// 	update max with current right subtree biggest, min with current left subtree smallest.
	
class ValidNode{
    boolean isbst;
    int max, min;
    public ValidNode(boolean isbst, int max, int min){
        this.isbst = isbst;
        this.max = max;
        this.min = min;
    }
}
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return ValidHelper(root).isbst;
    }
    private ValidNode ValidHelper(TreeNode root){
        if(root == null){
            return new ValidNode(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        ValidNode left = ValidHelper(root.left);
        ValidNode right = ValidHelper(root.right);
        
        if(!left.isbst || !right.isbst){
            return new ValidNode(false, 0, 0);
        }
        if(root.left != null && left.max >= root.val ||
            root.right != null && right.min <= root.val){
            return new ValidNode(false, 0, 0);
        }
        return new ValidNode(true, 
                             Math.max(right.max, root.val),
                             Math.min(left.min,root.val));
    }
    
}
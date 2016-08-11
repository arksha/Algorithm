// 110. Balanced Binary Tree

// Given a binary tree, determine if it is height-balanced.

// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

// ---------------------------------------------------------------------------------------------------
// 1.use two recursive methods
// 2. max difference of depth has to be less than 1
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int b = Math.abs(depth(root.left)-depth(root.right));//calculate
        if(b>1) return false;
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    public int depth(TreeNode root){
        if(root==null) return 0;
        return Math.max(depth(root.left),depth(root.right)) +1;
    }
}

// ---------------------------------------------------------------------------------------------------
// Divide and Conquer way
// 1. need a return type "Balance " to return "isbalance" and "maxdepth" of current node
// 2. use a "balancedHelper" to copy the function of "isBalanced", and be able to return a "Balance" type 
// 3. Divide : get result of left and right subtree 
// 4. Conquer: cut out unbalanced conditions, left subtree , right subtree, root is unbalanced(depth > 1);
//             at last return the normal condition.
//             If root is null, this is also balanced and depth is 0.


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
 
// return type
class Balance{
    public boolean isbalance;
    public int maxdepth;
    public Balance(boolean isbalance, int maxdepth){
        this.isbalance = isbalance;
        this.maxdepth = maxdepth;
    }
} 
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        Balance balance = balancedHelper(root);
        return balance.isbalance;
        // return balancedHelper(root).isbalance;
    }
    //return Balance type
    public Balance balancedHelper(TreeNode root){
        if(root == null){
            return new Balance(true, 0);
        }
        Balance left = balancedHelper(root.left);
        Balance right = balancedHelper(root.right);
        //subtree is not balanced
        if(!left.isbalance){
            return new Balance(false, -1);
        }
        if(!right.isbalance){
            return new Balance(false, -1);
        }
        //root is not balanced, diff of depth > 1
        if(Math.abs(left.maxdepth - right.maxdepth) > 1){
            return new Balance(false, -1);
        }
        return new Balance(true, Math.max(left.maxdepth,right.maxdepth)+1);
        
    }
}
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
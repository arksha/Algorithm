// 270. Closest Binary Search Tree Value

// Given target value is a floating point.
// You are guaranteed to have only one unique value in the BST that is closest to the target.

// Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

// Note:
// Given target value is a floating point.
// You are guaranteed to have only one unique value in the BST that is closest to the target.


// ------------------------------------------------------------------------------------------------------------

public class Solution {
    public int closestValue(TreeNode root, double target) {
        if(root==null) return -1;
        
        double min = Double.MAX_VALUE;
        int res = root.val;
        
        while(root!=null){
            if(Math.abs(root.val-target)<min){
                min = Math.abs(root.val-target);
                res = root.val;
            } 
            if(target>root.val) root = root.right;
            else if(target<root.val) root = root.left;
            else return root.val;
        } 
        return res;
    }
   
}

// 108. Convert Sorted Array to Binary Search Tree

// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

// --------------------------------------------------------------------------------------------------------
// like binary search
// use dfs recursively
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0 ) return null;
        return helper(nums,0,nums.length-1);
    }
    private TreeNode helper(int[] nums,int i,int j){
        if(i>j) return null; 
        int mid = i+ (j-i)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,i,mid-1);
        root.right = helper(nums,mid+1,j);
        return root;
    }
}
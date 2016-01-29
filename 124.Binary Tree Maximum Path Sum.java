//124.Binary Tree Maximum Path Sum
//find arbitrary two treenode's maximum path sum , value could be negative
public class Solution {
    public int maxPathSum(TreeNode root) {//java don't accept & refer value as C++ so use array to store result
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        getsum(root,res);
        return res[0];
        
    }
    public int getsum(TreeNode root,int[] res){
        if(root==null) return 0;
        int left = getsum(root.left,res);
        int right = getsum(root.right,res);
        int cur = Math.max(root.val,Math.max(root.val+left,root.val+right));//find most top node sum of max path
        res[0] = Math.max(res[0], Math.max(cur,left+root.val+right));
        return cur;
    }
}
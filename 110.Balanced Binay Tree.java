//110. Balanced Binary Tree
// max depth has to be less than 1
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
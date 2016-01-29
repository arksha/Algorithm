//104 Maximum Depth of Binary Tree
//recursively compare left subtree and right subtree until leaf node
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root ==null) return 0;
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }
}
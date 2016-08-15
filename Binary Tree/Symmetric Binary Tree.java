Symmetric Binary Tree

Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example
    1
   / \
  2   2
 / \ / \
3  4 4  3
is a symmetric binary tree.

    1
   / \
  2   2
   \   \
   3    3
is not a symmetric binary tree.

Challenge 
Can you solve it both recursively and iteratively?

------------------------------------------------------------------------------------
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
public class Solution {
    /**
     * @param root, the root of binary tree.
     * @return true if it is a mirror of itself, or false.
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode a, TreeNode b){
        if(a == null && b == null){
            return true;
        } 
        if(a == null || b == null){
            return false;
        }
        boolean outersub = isSymmetric(a.left,b.right);
        boolean innersub = isSymmetric(a.right,b.left);
        
        if(outersub && innersub && a.val == b.val){
            return true;
        }
        return false;
    }
}
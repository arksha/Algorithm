222. Count Complete Tree Nodes

Given a complete binary tree, count the number of nodes.

//1.brute force TLE
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
//2,
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root==null) return 0;
        int hl = 0, hr = 0;
        TreeNode l = root, r = root;
        while(l!=null) {hl++; l = l.left;}
        while(r!=null) {hr++; r = r.right;}
        if (hl == hr) return (1<<hl)- 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
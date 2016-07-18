101. Symmetric Tree

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

------------------------------------------------------------------------------------------------------------------------
Recursion way aka DFS
only analize for one level 
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return helper(root.left,root.right);
    }
    public boolean helper(TreeNode left, TreeNode right){
        if(left==null&&right==null) return true;
        if(left==null||right==null) return false;
        if(left.val!=right.val) return false;
        return helper(left.left,right.right) && helper(left.right,right.left);
    }
}
// -----------------------------------------------------------------------------------------------------------------------
// Iteration way aka BFS
// with one queue , trick is order when offer node into queue 
// can also use stack, just push 2 node together, and pop out 2 node together.

// NB: l and r both null continue to next level

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        while(!q.isEmpty()){
            TreeNode l = q.poll();
            TreeNode r = q.poll();
            if(l==null&&r==null) continue;
            if(l==null||r==null ) return false;
            if(l.val!=r.val) return false;
            q.offer(l.left);
            q.offer(r.right);
            q.offer(r.left);
            q.offer(l.right);
        }
        return true;
    }
}

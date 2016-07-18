// 226. Invert Binary Tree

// Invert a binary tree.

//      4
//    /   \
//   2     7
//  / \   / \
// 1   3 6   9
// to
//      4
//    /   \
//   7     2
//  / \   / \
// 9   6 3   1
// Trivia:
// This problem was inspired by this original tweet by Max Howell:
// Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.

// ------------------------------------------------------------------------------------------------------------------------------
// recursive dfs
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
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        helper(root);
        return root;
    }
    public void helper(TreeNode root){
        if(root.left==null&&root.right==null) return;
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        if(root.left!=null)
            helper(root.left);
        if(root.right!=null)
            helper(root.right);
    }
}

// a more consice version of dfs
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = invertTree(right);
            root.right = invertTree(left);
        return root;
    }
}
// ----------------------------------------------------------------------------------------------------------------
// bfs version

public class Solution {
    public TreeNode invertTree(TreeNode root) {
       
        if (root == null) {
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}
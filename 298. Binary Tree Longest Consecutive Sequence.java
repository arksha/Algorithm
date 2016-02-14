// 298. Binary Tree Longest Consecutive Sequence.java
// Given a binary tree, find the length of the longest consecutive sequence path.

// The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

// For example,
//    1
//     \
//      3
//     / \
//    2   4
//         \
//          5
// Longest consecutive sequence path is 3-4-5, so return 3.
//    2
//     \
//      3
//     / 
//    2    
//   / 
//  1
// Longest consecutive sequence path is 2-3,not3-2-1, so return 2.

//recursion with DFS
//should record root, last root value, max length for now
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
    public int longestConsecutive(TreeNode root) {
        if(root==null) return 0;
        return dfs(root,root.val-1,0);
    }
    public int dfs(TreeNode root, int pre, int len){
        if(root==null) return len;
        int curlen = pre +1==root.val ? len+1:1;
        return Math.max(curlen, Math.max(dfs(root.left,root.val,curlen),dfs(root.right,root.val,curlen)) );
    }
    
}
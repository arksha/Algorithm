// 94. Binary Tree Inorder Traversal

// Given a binary tree, return the inorder traversal of its nodes' values.

// For example:
// Given binary tree [1,null,2,3],
//    1
//     \
//      2
//     /
//    3
// return [1,3,2].

// Note: Recursive solution is trivial, could you do it iteratively?

// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode(int x) { val = x; }
//  * }
//  */

// --------------------------------------------------------------------------------------------------------------------------
// recursive

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursive(root,res);
        return res;
    }
    public void recursive(TreeNode root, List<Integer> res){
        if(root==null)
            return;
        recursive(root.left,res);
        res.add(root.val);
        recursive(root.right,res);
    }
}

// --------------------------------------------------------------------------------------------------------------------------
// iterative

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode top = s.peek();
            if(top.left!=null){
                s.push(top.left);
                top.left = null;
            }else{
                res.add(top.val);
                s.pop();
                if(top.right!=null) s.push(top.right);
                
            }
        }
    return res;
    }
}

//did not figure out how to use hashtable in this question

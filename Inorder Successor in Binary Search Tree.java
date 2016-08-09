// Inorder Successor in Binary Search Tree

// Given a binary search tree (See Definition) and a node in it, find the in-order successor of that node in the BST.

// If the given node has no in-order successor in the tree, return null.

// Notice
// It's guaranteed p is one node in the given tree. (You can directly compare the memory address to find p)

// Example
// Given tree = [2,1] and node = 1:

//   2
//  /
// 1
// return node 2.

// Given tree = [2,1,3] and node = 2:

//   2
//  / \
// 1   3
// return node 3.

// Challenge 
// O(h), where h is the height of the BST.
// ------------------------------------------------------------------------------------------------
// inorder traversal nonrecursion
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode curNode = null;
        while(root != null && p.val != root.val){
            if(p.val < root.val){
                curNode = root;
                root = root.left;
            }else {
                root = root.right;
            }
        }
        if(root == null){
            return null;
        }
        if(root.right == null) {
            return curNode;
        }
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}
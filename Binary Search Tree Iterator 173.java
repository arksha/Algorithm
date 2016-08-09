// 173. Binary Search Tree Iterator 

// Difficulty: Medium
// Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

// Calling next() will return the next smallest number in the BST.

// Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

// ------------------------------------------------------------------------------------------------
// inorder traverse nonrecursion
// 1. push every left node till null
// 2. pop and return stack top
// 3. add right node into stack

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode root;
    //@param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        // write your code here
        this.root = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return (root != null || !stack.isEmpty());
        // write your code here
    }
    
    //@return: return next node
    public TreeNode next() {
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        TreeNode node = root;
        root = root.right;
        return node;
        // write your code here
    }
}

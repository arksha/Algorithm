// 235. Lowest Common Ancestor of a Binary Search Tree

// Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

//         _______6______
//        /              \
//     ___2__          ___8__
//    /      \        /      \
//    0      _4       7       9
//          /  \
//          3   5
// For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

// --------------------------------------------------------------------------------------------------------------
// iterative
check 
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //root is bigger than two target node
        while ((root.val - p.val) * (root.val - q.val) > 0)
        //if p < root go left traverse, else go right subtree
            root = p.val < root.val ? root.left : root.right;
        //return root as default
        return root;  
    }
}
// -----------------------------------------------------------------------------------------------------------------
// recursive
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ( (root.val - p.val) * (root.val - q.val) <=0 )
            return root;
        else 
            return lowestCommonAncestor(p.val < root.val ? root.left : root.right, p, q);
    }
}
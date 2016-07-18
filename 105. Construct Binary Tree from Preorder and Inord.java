//105. Construct Binary Tree from Preorder and Inorder Traversal

// Given preorder and inorder traversal of a tree, construct the binary tree.

// Note:
// You may assume that duplicates do not exist in the tree.

// --------------------------------------------------------------------------------------------------------
//recursive find root, preorder firstone always is root,
//find root index inroder, 
//inorder:               left(is    index -1),		    index(root),    right(index+1        ie)
//preorder:    ps(root)  left(ps+1  ps+ 1+ index-1-is),                 right(ps+1+index-is  pe),	

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length!=inorder.length) return null;
        return FindRoot(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    private TreeNode FindRoot(int[] preorder, int ps,int pe, int[] inorder, int is,int ie){
        if(is>ie||ps>pe) return null;
        int rootindex = FindIndex(inorder, is,ie,preorder[ps]);
        TreeNode root = new TreeNode(preorder[ps]);
        root.left = FindRoot(preorder,ps+1,ps+rootindex-is, inorder, is,rootindex-1);
        root.right = FindRoot(preorder,ps+1+rootindex-is,pe, inorder, rootindex+1,ie);
        return root;
    }
    private int FindIndex(int[] arr, int s, int e,int val){
        for(int i = s;i<=e;i++){
            if(val== arr[i]) return i;
        }
        return -1;
    }
}
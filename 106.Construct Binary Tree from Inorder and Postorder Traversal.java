//106.Construct Binary Tree from Inorder and Postorder Traversal

// Given inorder and postorder traversal of a tree, construct the binary tree.

// Note:
// You may assume that duplicates do not exist in the tree.

// ----------------------------------------------------------------------------------------------------
//recursive find root, postorder lastone always is root,
//find root int inroder, 
//inorder:     left(is  index -1),		    index(root),    right(index+1      ie)
//postorder:   left(ps  ps+ index-1-is),                    right(ps+index-is  pe-1),	pe(root)  

// use two help function:
// recursive find root : get part of inorder array and postorder array, to do dfs 
// findindex : find postorder responsive index in inorder array.

// NB: careful to map the index in both array, use index to represent the begin and end in both array
public class Solution {
    private int FindIndex(int[] arr, int s,int e,int val){
        for(int i = s;i<=e;i++){
            if(arr[i] ==val) return i;
        }
        return -1;
    }
    private TreeNode RecursiveFindRoot(int[] inorder, int is,int ie,int[] postorder, int ps,int pe){
        if(is>ie) return null;
        int index = FindIndex(inorder, is,ie, postorder[pe]);
        TreeNode root = new TreeNode(postorder[pe]);
        root.left = RecursiveFindRoot(inorder, is,index-1,postorder,ps,ps+index-is-1);
        root.right = RecursiveFindRoot(inorder,index+1,ie, postorder, ps+index-is,pe-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length!=postorder.length) return null;
        return RecursiveFindRoot(inorder, 0, inorder.length-1,postorder,0,postorder.length-1);
    }
}
// ----------------------------------------------------------------------------------------------------
// there is also a iterative version with stack, try it.
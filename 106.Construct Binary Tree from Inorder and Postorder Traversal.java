//106.Construct Binary Tree from Inorder and Postorder Traversal
//recursive find root, postorder lastone always is root,
//find root int inroder, 
//inorder:     left(is  index -1),		    index(root),    right(index+1      ie)
//postorder:   left(ps  ps+ index-1-is),                    right(ps+index-is  pe-1),	pe(root)  



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
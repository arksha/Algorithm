230. Kth Smallest Element in a BST
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //1.inorder traversal O(n) implement by iteration and stack
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        int res = 0;
        while(!s.isEmpty()||p!=null){
            if(p!=null){
                s.push(p);
                p = p.left;
            }else{
                TreeNode t = s.pop();
                k--;
                if(k==0) res = t.val;
                p = t.right;
            }
        }
        return res;
    }
}
//2. binary search, count every subtree node number

public class Solution {
    public int kthSmallest(TreeNode root, int k) {//binary recursive
        
        int count  = countnode(root.left);//count left subtree
        if(count+1==k) 
            return root.val;
        else if(count+1<k) 
            return kthSmallest(root.right,k-1-count);//have to minus root itself
        else 
            return kthSmallest(root.left,k);
    }
    public int countnode(TreeNode root){
        if(root==null) return 0;
        return 1+countnode(root.left)+countnode(root.right);
        
    } 
}
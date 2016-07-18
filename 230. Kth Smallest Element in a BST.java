// 230. Kth Smallest Element in a BST

// Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

// Note: 
// You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

// Follow up:
// What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

// Hint:

// Try to utilize the property of a BST.
// What if you could modify the BST node's structure?
// The optimal runtime complexity is O(height of BST).

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

// --------------------------------------------------------------------------------------------------------
// dfs with a buffer, traverse the BST inorder to have a ordered list

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> buffer = new ArrayList<>();
        inorder(root, buffer, k);
        return buffer.get(k-1);
    }
    private void inorder(TreeNode root,List<Integer> buffer, int k){
        if(buffer.size()>=k) return;
        if(root.left!=null) inorder(root.left, buffer, k);
        buffer.add(root.val);
        if(root.right!=null) inorder(root.right, buffer, k);
    }
}
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
 //1.inorder traversal O(n)
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
//2. binary search
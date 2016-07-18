// 257. Binary Tree Paths
// Given a binary tree, return all root-to-leaf paths.

// For example, given the following binary tree:

//    1
//  /   \
// 2     3
//  \
//   5
// All root-to-leaf paths are:

// ["1->2->5", "1->3"]
// -------------------------------------------------------------------------------------------------------------------------------
//dfs 

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root ==null) return res;
        String str = Integer.toString(root.val);
        dfs(res,root,str);
        return res;
    }
    public void dfs(List<String> res, TreeNode r, String s){
        if(r!=null){
            if(r.left==null&&r.right==null) res.add(s);
            if(r.left!=null) dfs(res,r.left,s+"->"+Integer.toString(r.left.val));
            if(r.right!=null) dfs(res,r.right,s+"->"+Integer.toString(r.right.val));
        }
    }
}
// -------------------------------------------------------------------------------------------------------------------------------
// updated : same above dfs
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root==null) return res;
        String list = new String(root.val+"");
        dfs(root, res, list);
        return res;
    }
    private void dfs(TreeNode root, List<String> res, String list){
        if(root==null||root.left==null&&root.right==null){
            res.add(list);
            return;
        }
        if(root.left!=null)
            dfs(root.left,res,list+"->"+root.left.val);
        if(root.right!=null)
            dfs(root.right,res,list+"->"+root.right.val);
        
    }
}
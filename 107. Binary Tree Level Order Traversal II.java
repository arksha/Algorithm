// 107. Binary Tree Level Order Traversal II

// Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its bottom-up level order traversal as:
// [
//   [15,7],
//   [9,20],
//   [3]
// ]
// ---------------------------------------------------------------------------------------------------------------------s
// same idea with I, just add to res in the front every time end with level.

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelnum = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i<levelnum;i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            res.add(0,list);
        }
        return res;
    }
}

// --------------------------------------------------------------------------------------------------------------
// BFS
// NB: add from bottom to up
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root==null) return res;
        dfs(res, root, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, TreeNode root, int level){
        if(root==null) return;
        if(level>= res.size()) res.add(0,new LinkedList<Integer>());
        dfs(res,root.left,level+1);
        dfs(res,root.right,level+1);
        res.get(res.size()-level-1).add(root.val);// add from front in level list
    }
}
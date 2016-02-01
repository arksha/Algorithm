//144. Binary Tree Preorder Traversal

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        dfs(list, root);
        return list;
    }
    public void dfs(List<Integer> list, TreeNode root){
        if(root != null){
            list.add(root.val);
            dfs(list,root.left);
            dfs(list,root.right);
        }
    }
}


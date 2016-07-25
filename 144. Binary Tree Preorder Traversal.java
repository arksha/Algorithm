//144. Binary Tree Preorder Traversal

// Given a binary tree, return the preorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [1,2,3].

// Note: Recursive solution is trivial, could you do it iteratively?

// ---------------------------------------------------------------------------------------------------
// iteratively Stack

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        if(root==null) return arr;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            arr.add(node.val);
            if(node.right!=null) st.push(node.right);
            if(node.left!=null) st.push(node.left);
        }
        return arr;
    }
    
}
// ---------------------------------------------------------------------------------------------------
// Recursive

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


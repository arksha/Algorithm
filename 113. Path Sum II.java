// 113. Path Sum II

// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

// For example:
// Given the below binary tree and sum = 22,
//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \    / \
//         7    2  5   1
// return
// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]


// --------------------------------------------------------------------------------------------------------------
// dfs traverse tree, add treenode into list ,when comes to leaf, add path if sum==root.val

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        dfs(res,root,sum,list);
        return res;
    }
    private void dfs(List<List<Integer>> res, TreeNode root, int sum, List<Integer> list){
        if(root==null){
            return; 
        }
        list.add(root.val);
        if(root.left==null&&root.right==null&&sum==root.val){
            res.add(new ArrayList<Integer>(list));
        }else{
            dfs(res,root.left,sum-root.val,list);
            dfs(res,root.right,sum-root.val,list);
        }
        list.remove(list.size()-1);
    }
}
            
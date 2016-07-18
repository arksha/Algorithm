// 103. Binary Tree Zigzag Level Order Traversal

// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its zigzag level order traversal as:
// [
//   [3],
//   [20,9],
//   [15,7]
// ]

// ------------------------------------------------------------------------------------------------------------------------------
// same idea as BST level order traversal. just add one more flag to show if zigzag or not
// use queue to BFS traverse 
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res  = new LinkedList<>();
        if(root ==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean zigzagflag = true;//add reversely if true; start from level 1 initialize as true
        while(!queue.isEmpty()){
            int levelnum = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i = 0;i<levelnum;i++){
                TreeNode node = queue.poll();
                if(!zigzagflag){
                    list.add(node.val);
                }else{
                    list.add(0,node.val);
                }
                if(node.right!=null)
                    queue.offer(node.right);
                if(node.left!=null)
                    queue.offer(node.left);
            }
           zigzagflag = !zigzagflag;
           res.add(list); 
        }
        return res;
    }
}
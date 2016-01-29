
/*1.recursions*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Topic: BFS, Resursion, find first leaf node 
public class Solution {
    public int minDepth(TreeNode root) {//recursion
        if(root==null) return 0;
        if(root.left==null) return minDepth(root.right)+1;
        if(root.right==null) return minDepth(root.left)+1;
        return Math.min(minDepth(root.right),minDepth(root.left))+1;
    }
}

//time complexity is O(n) ,cause travel only once

//2. use two linkedlist to implement BFS
public class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;//cornercase
        LinkedList<TreeNode> node  = new LinkedList<>();
        LinkedList<Integer> count = new LinkedList<>();//record every node's depth
        node.add(root);
        count.add(1);
        while(!node.isEmpty()){
            TreeNode cur = node.remove();
            int depth = count.remove();
            if(cur.left!=null){//left is not empty, add node to queue
                node.add(cur.left);
                count.add(depth+1);
            }
            if(cur.right!=null){//same as right
                node.add(cur.right);
                count.add(depth+1);
            }
            if(cur.left==null&&cur.right==null){//find leaf node ok to return 
                return depth;
            }
        }
        return 0;
    }
}

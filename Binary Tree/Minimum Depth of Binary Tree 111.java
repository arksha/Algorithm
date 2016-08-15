// 111. Minimum Depth of Binary Tree

// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
// ----------------------------------------------------------------------------------------------------------------
// different from maximum depth of BST, when left child is empty, go to check right child min depth.
// otherwise, if both child are not null, compare and return the minimum depth.

// find first leaf node 
public class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null) return minDepth(root.right)+1;
        if(root.right==null) return minDepth(root.left)+1;
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}

// ----------------------------------------------------------------------------------------------------------------
// use two linkedlist to implement BFS as queue
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

// updated version:
// NB: if only write root.left != null and root.right != null will be wrong

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftmin = minDepth(root.left);
        int rightmin = minDepth(root.right);
        
        if(root.left == null){
            return rightmin + 1;
        }
        if(root.right == null){
            return leftmin + 1;
        }
        return Math.min(leftmin, rightmin) + 1;
        
       
    }
   
}
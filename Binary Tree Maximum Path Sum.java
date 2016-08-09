// Binary Tree Maximum Path Sum

// Given a binary tree, find the maximum path sum.

// The path may start and end at any node in the tree.

// Example
// Given the below binary tree:

//   1
//  / \
// 2   3
// return 6.

// --------------------------------------------------------------------------------------------------------
// 1. Divide and Conquer
// 2. returntype Sumtype: root2any sum, any2any sum
// 3. root2any sum has node >=1, any2any sum has node >=1
// 4. if root is null, root2any is Integer.MIN_VALUE, so as any2any, 
// 	because value can be negative and at least path has one node. 
// 	If root2any defined as has node >=0, then initialized as 0 instead of Integer.MIN_VALUE

// NB: compare with 0 and then add root.val, otherwise overflow

class Sumtype{
    int rootany;
    int maxsum;
    public Sumtype(int rootany, int maxsum){
        this.rootany = rootany;
        this.maxsum = maxsum;
    }
}
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        return sumHelper(root).maxsum;
    }
    private Sumtype sumHelper(TreeNode root){
        if(root == null){
            return new Sumtype(Integer.MIN_VALUE,Integer.MIN_VALUE);
        }
        
        Sumtype left = sumHelper(root.left);
        Sumtype right = sumHelper(root.right);
        
        //stack overflow
        //int rootany = Math.max(left.rootany, right.rootany) + root.val;
        int rootany = Math.max(0, Math.max(left.rootany, right.rootany)) + root.val;
        
        
        int maxsum = Math.max(left.maxsum, right.maxsum);
        maxsum = Math.max(maxsum, 
                          Math.max(0, left.rootany) + 
                          Math.max(0, right.rootany) + root.val);
            
        return new Sumtype(rootany, maxsum);
        
    }
}
// 331. Verify Preorder Serialization of a Binary Tree
//1. use diff = outdegree-indegree
// 在二叉树中，如果我们将空节点视为叶子节点，那么除根节点外的非空节点（分支节点）提供2个出度和1个入度（2个孩子和1个父亲）

// 所有的空节点提供0个出度和1个入度（0个孩子和1个父亲）

// 假如我们尝试重建这棵树。在构建的过程中，记录出度与入度之差，记为diff = outdegree - indegree

// 当遍历节点时，我们令diff - 1（因为节点提供了一个入度）。如果节点非空，再令diff + 2（因为节点提供了2个出度）

// 如果序列化是正确的，那么diff在任何时刻都不会小于0，并且最终结果等于0

public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] s = preorder.split(",");
        int diff = 1;//outdegree-indegree
        for(String a: s){
            diff -=1;
            if(diff<0) return false;
            if(!a.equals("#")) diff += 2;
        }
        return diff==0;
    }
}
//2. use stack
// 将元素压入栈

// 如果当前栈的深度≥3，并且最顶端两个元素为'#', '#'，而第三个元素不为'#'，则将这三个元素弹出栈顶，然后向栈中压入一个'#'，重复此过程

// 最后判断栈中剩余元素是否只有一个'#'

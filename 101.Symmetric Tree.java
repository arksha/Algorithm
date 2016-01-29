//101. Symmetric Tree My Submissions Question
// warnning the corner case of 
//		 1
// 		2	2
//	      3    3
//1. recursion
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return dfs(root.right,root.left);
    }
    public boolean dfs(TreeNode r, TreeNode l){
        if(r==null&&l==null)
            return true;
        if(r==null||l==null)
            return false; 
        if(r.val==l.val)
            return dfs(l.left,r.right)&&dfs(l.right,r.left);
        else
            return false;
    }
}
//2. Iteration 
public class Solution {
    public boolean isSymmetric(TreeNode root) {//iterative traversal with level
        if(root == null) return true;
        LinkedList <TreeNode> l = new LinkedList<>(),//use two queue to store left subtree and right subtree
                              r = new LinkedList<>();
        l.add(root.left);
        r.add(root.right);
        while(!l.isEmpty()&&!r.isEmpty()){
            TreeNode t1 = l.poll(),
                     t2 = r.poll();
            if((t1!=null&&t2==null)||(t1==null&&t2!=null)){//may have one null subtree then it's false
                return false;
            }
            if(t1!=null&&t2!=null){
                if(t1.val!=t2.val) return false;
                l.add(t1.left);//symmetricly add the sub node like this <-   ->
                l.add(t1.right);
                r.add(t2.right);
                r.add(t2.left);
            }
        }
        return true;
    }
}
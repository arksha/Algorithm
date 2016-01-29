//100. Same Tree

//1. recursive 
//just compare left with left ,right with right
public class Solution{
	public boolean isSameTree(TreeNode p, TreeNode q){
		if(p == null && q == null) return true;
		if(p == null || q == null) return false;
		if(p.val!= q.val) return false;
		return isSameTree(p.left,q.left)&& isSameTree(p.right,q.right);
	}
}


// 173. Binary Search Tree Iterator

// 维护一个栈，从根节点开始，每次迭代地将根节点的左孩子压入栈，直到左孩子为空为止。

// 调用next()方法时，弹出栈顶，如果被弹出的元素拥有右孩子，则以右孩子为根，将其左孩子迭代压栈。

//inorder O(Treesize) is not a requiement of O(1) time and uses O(h) memory of next() and hasNext()

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    Stack<TreeNode> st = new Stack<TreeNode>();//store small element 
    public BSTIterator(TreeNode root) {
        while(root!=null){
            st.push(root);//push root and turn to root.left
            root = root.left;
            
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();//stack is empty
    }

    /** @return the next smallest number */
    public int next() {
        
            TreeNode temp = st.pop();
            if(temp.right!=null)
            {
                TreeNode root = temp.right;//if has right node, let it be root
                 while(root!=null)
                 {
                   st.push(root);//keep push root and go left
                   root = root.left;
                }
            }
            return temp.val;
       
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
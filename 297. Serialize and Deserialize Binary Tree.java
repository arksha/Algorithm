//297. Serialize and Deserialize Binary Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {//preorder
        StringBuilder sb = new StringBuilder();
        preorder(root,sb);
        return sb.toString();
    }
    public void preorder(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("#");
            sb.append(",");
            return;
        } 
        sb.append(root.val+",");
        preorder(root.left,sb);
        preorder(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null||data.length()==0) return null;
        String[] s = data.split(",");
        
        Queue<String> q = new LinkedList<>();
        for(int i = 0;i<s.length;i++){
            q.add(s[i]);
        }
        
        return deserializetrav(q);
         
    }
    public TreeNode deserializetrav(Queue<String> q){
                String t = q.poll();
                if(t.equals("#"))
                    return null;
                else{
                    TreeNode root = new TreeNode(Integer.valueOf(t));
                    root.left = deserializetrav(q);
                    root.right= deserializetrav(q);
                    return root;
                }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
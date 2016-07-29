// 109. Convert Sorted List to Binary Search Tree 

// Difficulty: Medium
// Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.


// --------------------------------------------------------------------------------------------------------------
// recursion,
// NB: remember fast node has to be head.next to move one more step, other wise will move too much.

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        ListNode slow = head, fast = head.next, pre = null;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        if(pre!=null){
            pre.next = null;
        }else{
            head = null;
        }
        TreeNode root = new TreeNode (slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
        
    }
   
}
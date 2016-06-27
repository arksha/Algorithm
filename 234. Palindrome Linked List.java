// 234. Palindrome Linked List

// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) { val = x; }
//  * }
//  */
// ----------------------------------------------------------------------------------------------------------------------------
// find mid node and reverse last part of linklist,
// compare from two till the midnode is null and return midnode==null
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next==null) return true;
        
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if(fast!=null) slow = slow.next;
        slow = reverse(slow);
        
        while(slow!=null && head.val==slow.val ) {
            slow = slow.next;
            head = head.next;
        }
        return slow==null;
    }
    public ListNode reverse(ListNode head){
        ListNode newhead = null;
        while(head!=null){
            ListNode cur = head.next;
            head.next = newhead;
            newhead = head;
            head = cur;
        }
        return newhead;
    }
    
}

// -------------------------------------------------------------------------------------------------------------------------------
// new another reverse list and compare O(n)
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null||head.next == null)
            return true;
            
        ListNode cur = head;
        ListNode pre = new ListNode(head.val);
        while(cur.next!= null){
            ListNode temp = new ListNode (cur.next.val);
            temp.next = pre;
            pre = temp;
            cur = cur.next;
        }
        ListNode p = head;
        ListNode q = pre;
        while(p!=null){
            if(p.val!=q.val)
                return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }
    
}
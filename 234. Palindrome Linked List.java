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
// new another reverse list and compare O(n), O(n)
// NB: careful this idea, don't reverse the original linklist, create a new one to compare
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

// update with a new version, seperate the reverse function
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        //reverse whole linklist and compare
        ListNode reversehead = reverse(head);
        while(reversehead!=null){
            if(reversehead.val!=head.val) return false;
            reversehead = reversehead.next;
            head = head.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        if(head==null) return null;
        ListNode reversehead = new ListNode(head.val);
        ListNode cur  = head;
        while(cur.next!=null){
            ListNode temp = new ListNode(cur.next.val);
            temp.next = reversehead;
            reversehead = temp;
            cur = cur.next;
        }
        return reversehead;
    }
}
// 206. Reverse Linked List

// Reverse a singly linked list.

// click to show more hints.

// Hint:
// A linked list can be reversed either iteratively or recursively. Could you implement both?

// -------------------------------------------------------------------------------------------------------------------
// Iterative 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode newHead = null;
        while(head!=null){
            ListNode cur = head.next;
            head.next = newHead;
            newHead = head;
            head = cur;
        }
        return newHead;
    }
}


// -----------------------------------------------------------------------------------------------------------------------
// recursively
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode rest = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }
}
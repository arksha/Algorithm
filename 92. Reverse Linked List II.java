// 92. Reverse Linked List II  

// Difficulty: Medium
// Reverse a linked list from position m to n. Do it in-place and in one-pass.

// For example:
// Given 1->2->3->4->5->NULL, m = 2 and n = 4,

// return 1->4->3->2->5->NULL.

// Note:
// Given m, n satisfy the following condition:
// 1 ≤ m ≤ n ≤ length of list.

// ------------------------------------------------------------------------------------------------------------------
// find pre m, reverse from m to n , use second for loop 
// NB: remind second for loop's logic to reverse 


public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null) return head;
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode pre = fake;
        for(int i = 0;i<m-1;i++){
            pre = pre.next;
        }
        ListNode cur =  pre.next, post = cur.next;
        for(int i = m;i<n;i++){
            cur.next = post.next;
            post.next = pre.next;
            pre.next = post;
            post = cur.next;
        }
        return fake.next;
    }
}
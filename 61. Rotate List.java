// 61. Rotate List


// Given a list, rotate the list to the right by k places, where k is non-negative.

// For example:
// Given 1->2->3->4->5->NULL and k = 2,
// return 4->5->1->2->3->NULL.

// --------------------------------------------------------------------------------------------------------------
// one pointer, connect tail and head, count len-k to cut circle
// count len with one loop.
// use p to move to cut place (is the place before cut)
// return newhead is the next position of pointer.
// consider null and only one element case

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next==null)return head;
        
        ListNode p = head;
        int len = 1;
        for(int i = 0;p.next!=null;i++){
            p = p.next;
            len++;
        }
        k %= len;
        p.next = head;
        for(int i = 0;i<len - k;i++){
            p = p.next;
        }
        
        ListNode newhead = p.next;
        p.next = null;
        return newhead;
    }
}
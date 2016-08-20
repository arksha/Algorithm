// 19. Remove Nth Node From End of List

// Given a linked list, remove the nth node from the end of list and return its head.

// For example,

//    Given linked list: 1->2->3->4->5, and n = 2.

//    After removing the second node from the end, the linked list becomes 1->2->3->5.

// Note:
// Given n will always be valid.
// Try to do this in one pass.


// two pointers,
// make a fast pointer to move n, and move slow and fast pointer together to the end

// handle case of null list 
// use fakehead to handle only one element and delete the one node case

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        ListNode fakehead = new ListNode(0);
        fakehead.next = head;
        ListNode fast = fakehead;
        ListNode slow = fakehead;
        for(int i = 0;i<n;i++){
            fast = fast.next;
        }
        
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return fakehead.next;
    }
}
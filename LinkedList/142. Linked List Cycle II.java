// 142. Linked List Cycle II

// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

// Note: Do not modify the linked list.

// Follow up:
// Can you solve it without using extra space?

// ----------------------------------------------------------------------------------------------------------------
// two pointers 
// fast and slow  different pace to find cycle, 
// if meet, means has cycle,
// let fast go from head, same pace as slow, 
// the meet place again, is the entrance.

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                fast = head;
                while(slow!=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}

// 203. Remove Linked List Elements.java

// Remove all elements from a linked list of integers that have value val.

// Example
// Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
// Return: 1 --> 2 --> 3 --> 4 --> 5

// -----------------------------------------------------------------------------------------------------------------
// my approach: simply go over the linkedlist, take care of first one using fakehead and last one using condition of next next is null.

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fake  = new ListNode(0);
        fake.next = head;
        
        ListNode p = fake;
        while(p.next!=null){
            if(p.next.val==val){
                if(p.next.next!=null)
                    p.next = p.next.next;
                else
                    p.next = null;
            }else{
                p = p.next;
            }
        }
        return fake.next;
    }
}

// -----------------------------------------------------------------------------------------------------------------------
// three line recursion, check first node every time 

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;    
    }
}
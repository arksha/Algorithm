// 83. Remove Duplicates from Sorted List

// Given a sorted linked list, delete all duplicates such that each element appear only once.

// For example,
// Given 1->1->2, return 1->2.
// Given 1->1->2->3->3, return 1->2->3.

// ----------------------------------------------------------------------------------------------------------------
// staight approach: fake head, check p and p.next, if equal delete, else move p

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode p = head;
        while(p!=null&&p.next!=null){
            if(p.val==p.next.val){
                if(p.next.next!=null){
                    p.next = p.next.next;
                }else{
                    p.next = null;
                }
            }else{
                p = p.next;
            }
        }
        return fake.next;
    }
}

// ----------------------------------------------------------------------------------------------------------------
// recursion way
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        head.next = deleteDuplicates(head.next);
        return head = head.val == head.next.val? head.next: head;
    }
}
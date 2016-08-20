// 82. Remove Duplicates from Sorted List II  

// Difficulty: Medium
// Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

// For example,
// Given 1->2->3->3->4->4->5, return 1->2->5.
// Given 1->1->1->2->3, return 2->3.
// ------------------------------------------------------------------------------------------------------
// NB: when to end of the loop and make sure end node and next is not empty
// use start.next== end ,to see if has duplicate

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode start = fake, end = head;
        while(end.next!=null){
            while(end.val==end.next.val){
                end = end.next;
            }
            if(start.next!= end){
                start.next = end.next;
            }else{
                start = start.next;
            }
            end = end.next;
           
        }
        return fake.next;
    }
}
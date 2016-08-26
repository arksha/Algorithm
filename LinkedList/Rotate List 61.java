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
------------------------------------------------------------------------------------------
 a not so smart way
 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        //corner case
        if(head == null || head.next == null){
            return head;
        }
        ListNode fake = new ListNode(0);
        fake.next = head;
        //count len
        ListNode p = head;
        int len = 0;
        while(p != null){
            p = p.next;
            len ++;
        }
        k %= len;
        //count k 
        p = fake;
        for(int i = 0; i < k; i++){
            p = p.next;
        }
        ListNode tail = fake;
        while(p.next != null){
            tail = tail.next;
            p = p.next;
        }
        //reverse and contcate
        p.next = fake.next;
        fake.next = tail.next;
        tail.next = null;
        
        return fake.next;
    }
}

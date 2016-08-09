// 24. Swap Nodes in Pairs  

// Difficulty: Easy
// Given a linked list, swap every two adjacent nodes and return its head.

// For example,
// Given 1->2->3->4, you should return the list as 2->1->4->3.

// Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

// ------------------------------------------------------------------------------------
// fake   head
//   0  ,  1,   2,   3,  4,  5
//  cur 
//         fst  sec 

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode cur = fake;
        while(cur.next!=null&&cur.next.next!=null){
                ListNode first = cur.next, second = cur.next.next;
                first.next = second.next;
                cur.next = second;
                second.next = first;
                cur  = first;
        } 
        return fake.next;
    }
}

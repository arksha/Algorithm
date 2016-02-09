// 25. Reverse Nodes in k-Group

// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

// If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

// You may not alter the values in the nodes, only nodes itself may be changed.

// Only constant memory is allowed.

// For example,
// Given this linked list: 1->2->3->4->5

// For k = 2, you should return: 2->1->4->3->5

// For k = 3, you should return: 3->2->1->4->5

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k<=1) return head;
        ListNode fake = new ListNode(0);
        fake.next = head;
        head = fake;
        while(head.next!=null){
            head = reverse(head,k);
        }
        return fake.next;
    }
    public ListNode reverse(ListNode head, int k){
        ListNode nt = head;
        for(int i = 0;i<k;i++){//check if is enough to reverse
            if(nt.next==null)
                return nt;
            nt = nt.next;
        }
        
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode n = cur;
        for(int i = 0;i<k;i++){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        n.next = cur;
        head.next = pre;
        return n;
    }
}
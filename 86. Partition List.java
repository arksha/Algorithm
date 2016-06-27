// 86. Partition List

// Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

// You should preserve the original relative order of the nodes in each of the two partitions.

// For example,
// Given 1->4->3->2->5->2 and x = 3,
// return 1->2->2->4->3->5.

// ---------------------------------------------------------------------------------------------------------------------------------
// two pointers,
// get two fake heads for small part and big part
// make head as iterator pointer

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode smallp = small, bigp = big;
        while(head!=null){
            if(head.val<x){
                smallp.next = head;
                smallp = head;
            }else{
                bigp.next = head;
                bigp = head;
            }
            head = head.next;
        }
        smallp.next = big.next;
        bigp.next = null;  //important! avoid cycle in linked list. otherwise u will get TLE.
        return small.next;
    }
}
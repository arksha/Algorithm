// 143. Reorder List 

// Difficulty: Medium
// Given a singly linked list L: L0→L1→…→Ln-1→Ln,
// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

// You must do this in-place without altering the nodes' values.

// For example,
// Given {1,2,3,4}, reorder it to {1,4,2,3}.
// -------------------------------------------------------------------------------------------

// find mid , reverse , getpair

// NB: reverse the next node of mid, find mid is to find premid, use a flag when switch two list in getpair
public class Solution {
    public void reorderList(ListNode head) {
        if(head==null||head.next == null) return;
        ListNode mid = findmid(head);
        ListNode tail = reverse(mid.next);
        mid.next = null;
        getpair(head,tail);
    }
    ListNode findmid(ListNode head){
        ListNode slow = head, fast = head.next;
        while(fast!=null&&fast.next!=null){
            slow =  slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    ListNode reverse(ListNode head){
        ListNode reversehead = null;
        while(head!=null){
            ListNode nt = head.next;
            head.next = reversehead;
            reversehead = head;
            head = nt;
        }
        return reversehead;
    }
    void getpair(ListNode head, ListNode mid){
        ListNode fake = new ListNode(0);
        ListNode l = fake;
        boolean isheadflag = true;
        while(head!=null&&mid!=null){
            if(isheadflag){
                l.next = head;
                head = head.next;
            }else{
                l.next = mid;
                mid = mid.next;
            }
            l = l.next;
            isheadflag = !isheadflag;
        }
        if(head!=null){ l.next = head;}
        if(mid!=null) {l.next = mid;}
    }
}
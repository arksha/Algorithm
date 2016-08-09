// 25. Reverse Nodes in k-Group

// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

// If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

// You may not alter the values in the nodes, only nodes itself may be changed.

// Only constant memory is allowed.

// For example,
// Given this linked list: 1->2->3->4->5

// For k = 2, you should return: 2->1->4->3->5

// For k = 3, you should return: 3->2->1->4->5

// ------------------------------------------------------------------------------------------------
// get reverse by counting k, then reverse every head of the list

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


// --------------------------------------------------------------------------------------------------------------------
// Updated: 
// make sure to reverse a list from begin to end, then go through the whole list.
// If has k nodes, it's time to reverse, and go to next loop to reverse.

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k==1||head==null||head.next==null) return head;
        ListNode fake = new ListNode(0);
        ListNode begin = fake;//record start of reverse
        fake.next = head;
        int len = 0;
        while(head!=null){//yes, use head as moving pointer
            len++;
            if(len%k==0){//it's time to reverse
                begin = reverse(begin, head.next);// range of reverse need to know clearly
                head = begin.next;
            }else{
                head = head.next;
            }
        }
        return fake.next;
    }
    ListNode reverse(ListNode begin, ListNode end){
        ListNode cur = begin.next;
        ListNode pre = begin;
        ListNode post, first;
        first = cur;
        while(cur!=end){
            post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        begin.next = pre;
        first.next = cur;//did not get where is the first
        return first;
    }
}
// 148. Sort List  
// Difficulty: Medium
// Sort a linked list in O(n log n) time using constant space complexity.

// --------------------------------------------------------------------------------------------------------------
// merge sort

public class Solution {
    private ListNode merge(ListNode a, ListNode b){
        ListNode l = new ListNode(0), p = l;
        while(a!=null&&b!=null){
            if(a.val<=b.val){
                p.next = a;
                a = a.next;
            }else{
                p.next = b;
                b = b.next;
            }
            p = p.next;
        }
        if(a!=null) p.next = a;
        if(b!=null) p.next = b;
        
        return l.next;
    }    
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode slow = head, fast = head.next;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        
        ListNode a = sortList(head);
        ListNode b = sortList(mid);
        
        return merge(a,b);
    
    }
}


// ---------------------------------------------------------------------------------------------------
// quick sort

public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        //find mid O(n)
        ListNode mid = findmid(head);
        //split into three part
        ListNode leftfake = new ListNode(0), lp = leftfake;
        ListNode rightfake = new ListNode(0), rp = rightfake;
        ListNode midfake = new ListNode(0), mp = midfake;
        //put pivot 
        while(head!=null){
            if(head.val<mid.val){
                lp.next = head;
                lp = head;
            }else if(head.val>mid.val){
                rp.next = head;
                rp = head;
            }else{
                mp.next = head;
                mp = head;
            }
            head = head.next;
        }
        //cut into three
        lp.next = null;
        rp.next = null;
        mp.next = null;
        //sort left and right part
        ListNode l = sortList(leftfake.next);
        ListNode r = sortList(rightfake.next);
        // concat three into one, NB: do not get fake node to sort
        return concat(l, midfake.next, r);
        
    }
    ListNode findmid(ListNode head){
        ListNode slow = head, fast = head.next;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    ListNode concat(ListNode left, ListNode mid, ListNode right){
        ListNode l = new ListNode(0), p = l;
        p.next = left;
        p = getlast(p);
        p.next = mid;
        p = getlast(p);
        p.next = right;
        p = getlast(p);
        return l.next;
    }
    //go to the last node in list
    ListNode getlast(ListNode head){
        if(head==null) return head;
        while(head.next!=null){
            head = head.next;
        }
        return head;
    }
}
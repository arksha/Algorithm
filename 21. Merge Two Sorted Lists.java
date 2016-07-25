// 21. Merge Two Sorted Lists  

// Difficulty: Easy

// Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

// --------------------------------------------------------------------------------------------------------------
// simply just choose smaller node and added into new listnode
// NB: fakenode , null case, diff length case

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        ListNode fake = new ListNode(0);
        ListNode head = fake;
        while(p!=null||q!=null){
            if(p==null){
                while(q!=null){
                    ListNode cur  = new ListNode(q.val);
                    head.next = cur;
                    head = cur;
                    q = q.next;
                }
                break;    
            }else if(q==null){
                while(p!=null){
                    ListNode cur  = new ListNode(p.val);
                    head.next = cur;
                    head = cur;
                    p = p.next;
                } 
                break;
            }else{
                if(p.val<=q.val){
                    ListNode cur  = new ListNode(p.val);
                    head.next = cur;
                    head = cur;
                    p = p.next;        
                }else{
                    ListNode cur  = new ListNode(q.val);
                    head.next = cur;
                    head = cur;
                    q = q.next;
                }
            }
        }
        return fake.next;
    }
}
// ---------------------------------------------------------------------------------------------------------
// without extra space and do it in recursion
// just move the pointer of next is ok , no need to new ListNode
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode mergenode;
        if(l1.val<l2.val){
            mergenode = l1;
            mergenode.next = mergeTwoLists(l1.next,l2);
        }else{
            mergenode = l2;
            mergenode.next = mergeTwoLists(l1,l2.next);
        }
        return mergenode;
    }
}
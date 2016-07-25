// 160. Intersection of Two Linked Lists


// Write a program to find the node at which the intersection of two singly linked lists begins.


// For example, the following two linked lists:

// A:          a1 → a2
//                    ↘
//                      c1 → c2 → c3
//                    ↗            
// B:     b1 → b2 → b3
// begin to intersect at node c1.


// Notes:

// If the two linked lists have no intersection at all, return null.
// The linked lists must retain their original structure after the function returns.
// You may assume there are no cycles anywhere in the entire linked structure.
// Your code should preferably run in O(n) time and use only O(1) memory.

// --------------------------------------------------------------------------------------------------------------
// my approach: calculate length, then move out diff , and compare O(m+n) O(1)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null&&headB==null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        int lena = 0, lenb = 0;
        while(a!=null){
            a = a.next;
            lena++;
        }
        while(b!=null){
            b = b.next;
            lenb++;
        }
        a = headA;
        b = headB;
        if(lena>lenb){
            while(lena-lenb>0){
                a = a.next;
                lena--;
            }
        }else if(lenb>lena){
            while(lenb-lena>0){
                b = b.next;
                lenb--;
            }
        }
        while(a!=null&&b!=null){
            if(a.val==b.val) return a;
            a = a.next;
            b = b.next;
        }
        return null;
        
    }
}


// ---------------------------------------------------------------------------------------------------------
// a more smart idea, O(n) O(1)
// use a small eg to think, every time a or b meet end, jump to another list head, then between a and b is the diff of both list.
// then go second loop, this time a and be must have same length from current position to list end.

// 1,2,3,4,5
// 3,4,5
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null&&headB==null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while(a!=b){
            a = a==null? headB: a.next;
            b = b==null? headA: b.next;
        }
        return a;
    }
}


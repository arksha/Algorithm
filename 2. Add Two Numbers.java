// 2. Add Two Numbers  

// Difficulty: Medium
// You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8


// --------------------------------------------------------------------------------------------------
// just as array , use carry to represent digit and carry
// loop as long as has one nonempty and if carry is not 0
// NB: update carry after attach a new node and then move p to the tail of list

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode fake = new ListNode(0), p = fake;
        int carry = 0;
        while(l1!=null||l2!=null||carry !=0){
            if(l1!=null){
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                carry +=l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry%10);
            carry /=10;
            p = p.next;
            
        }
        
        return fake.next;
    }
   
}
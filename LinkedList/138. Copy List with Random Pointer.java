138. Copy List with Random Pointer 

Difficulty: Hard
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

----------------------------------------------------------------------------------------
a b c
a a2 b b2 c c2

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
     public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null){
            return null;
        }
        RandomListNode n = head;
        while (n!=null){
            RandomListNode n2 = new RandomListNode(n.label);
            RandomListNode tmp = n.next;
            n.next = n2;
            n2.next = tmp;
            n = tmp;
        }
        
        n=head;
        while(n != null){
            RandomListNode n2 = n.next;
            if(n.random != null)
                n2.random = n.random.next;
            else
                n2.random = null;
            n = n.next.next;
        }
        
        //detach list
        RandomListNode n2 = head.next;
        n = head;
        RandomListNode head2 = head.next;
        while(n2 != null && n != null){
            n.next = n.next.next;
            if (n2.next == null){
                break;
            }
            n2.next = n2.next.next;
            
            n2 = n2.next;
            n = n.next;
        }
        return head2;
        
    }
}

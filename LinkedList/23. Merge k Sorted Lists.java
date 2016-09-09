23. Merge k Sorted Lists.java


//two by two
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {//merge two by two
        if(lists==null||lists.length==0) return null;
        List<ListNode> Listtemp = new ArrayList<ListNode>();
        for(int i = 0;i<lists.length;i++){
            Listtemp.add(lists[i]);
        }
        while(Listtemp.size()>1){//form a half lists[] after every merge round
            List<ListNode> newlist = new ArrayList<ListNode>();
            
            for(int i = 0;i<Listtemp.size()-1;i +=2){
                ListNode merged = merge(Listtemp.get(i),Listtemp.get(i+1));
                newlist.add(merged);
            }
            if(Listtemp.size() %2 == 1){
                newlist.add(Listtemp.get(Listtemp.size()-1));//add the lonnely one
            }
            Listtemp = newlist;
            
        }
        return Listtemp.get(0);
    }
    private ListNode merge(ListNode a, ListNode b){
        ListNode fake = new ListNode(0);
        ListNode cur = fake;
        while(a!=null&&b!=null){
            if(a.val<b.val){
                cur.next = a;
                a = a.next;
            }else{
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        if(a!=null){
            cur.next = a;
        }else{
            cur.next = b;
        }
        return fake.next;
    }
}

//2. heap

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        PriorityQueue<ListNode> minheap = new PriorityQueue(lists.length,
            new Comparator<ListNode>(){
                public int compare(ListNode a,ListNode b){
                    if(a.val > b.val)
                        return 1;
                    if(b.val>a.val)
                        return -1;
                    else
                        return 0;
                    
                }
            }
        );
        for(ListNode list :lists){
            if(list!=null)
                minheap.add(list);
        }
        ListNode fake = new ListNode (0);
        ListNode pointer = fake;
        while(minheap.size()>0){
            ListNode temp = minheap.poll();
            pointer.next = temp;
            if(temp.next!=null)
                minheap.add(temp.next);
            pointer = pointer.next;
        }
    return fake.next;
    }
}

//3. Divide and conquer
//This is a pretty easy way to do this, first choice 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }    
        return mergeHelper(lists, 0, lists.length - 1);
    }
    private ListNode mergeHelper(ListNode[] lists, int start, int end){
        if(start == end){
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergetwo(left, right);
    }
    private ListNode mergetwo(ListNode A, ListNode B){
        if(A == null && B == null){
            return null;
        }
        ListNode fake = new ListNode(0);
        ListNode p = fake;
        while(A != null && B != null){
            if(A.val <= B.val){
                p.next = A;
                A = A.next;
            }else{
                p.next = B;
                B = B.next;
            }
            p = p.next;
        }
        if(A != null){
            p.next = A;
        }
        if(B != null){
            p.next = B;
        }
        return fake.next;
    }
}

// 281. Zigzag Iterator

// Given two 1d vectors, implement an iterator to return their elements alternately.

// For example, given two 1d vectors:

// v1 = [1, 2]
// v2 = [3, 4, 5, 6]
// By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

// Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

// Clarification for the follow up question - Update (2015-09-18):
// The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

// [1,2,3]
// [4,5,6,7]
// [8,9]
// It should return [1,4,8,2,5,9,3,6,7].

//1.use two iterators and a int change to determin which vector to choose
public class ZigzagIterator {
    private Iterator<Integer> it1;
    private Iterator<Integer> it2;
    private int change;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.it1 = v1.iterator();
        this.it2 = v2.iterator();
        change = 0;
    }

    public int next() {
        if(!this.hasNext()) return 0;
        else{
            change++;
            if((change %2 ==1 && it1.hasNext())||!it2.hasNext()){
                return it1.next();
            }
            else if(change%2==0&&it2.hasNext()||!it1.hasNext()){
                return it2.next();
            }
        
        }
        return 0;   
            
    }

    public boolean hasNext() {
        return it1.hasNext()||it2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */


 //2. follow up
//follow up ,with k lists
//O(N) O(1)
//when we finish an iterator, should remove from "it", and respectively parameter change should back to last positon.
public class ZigzagIterator {
    
    private List<Iterator<Integer>> it;
    private int change;
    public ZigzagIterator(List<Iterator<Integer>> list) {
        this.it = new LinkedList<Iterator<Integer>>();
        for(Iterator<Integer> i: list){
            if(i.hasNext()) it.add(i);
        }
        change = 0;
    }

    public int next() {
        if(!it.hasNext()) return 0;
        int res = 0;
        int pos = change % it.size();//get which list are we in for now
        Iterator<Integer> cur = it.get(pos);
        res = cur.next();
        if(!cur.hasNext()){
            it.remove(pos);
            change = pos-1;
        }
        change++;
        return res;
    }

    public boolean hasNext() {
        return it.size()>0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
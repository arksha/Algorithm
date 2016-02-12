// 251. Flatten 2D Vector.java

// Implement an iterator to flatten a 2d vector.

// For example,
// Given 2d vector =

// [
//   [1,2],
//   [3],
//   [4,5,6]
// ]
// By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

// Hint:

// How many variables do you need to keep track?
// Two variables is all you need. Try with x and y.
// Beware of empty rows. It could be the first few rows.
// To write correct code, think about the invariant to maintain. What is it?
// The invariant is x and y must always point to a valid point in the 2d vector. Should you maintain your invariant ahead of time or right when you need it?
// Not sure? Think about how you would implement hasNext(). Which is more complex?
// Common logic in two different places should be refactored into a common method.

// Follow up:
// As an added challenge, try to code it using only iterators in C++ or iterators in Java.

// Show Company Tags
// Show Tags
// Show Similar Problems

//1.two variables
public class Vector2D {
    private int i;//rows
    private int j;//col
    List<List<Integer>> vec2d;
    private int len;//number of rows
    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        i = 0;
        j = 0;
        len = vec2d.size();
    }

    public int next() {
        int ans= 0;
        if(i<len&&j<vec2d.get(i).size()){
            ans =  vec2d.get(i).get(j);
        }
        j++;
        if(i<len&&j==vec2d.get(i).size()){
            j = 0;
            i++;
        }
        return ans;
    }

    public boolean hasNext() {
        //has empty, go to next vector
        while(i<len&&(vec2d.get(i)==null||vec2d.get(i).isEmpty())){
            i++;
        }
        //vec is empty 
        return vec2d != null&& !vec2d.isEmpty() && i<len;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */

 //2.follow up : use Iterator
//
public class Vector2D {
    private Iterator<List<Integer>> i;//out iterator
    private Iterator<Integer> j;//inner iterator
    public Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
        j = Collections.emptyIterator();//avoid empty vec2d
    }

    public int next() {
        return j.next();
    }

    public boolean hasNext() {
        if(j.hasNext()) return true;
        if(!i.hasNext()) return false;
        j = i.next().iterator();//has next row , goto next row's first
        while(!j.hasNext()&&i.hasNext()){//end row or empty row, goto next row
            j = i.next().iterator();
        }
        return j.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
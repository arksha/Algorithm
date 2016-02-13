//284. Peeking Iterator.java
// Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

// Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

// Call next() gets you 1, the first element in the list.

// Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

// You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.

// Hint:

// Think of "looking ahead". You want to cache the next element.
// Is one variable sufficient? Why or why not?
// Test your design with call order of peek() before next() vs next() before peek().
// For a clean implementation, check out Google's guava library source code.
// Follow up: How would you extend your design to be generic and work with all types, not just integer?



// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private boolean haspeek = false;//whether there is a next element boolean
    private Iterator<Integer> iter;//iterator
    private Integer nextele = null;//cache to store next element
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iter = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(!haspeek){
            nextele = iter.next();
            haspeek = true;
        }
        return nextele;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(!haspeek){
	        return iter.next();
	    }
	    haspeek = false;
	    Integer result = nextele;
	    nextele = null;
	    return result;
	}

	@Override
	public boolean hasNext() {
	    return haspeek||iter.hasNext();
	}
}

//A more consice version
//为了能peek后下次next还得到同样的数字，我们要用一个缓存保存下一个数字。这样当peek时候，返回缓存就行了，迭代器位置也不会变。
//当next的时候除了要返回缓存，还要将缓存更新为下一个数字，如果没有下一个就将缓存更新为null。

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
        Integer cache = null;
        Iterator<Integer> it;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.it = iterator;
	    cache = it.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return cache;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int ret = cache;
	    if(it.hasNext()){
	        cache = it.next();
	    }else{
	        cache = null;
	    }
	    return ret;
	}

	@Override
	public boolean hasNext() {
	    return (cache!=null);
	}
}

//follow up: use Java Generic

class PeekingIterator<T> implements Iterator<T> {

    T cache;
    Iterator<T> it;

    public PeekingIterator(Iterator<T> iterator) {
        // initialize any member here.
        this.cache = iterator.next();
        this.it = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public T peek() {
        return cache;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public T next() {
        T res = cache;
        cache = it.hasNext() ? it.next() : null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return it.hasNext() || cache != null;
    }
}
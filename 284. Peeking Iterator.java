284. Peeking Iterator

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private boolean haspeek = false;
    private Iterator<Integer> iter;
    private Integer nextele = null;
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
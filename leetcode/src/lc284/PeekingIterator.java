package lc284;

import java.util.*;

class PeekingIterator implements Iterator<Integer> {
	private Iterator<Integer> iterator;
	private Integer cur;
	private boolean hasPeeked = false;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (hasNext()) {
			if (!hasPeeked) {
				cur = this.iterator.next();
				hasPeeked = true;
			}
			return cur;
		} else {
			return null;
		}
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (hasPeeked) {
			hasPeeked = false;
			return cur;
		} else {
			return iterator.next();
		}
	}

	@Override
	public boolean hasNext() {
		return (hasPeeked || iterator.hasNext());
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		PeekingIterator peekingIterator = new PeekingIterator(list.iterator());
		System.out.println(peekingIterator.peek());
		System.out.println(peekingIterator.hasNext());
		System.out.println(peekingIterator.next());
		System.out.println(peekingIterator.next());
		System.out.println(peekingIterator.peek());
		System.out.println(peekingIterator.peek());
		System.out.println(peekingIterator.next());
		System.out.println(peekingIterator.peek());
		System.out.println(peekingIterator.peek());
		System.out.println(peekingIterator.next());
		System.out.println(peekingIterator.hasNext());
		System.out.println(peekingIterator.next());
	}
}

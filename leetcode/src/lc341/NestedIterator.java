package lc341;

import java.util.*;


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a
	// nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}
 
public class NestedIterator implements Iterator<Integer> {

	private List<NestedInteger> nestedList;
	private List<Integer> list = new ArrayList<Integer>();
	private Iterator<Integer> iterator;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        visit(nestedList);
        iterator = list.iterator();
    }
    
    private void visit(List<NestedInteger> nestedList) {
    	if (nestedList == null) return;
    	for (NestedInteger nestedInteger : nestedList) {
    		if (nestedInteger.isInteger()) {
    			list.add(nestedInteger.getInteger());
    		} else {
    			visit(nestedInteger.getList());
    		}
    	}
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
package lc385;

import java.util.*;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface INestedInteger {
	// Constructor initializes an empty nested list.
//	public NestedInteger();

	// Constructor initializes a single integer.
//	public NestedInteger(int value);

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// Set this NestedInteger to hold a single integer.
	public void setInteger(int value);

	// Set this NestedInteger to hold a nested list and adds a nested integer to
	// it.
	public void add(NestedInteger ni);

	// @return the nested list that this NestedInteger holds, if it holds a
	// nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

class NestedInteger implements INestedInteger {
	public NestedInteger(){};

	// Constructor initializes a single integer.
	public NestedInteger(int value){};
	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger(){return true;};

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger(){return 1;};

	// Set this NestedInteger to hold a single integer.
	public void setInteger(int value){};

	// Set this NestedInteger to hold a nested list and adds a nested integer to
	// it.
	public void add(NestedInteger ni){};

	// @return the nested list that this NestedInteger holds, if it holds a
	// nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList(){return null;};
}

public class Solution {

	private int step;
	public NestedInteger deserialize(String s) {
		if (s == null) return null;
		char[] cs = s.toCharArray();
		NestedInteger nestedInteger = new NestedInteger();
		step = 0;
		doParse(cs, nestedInteger);
		return nestedInteger;
	}
	
	private void doParse(char[] cs, NestedInteger nestedInteger) {
		if ((cs[step] >= '0' && cs[step] <= '9') || cs[step] == '-') {
			int a = 0;
			boolean isNeg = false;
			if (cs[step] == '-') {
				isNeg = true;
				step++;
			}
			while (step < cs.length && cs[step] >= '0' && cs[step] <= '9') {
				a = a*10+(cs[step++]-'0');
			}
			nestedInteger.setInteger(isNeg?-a:a);
		} else {
			step++;
			while (cs[step] != ']') {
				NestedInteger cur = new NestedInteger();
				doParse(cs, cur);
				nestedInteger.add(cur);
				if (cs[step] == ',') step++;
			}
			step++;
		}
	}

	public static void main(String[] args) {
	}
}
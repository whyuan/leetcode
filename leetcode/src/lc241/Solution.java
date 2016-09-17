package lc241;

import java.util.*;
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
	List<Integer> result = new ArrayList<Integer>();
	if (input == null || input.equals("")) return result;
	if (!(input.contains("+") || input.contains("-") || input.contains("*"))) {
	    int a = Integer.parseInt(input);
	    result.add(a);
	}
	for (int i = 0; i < input.length(); i++) {
	    if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
		List<Integer> list0 = diffWaysToCompute(input.substring(0, i));
		List<Integer> list1 = diffWaysToCompute(input.substring(i+1, input.length()));
		for (int j = 0; j < list0.size(); j++) {
	            for (int k = 0; k < list1.size(); k++) {
			if (input.charAt(i) == '+') {
			    result.add(list0.get(j)+list1.get(k));
			} else if (input.charAt(i) == '-') {
			    result.add(list0.get(j)-list1.get(k));
			} else {
			    result.add(list0.get(j)*list1.get(k));
			}
		    }
		}
	    }
	}
	return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

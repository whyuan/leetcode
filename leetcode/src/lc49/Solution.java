package lc49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> result = new ArrayList<List<String>>();
    	HashMap<String,Integer> map = new HashMap<String,Integer>();
    	String s;
    	for (int i = 0; i < strs.length; i++) {
    		s = strs[i];
    		char[] cs = s.toCharArray();
    		Arrays.sort(cs);
    		String scs = String.valueOf(cs);
    		if (map.containsKey(scs)) {
    			int index = map.get(scs);
    			result.get(index).add(s);
    		} else {
    			map.put(scs, result.size());
    			List<String> arrayList = new ArrayList<String>();
    			arrayList.add(s);
    			result.add(arrayList);
    		}
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.groupAnagrams(new String[]{"eat", "aet", "n", "a"}));
    	System.out.println(solution.groupAnagrams(new String[]{}));
    }
}

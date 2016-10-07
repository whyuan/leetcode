package lc401;

import java.util.*;

public class Solution {

    public List<String> readBinaryWatch(int num) {
    	List<String> res = new ArrayList<String>();
    	for (int h = 0; h < 12; h++) {
    		for (int m = 0; m < 60; m++) {
    			if (Integer.bitCount(h<<6|m) == num) {
    				if (m < 10) {
    					res.add(h+":0"+m);
    				} else {
    					res.add(h+":"+m);
    				}
    			}
    		}
    	}
    	return res;
    }

    public List<String> readBinaryWatch1(int num) {
    	List<Integer>[] count0 = new List[4];
    	List<Integer>[] count1 = new List[6];
    	for (int i = 0; i < 12; i++) {
    		int a = bits(i);
    		if (count0[a] == null) {
    			count0[a] = new ArrayList<Integer>();
    		}
    		count0[a].add(i);
    	}
    	for (int i = 0; i < 60; i++) {
    		int a = bits(i);
    		if (count1[a] == null) {
    			count1[a] = new ArrayList<Integer>();
    		}
    		count1[a].add(i);
    	}
    	List<String> res = new ArrayList<String>();
    	for (int i = 0; i <= num; i++) {
    		if (i < count0.length && count0[i] != null && (num-i) < count1.length && count1[num-i] != null) {
    			for (int a : count0[i]) {
    				for (int b : count1[num-i]) {
    					if (b < 10) {
    						res.add(a+":0"+b);
    					} else {
    						res.add(a+":"+b);
    					}
    				}
    			}
    		}
    	}
    	return res;
    }
    
    private int bits(int num) {
    	int count = 0;
    	while (num > 0) {
    		if ((num&1) == 1) count++;
    		num >>= 1;
    	}
    	return count;
    }

    public static void main(String[] args) {
    }
}
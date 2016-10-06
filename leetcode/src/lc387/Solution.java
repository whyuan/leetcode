package lc387;

import java.util.*;

public class Solution {

    public int firstUniqChar(String s) {
    	if (s == null) return -1;
        int[] count = new int[26];
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
        	count[cs[i]-'a']++;
        }
        for (int i = 0; i < cs.length; i++) {
        	if (count[cs[i]-'a'] == 1) return i;
        }
        return -1;
    }

}
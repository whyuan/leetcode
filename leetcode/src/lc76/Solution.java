package lc76;

import java.util.HashMap;

public class Solution {
    public String minWindow(String s, String t) {
        if (t == null || t.length() == 0 || s == null || s.length() == 0) return "";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), 1);
            } else {
                map.put(t.charAt(i), map.get(t.charAt(i))+1);
            }
        }
        int begin = 0, end = 0, count = t.length(), min = Integer.MAX_VALUE, head = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                char c = s.charAt(i);
                if (map.get(c) > 0) {
                    count--;
                }
                map.put(c, map.get(c)-1);
                while (count == 0) {
                    if (i-begin+1 < min) {
                        min = i-begin+1;
                        head = begin;
                    }
                    if (map.containsKey(s.charAt(begin))) {
                        char charBegin = s.charAt(begin);
                        map.put(charBegin, map.get(charBegin)+1);
                        if (map.get(charBegin) > 0) {
                            count++;
                        }
                    }
                    begin++;
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(head, head+min);
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("a", "aa"));
    }
}

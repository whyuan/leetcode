package lc227;

import java.util.*;

public class Solution {

    public boolean isAnagram(String s, String t) {
	if (s == null && t == null) return true;
	if (s == null || t == null) return false;
	if (s.length() != t.length()) return false;
	char[] cs = s.toCharArray();
	char[] ct = t.toCharArray();
	Arrays.sort(cs);
	Arrays.sort(ct);
	return Arrays.equals(cs, ct);
    }

    public static void main(String[] args) {
    }
}

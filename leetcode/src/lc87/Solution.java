package lc87;

public class Solution {
    public boolean isScramble(String s1, String s2) {
    	if (s1 == null || s2 == null) return false;
    	if (s1.length() != s2.length()) return false;
    	char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
    	return isScramble(cs1, 0, cs1.length, cs2, 0, cs2.length);
    }
    
    private boolean isScramble(char[] cs1, int begin1, int end1, char[] cs2, int begin2, int end2) {
    	int[] alpha = new int[26];
    	boolean isSame = true;
    	for (int i = 0; i < end1-begin1; i++) {
    		alpha[cs1[begin1+i]-'a']++;
    		alpha[cs2[begin2+i]-'a']--;
    		if (isSame) {
    			isSame = (cs1[begin1+i] == cs2[begin2+i]);
    		}
    	}
    	if (isSame) return true;
    	for (int i = 0; i < alpha.length; i++) {
    		if (alpha[i] != 0) return false;
    	}
    	
    	for (int i = 1; i <= end1-begin1-1; i++) {
    		if ((isScramble(cs1, begin1, begin1+i, cs2, begin2, begin2+i) && isScramble(cs1, begin1+i, end1, cs2, begin2+i, end2))
    			|| (isScramble(cs1, begin1, begin1+i, cs2, end2-i, end2) && isScramble(cs1, begin1+i, end1, cs2, begin2, begin2+(end1-begin1-i)))) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.isScramble("great", "rtgae"));
    }
}

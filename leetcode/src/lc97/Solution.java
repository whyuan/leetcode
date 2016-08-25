package lc97;

import java.util.HashSet;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray(), cs3 = s3.toCharArray();
        if (cs1.length + cs2.length != cs3.length) return false;
        else {
        	return dfs(cs1, cs2, cs3, 0, 0, new HashSet<Integer>());
        }
    }
    
    private boolean dfs(char[] cs1, char[] cs2, char[] cs3, int t1, int t2, HashSet<Integer> cache) {
    	if (cache.contains(t1*cs3.length+t2)) return false;
    	if (t1 == cs1.length && t2 == cs2.length) {
    		return true;
    	} else {
    		boolean flag = false;
    		if (t1 < cs1.length && cs1[t1] == cs3[t1+t2]) {
    			flag = dfs(cs1, cs2, cs3, t1+1, t2, cache);
    		}
    		if (flag) return true;
    		if (t2 < cs2.length && cs2[t2] == cs3[t1+t2]) {
    			flag = dfs(cs1, cs2, cs3, t1, t2+1, cache);
    		}
    		if (flag) return true;
    	}
    	cache.add(t1*cs3.length+t2);
    	return false;
    }
    
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isInterleave(
				"bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
				"babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
				"babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
		System.out.println(solution.isInterleave("a", "b", "a"));
		System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}
}

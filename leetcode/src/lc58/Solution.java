package lc58;

public class Solution {
    public int lengthOfLastWord(String s) {
    	int result = 0;
    	for (int i = s.length()-1; i >= 0; i--) {
    		if (s.charAt(i) == ' ' && result > 0) {
    			return result;
    		} else if (s.charAt(i) != ' ') {
    			result++;
    		}
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.lengthOfLastWord("Hello World"));
    	System.out.println(solution.lengthOfLastWord("   "));
    }
}

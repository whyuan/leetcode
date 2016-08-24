public class Solution {
    public String countAndSay(int n) {
    	if (n <= 0) return "";
    	String[] results = new String[n+1];
    	results[0] = "1";
    	for (int i = 1; i < n; i++) {
    		int count = 0;
    		for (int j = 0; j < results[i-1].length(); j++) {
    			if (j == 0 || results[i-1].charAt(j) == results[i-1].charAt(j-1)) {
    				count++;
    			} else {
    				if (results[i] != null) {
    					results[i] += count+""+results[i-1].charAt(j-1);
    				} else {
    					results[i] = count+""+results[i-1].charAt(j-1);
    				}
    				count = 1;
    			}
    		}
    		if (count > 0) {
    			if (results[i] != null) {
    				results[i] += count+""+results[i-1].charAt(results[i-1].length()-1);
    			} else {
    				results[i] = count+""+results[i-1].charAt(results[i-1].length()-1);
    			}
    		}
    	}
    	return results[n-1];
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.countAndSay(11));
    }
}

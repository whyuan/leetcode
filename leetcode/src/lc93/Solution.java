package lc93;

import java.util.*;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        int[] pos = new int[4];
        dfs(result, 0, pos, s, 0);
        return result;
    }
    
    private void dfs(List<String> result, int step, int[] pos, String s, int start) {
    	if (step == 4) {
    		result.add(s.substring(0, pos[0])+"."+s.substring(pos[0], pos[1])+"."+s.substring(pos[1], pos[2])+"."+s.substring(pos[2], pos[3]));
    	} else if ((s.length()-start) > 3*(4-step) || (s.length()-start) < (4-step)) {
    		return;
    	} else {
    		int l = Math.min(s.length()-start, 3);
    		int a = step==3?l:1;
    		for (int i = a; i <= l; i++) {
    			if ((i == 1) || (!(s.charAt(start)=='0') && i != 1)) {
    				if (i == 1 || i == 2 || (s.charAt(start) < '2' || (s.charAt(start) == '2' && (s.charAt(start+1) < '5' || (s.charAt(start+1) == '5' && s.charAt(start+2) <= '5'))))) {
    					pos[step] = start+i;
    					dfs(result, step+1, pos, s, start+i);
    				}
    			}
    		}
    	}
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.restoreIpAddresses("172162541"));
    	System.out.println(solution.restoreIpAddresses("25525511135"));
    	System.out.println(solution.restoreIpAddresses("0"));
    	System.out.println(solution.restoreIpAddresses("10"));
    	System.out.println(solution.restoreIpAddresses("0000"));
    	System.out.println(solution.restoreIpAddresses("00001"));
    	System.out.println(solution.restoreIpAddresses("1000"));
    }
}

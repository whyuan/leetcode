package lc282;

import java.util.*;

public class Solution {
    public List<String> addOperators(String num, int target) {
    	List<String> result = new ArrayList<String>();
        if (num.length() == 0) return result;
        return dfs(num.toCharArray(), target, new ArrayList<String>(), "", 0, target, 0);
    }
    
    private List<String> dfs(char[] num, int target, List<String> result, String str, int step, long rem, long preNum) {
    	if (step == num.length && rem == preNum) {
    		result.add(str);
    		return result;
    	}
    	long val = 0;
    	for (int i = step; i < num.length; i++) {
    		val = val*10+(num[i]-'0');
    		if (i > step && num[step] == '0') break;
    		if (step == 0) {
    			dfs(num, target, result, ""+val, i+1, rem, val);
    		} else {
				dfs(num, target, result, str+"+"+val, i+1, rem-preNum, val);
				dfs(num, target, result, str+"-"+val, i+1, rem-preNum, -val);
				dfs(num, target, result, str+"*"+val, i+1, rem, preNum * val);
    		}
    	}
    	return result;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
//		System.out.println(solution.numSquares(3));
	}
}

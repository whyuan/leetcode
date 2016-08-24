package lc91;

public class Solution {
	public int numDecodings(String s) {
		char[] cs = s.toCharArray();
		int[] f = new int[cs.length + 1];
		f[0] = 1;
		if (cs.length == 0) return 0;
		for (int i = 1; i < f.length; i++) {
			if (i > 1) {
				if ((cs[i-2]=='0' && cs[i-1]=='0') || (cs[i-2]>'2' && cs[i-1]=='0')) {
					return 0;
				} else if (cs[i-2]=='0') {
					f[i] = f[i-1];
				} else if ((cs[i-2]=='1' && cs[i-1]=='0') || (cs[i-2]=='2' && cs[i-1]=='0')) {
					f[i] = f[i-2];
				} else if (cs[i-2]=='1' || (cs[i-2]=='2' && cs[i-1]<='6')) {
					f[i] = f[i-1]+f[i-2];
				} else {
					f[i] = f[i-1];
				}
			} else {
				if (cs[i-1] == '0') {
					return 0;
				} else {
					f[i] = 1;
				}
			}
		}
		return f[f.length - 1];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.numDecodings("227")); // 2
		System.out.println(solution.numDecodings("11")); // 2
		System.out.println(solution.numDecodings("100")); // 0
		System.out.println(solution.numDecodings("101")); // 1
		System.out.println(solution.numDecodings("10")); // 1
		System.out.println(solution.numDecodings("122")); // 3
		System.out.println(solution.numDecodings("")); // 0
		System.out.println(solution.numDecodings("0")); // 0
	}
}

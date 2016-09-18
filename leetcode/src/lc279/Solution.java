package lc279;

import java.util.*;

public class Solution {
	static List<Integer> f = new ArrayList<Integer>();

	public int numSquares(int n) {
		if (n <= 0)
			return -1;
		if (f.size() == 0) {
			f.add(0);
		}
		for (int i = f.size(); i <= n; i++) {
			int a = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {
				a = Math.min(a, f.get(i-j*j)+1);
			}
			f.add(a);
		}
		return f.get(n);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.numSquares(3));
		System.out.println(solution.numSquares(34));
		System.out.println(solution.numSquares(340));
		System.out.println(solution.numSquares(7));
		System.out.println(solution.numSquares(9039));
	}
}

package lc319;

import java.util.*;

public class Solution {

	public int bulbSwitch(int n) {
		if (n == 0) return 0;
		int x1 = (int) (Math.sqrt(2 + 4 * n) - 2) / 2;
		return x1 + 1;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
	}
}

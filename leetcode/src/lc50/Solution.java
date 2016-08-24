package lc50;

public class Solution {
	public double myPow(double x, int n) {
		double result = 1;
		if (x == 0) return 0;
		if (n == 0) return 1;
		if (n == 1) return x;
		if (x == 1) return 1;
		if (x == -1) return (n%2==1)?(-1):1;
		long l = n > 0 ? n : (-(long)n);
		if (n < 0) x = 1/x;
		result = x;
		if (l%2 == 1) {
			result = result*myPow(result*result, (int)(l/2));
		} else {
			result = myPow(result*result, (int)(l/2));
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		// 0.00001
		// 2147483647
//		2.00000
//		-2147483648
//		-1.00000
//		2147483647
		System.out.println(solution.myPow(2, -2147483648));
		System.out.println(solution.myPow(34.00515, -3));
		System.out.println(solution.myPow(-1, 0));
		System.out.println(solution.myPow(10, -20000));
	}
}

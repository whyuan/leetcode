package lc273;

import java.util.*;

public class Solution {
	private String[] words2 = new String[]{"Thousand", "Million", "Billion"};
	private String[] words0 = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	public String numberToWords(int num) {
		if (num == 0) return words0[0];
		int step = 0;
		String result = "";
		while(num > 0) {
			int a = num % 1000;
			String cur = "";
			if (a >= 100) {
				cur += words0[a / 100] + " Hundred";
			}
			if (a % 100 >= 20) {
				cur += " " + words0[(a / 10) % 10 + 18];
				if (a % 10 > 0) {
					cur += " " + words0[a % 10];
				} 
			} else if (a % 100 > 0) {
				cur += " " + words0[(a % 100)];
			}
			num = num / 1000;
			if (step == 0) {
				result = cur.trim();
			} else {
				if (!cur.trim().equals("")) {
					result = (cur + " " + words2[step-1] + " " + result).trim();
				}
			}
			step++;
		}
		return result;
	}

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.numberToWords(1234));
    	System.out.println(solution.numberToWords(1230));
    	System.out.println(solution.numberToWords(1000));
    	System.out.println(solution.numberToWords(1030));
    	System.out.println(solution.numberToWords(1004));
    	System.out.println(solution.numberToWords(0));
    	System.out.println(solution.numberToWords(1));
    	System.out.println(solution.numberToWords(3));
    	System.out.println(solution.numberToWords(4));
    	System.out.println(solution.numberToWords(5));
    }
}

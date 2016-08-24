package lc43;

public class Solution {
	
	public String multiply(String num1, String num2) {
		int l1 = num1.length(), l2 = num2.length();
		int[] ns = new int[l1+l2];
		for (int i = l1-1; i >= 0; i--) {
			for (int j = l2-1; j >= 0; j--) {
				ns[i+j+1] += ((num1.charAt(i)-'0')*(num2.charAt(j)-'0'));
			}
		}
		int g = 0, a;
		for (int i = ns.length-1; i >= 0; i--) {
			a = ns[i]+g; 
			g = (a)/10;
			ns[i] = (a)%10;
		}
		StringBuilder result = new StringBuilder();
		for (int i : ns) result.append(i);
		while (result.length() != 0 && result.charAt(0) == '0') result.deleteCharAt(0);
		return (result.length()==0?"0":result.toString());
	}

	public String multiply0(String num1, String num2) {
		int[] num_1 = new int[num1.length()];
		int[] num_2 = new int[num2.length()];
		int[] result = new int[num1.length()+num2.length()+1];
		int g = 0;
		this.setNums(num_1, num1);
		this.setNums(num_2, num2);
		for (int i = 0; i < num_1.length; i++) {
			for (int j = 0; j < num_2.length; j++) {
				int a = (num_2[j] * num_1[i]) + result[j+i];
				int offset = 0;
				result[j+i] = a;
				while (result[j+i+offset] >= 10) {
					int b = result[j+i+offset];
					result[j+i+offset] = b%10;
					result[j+i+offset+1] = result[j+i+offset+1]+b/10;
					offset++;
				}
			}
		}
		boolean flag = false;
		StringBuilder resultS = new StringBuilder();
		for (int i = result.length-1; i >= 0; i--) {
			if (result[i] != 0) flag = true;
			if (flag) {
				resultS.append(result[i]);
			}
		}
		if (!flag) return "0";
		else return resultS.toString();
	}
	
	private void setNums(int[] num_1, String num1) {
		for (int i = 0; i < num_1.length; i++) {
			num_1[i] = num1.charAt(num_1.length-i-1)-'0';
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.multiply("9", "9"));
		System.out.println(solution.multiply("12", "22"));
		System.out.println(solution.multiply("0", "0"));
	}
}

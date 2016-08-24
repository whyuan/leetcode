package lc52;

public class Solution {
    public int totalNQueens(int n) {
		int[] pos = new int[n];
		dfs(pos, 0);
		return result;
    }

    private int result = 0;
	private void dfs(int[] pos, int step) {
		if (step >= pos.length) {
			result++;
		} else {
			for (int i = 0; i < pos.length; i++) {
				boolean flag = true;
				for (int j = step-1; j >= 0; j--) {
					if ((pos[j] == i || pos[j]-i==step-j || pos[j]-i==j-step)) {
						flag = false;
						break;
					}
				}
				if (!flag) continue;
				pos[step] = i;
				dfs(pos, step+1);
				pos[step] = -1;
			}
		}
	}
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.totalNQueens(4));
    }
}

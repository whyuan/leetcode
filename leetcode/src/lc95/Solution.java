package lc95;

import common.TreeNode;
import java.util.*;

public class Solution {
	public List<TreeNode> generateTrees(int n) {
		return dfs(1, n, new HashMap<Integer, List<TreeNode>>(), n);
	}

	private List<TreeNode> dfs(int start, int end, Map<Integer, List<TreeNode>> map, int n) {
		if (map.containsKey(start+end*n)) {
			return map.get(start+end*n);
		}
		List<TreeNode> result = new ArrayList<TreeNode>();
		for (int i = start; i <= end; i++) {
			List<TreeNode> lefts = new ArrayList<TreeNode>();
			if (i > start) {
				lefts = dfs(start, i-1, map, n);
			} else {
				lefts.add(null);
			}
			List<TreeNode> rights = new ArrayList<TreeNode>();
			if (end > i) {
				rights = dfs(i+1, end, map, n);
			} else {
				rights.add(null);
			}
			for (int j = 0; j < lefts.size(); j++) {
				for (int k = 0; k < rights.size(); k++) {
					TreeNode a = new TreeNode(i);
					a.left = lefts.get(j);
					a.right = rights.get(k);
					result.add(a);
				}
			}
		}
		map.put(start+end*n, result);
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.generateTrees(3));
	}
}

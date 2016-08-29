package lc116;

import common.TreeLinkNode;
import java.util.*;

public class Solution {
    public void connect(TreeLinkNode root) {
        dfs(root, new ArrayList<TreeLinkNode>(), 0);
    }
    
    private void dfs(TreeLinkNode root, List<TreeLinkNode> list, int depth) {
    	if (root == null) return;
    	if (depth >= list.size()) {
    		list.add(root);
    	} else {
    		TreeLinkNode node = list.get(depth);
    		node.next = root;
    		list.set(depth, root);
    	}
		dfs(root.left, list, depth + 1);
		dfs(root.right, list, depth + 1);
    }
}

package lc207;

import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true;
    	int[] preNums = new int[numCourses];
    	boolean[][] p = new boolean[numCourses][numCourses];
    	boolean[] visited = new int[numCourses];
    	for (int i = 0; i < prerequisites.length; i++) {
    		preNums[prerequisites[i][0]]++;
    		p[prerequisites[i][0]][prerequisites[i][1]] = true;
    	}
    	while (true) {
    		for (int i = 0; i < preNums.length; i++) {
    			if (preNums[i] == 0) {
    				for (int j = 0; j < numCourses; j++) {
    					if (p[prerequisites[i][0]][])
    				}
    			}
    		}
    	}
    	for (int i = 0; i < prerequisites.length; i++) {
    		if (colors[i]==0 && !dfs(visited, prerequisites, colors, i, i+1)) {
    			return false;
    		}
    	}
    	return true;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
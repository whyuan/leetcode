package lc210;

import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	if (numCourses == 0) return new int[]{};
    	int[] preNums = new int[numCourses];
    	boolean[][] p = new boolean[numCourses][numCourses];
    	boolean[] visited = new boolean[numCourses];
    	int[] result = new int[numCourses];
    	int step = 0;
    	for (int i = 0; i < prerequisites.length; i++) {
    		if (!p[prerequisites[i][0]][prerequisites[i][1]]) {
				preNums[prerequisites[i][0]]++;
				p[prerequisites[i][0]][prerequisites[i][1]] = true;
    		}
    	}
    	while (true) {
    		boolean flag = false;
    		for (int i = 0; i < preNums.length; i++) {
    			if (preNums[i] == 0 && !visited[i]) {
    				visited[i] = true;
    				flag = true;
    				result[step++] = i;
    				for (int j = 0; j < numCourses; j++) {
    					if (p[j][i]) {
    						p[j][i] = false;
    						preNums[j]--;
    					}
    				}
    			}
    		}
    		if (!flag) {
    			break;
    		}
    	}
    	for (int i = 0; i < preNums.length; i++) {
    		if (preNums[i] != 0) return new int[]{};
    	}
    	for (int i = 0; i < visited.length; i++) {
    		if (!visited[i]) result[step++] = i;
    	}
    	return result;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
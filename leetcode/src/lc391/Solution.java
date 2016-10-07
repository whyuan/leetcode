package lc391;

import java.util.*;

public class Solution {
	
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0) return true;
        int[] rect0 = rectangles[0];
        int[] target = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        int area = 0;
        Set<String> angles = new HashSet<String>();
        for (int i = 0; i < rectangles.length; i++) {
        	int[] rect = rectangles[i];
        	target[0] = Math.min(rect[0], target[0]);
        	target[1] = Math.min(rect[1], target[1]);
        	target[2] = Math.max(rect[2], target[2]);
        	target[3] = Math.max(rect[3], target[3]);
        	area += (rect[2]-rect[0])*(rect[3]-rect[1]);
        	String c0 = rect[0] + " " + rect[1];
        	String c1 = rect[0] + " " + rect[3];
        	String c2 = rect[2] + " " + rect[1];
        	String c3 = rect[2] + " " + rect[3];
        	if (angles.contains(c0)) angles.remove(c0);
        	else angles.add(c0);
        	if (angles.contains(c1)) angles.remove(c1);
        	else angles.add(c1);
        	if (angles.contains(c2)) angles.remove(c2);
        	else angles.add(c2);
        	if (angles.contains(c3)) angles.remove(c3);
        	else angles.add(c3);
        }
        if (angles.size() == 4 && angles.contains(target[0]+" "+target[1]) && angles.contains(target[0]+" "+target[3]) && angles.contains(target[2]+" "+target[1]) && angles.contains(target[2]+" "+target[3]) && area == (target[3]-target[1])*(target[2]-target[0])) {
        	return true;
        } else {
        	return false;
        }
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
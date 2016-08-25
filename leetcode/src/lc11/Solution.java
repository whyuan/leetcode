package lc11;

public class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int result = 0;
        while (l < r) {
            result = Math.max(result, (r-l)*Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                int curL = height[l];
                while (l<r && height[l]<=curL) l++;
            } else {
                int curR = height[r];
                while (l<r && height[r]<=curR) r--;
            }
        }
        return result;
    }

  public int maxArea0(int[] height) {
    int[] maxs = new int[height.length];
    int p = -1;
    int result = 0;
    for (int i = 0; i < height.length; i++) {
        if (p == -1 || height[i] > maxs[p]) {
            // maxs[++p] = height[i];
            maxs[++p] = i;
        }

        for (int j = p; j >= 0; j--) {
            int area;
            if (height[maxs[j]] < height[i]) {
                area = (i-maxs[j])*height[maxs[j]];
            } else {
                area = (i-maxs[j])*height[i];
            }
            if (area > result) {
                result = area;
            }
        }
    }
    return result;
  }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {12,34,452,3,4};
        System.out.println(solution.maxArea(a));
    }
}


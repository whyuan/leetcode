package lc88;

public class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int t1 = m, t2 = n;
		for (int i = m + n - 1; i >= 0; i--) {
			if (t1 > 0 && t2 > 0) {
				if (nums1[t1-1] > nums2[t2-1]) {
					nums1[i] = nums1[--t1];
				} else {
					nums1[i] = nums2[--t2];
				}
			} else if (t1 > 0) {
				nums1[i] = nums1[--t1];
			} else {
				nums1[i] = nums2[--t2];
			}
		}

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.merge(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 2, 3, 0, 0, 0 }, 3);
	}
}

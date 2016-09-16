package lc227;

import java.util.*;

public class Solution extends VersionControl{
    public int firstBadVersion(int n) {
	if (n <= 0) return 0;
        int h = 0, t = n;
	while (h < t) {
	    int m = h+(t-h)/2;
	    if (isBadVersion(m+1)) {
	        t = m;
	    } else {
		h = m+1;
	    }
	}
	return h+1;
    }

    public static void main(String[] args) {
    }
}

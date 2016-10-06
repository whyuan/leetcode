package lc374;

import java.util.*;

class GuessGame {
	public int guess(int num) {
		return 0;
	}
}

public class Solution extends GuessGame {
    public int guessNumber(int n) {
    	int h = 1, t = n;
        while(h <= t) {
        	int m = h+(t-h)/2;
        	int a = guess(m);
        	if (a == 1) {
        		h = m+1;
        	} else if (a == -1) {
        		t = m-1;
        	} else {
        		return m;
        	}
        }
        return 0;
    }
}
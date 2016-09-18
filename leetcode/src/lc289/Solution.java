package lc289;

import java.util.*;

public class Solution {
    public void gameOfLife(int[][] board) {
    	if (board == null) return;
    	int l0 = board.length, l1 = board[0].length;
    	if (l0 == 0 || l1 == 0) return;
        for (int i = 0; i < l0; i++) {
        	for (int j = 0; j < l1; j++) {
        		int t = 0;
        		if (i-1>=0 && j-1>=0) t+=board[i-1][j-1]&1;
        		if (i-1>=0) t+=board[i-1][j]&1;
        		if (i-1>=0 && j+1<l1) t+=board[i-1][j+1]&1;
        		if (j+1<l1) t+=board[i][j+1]&1;
        		if (i+1<l0 && j+1<l1) t+=board[i+1][j+1]&1;
        		if (i+1<l0) t+=board[i+1][j]&1;
        		if (i+1<l0 && j-1>=0) t+=board[i+1][j-1]&1;
        		if (j-1>=0) t+=board[i][j-1]&1;
        		if (t == 2) {
        			board[i][j] = (board[i][j]<<1)|board[i][j];
        		} else if (t == 3) {
        			board[i][j] = 2|board[i][j];
        		}
        	}
        }
        for (int i = 0; i < l0; i++) {
        	for (int j = 0; j < l1; j++) {
        		board[i][j] = board[i][j]>>1;
        	}
        }
    }

    public static void main(String[] args) {
    }
}

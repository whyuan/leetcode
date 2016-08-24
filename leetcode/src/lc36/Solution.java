package lc36;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
    	int len = 9;
    	int i0, j0;
    	int mask = 0, a, b, c;
    	int mask0, mask1, mask2;
    	for (int i = 0; i < len; i++) {
    		mask0 = 0;
    		mask1 = 0;
    		mask2 = 0;
    		a = i/3*3;
    		b = i%3*3;
    		for (int j = 0; j < len; j++) {
    			if (board[i][j] != '.') {
    				if ((mask0 & (1<<(board[i][j]-'0'))) != 0) return false;
    				mask0 |= (1<<(board[i][j]-'0'));
    			}
    			if (board[j][i] != '.') {
    				if ((mask1 & (1<<(board[j][i]-'0'))) != 0) return false;
    				mask1 |= (1<<(board[j][i]-'0'));
    			}
    			i0 = a+j/3;
    			j0 = b+j%3;
    			if (board[i0][j0] != '.') {
    				if ((mask2 & (1<<(board[i0][j0]-'0'))) != 0) return false;
    				mask2 |= (1<<(board[i0][j0]-'0'));
    			}
    		}
    	}
    	return true;
    }
	
    public boolean isValidSudoku0(char[][] board) {
    	int len = 9;
    	int[] mark = new int[10];
    	int i0, j0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] != '.') {
                	for (int k = i+1; k < len; k++) {
                        if (board[k][j] == board[i][j]) return false;
                	}
                	for (int k = j+1; k < len; k++) {
                        if (board[i][k] == board[i][j]) return false;
                	}
                	for (int k = i%3*3+j%3+1; k < len; k++) {
                        i0 = i/3*3+k/3;
                        j0 = j/3*3+k%3;
                        if (board[i0][j0] == board[i][j]) return false;
                	}
                }
            }
        }
        return true;
    }
    
    private void clean(int[] flag) {
    	for (int i = 0; i < flag.length; i++) {
    		flag[i] = 0;
    	}
    }
    
    public static void main(String[] main) {
    	Solution solution = new Solution();
//    	[".87654321","2........","3........","4........","5........","6........","7........","8........","9........"]
//    	["....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",".15......",".....2...",".2.9.....","..4......"]
//    	["......5..",".........",".........","93..2.4..","..7...3..",".........","...34....",".....3...",".....52.."]
    	System.out.println(solution.isValidSudoku(new char[][]{
    						{'.','8','7','6','5','4','3','2','1'},
    						{'2','.','.','.','.','.','.','.','.'},
    						{'3','.','.','.','.','.','.','.','.'},
    						{'4','.','.','.','.','.','.','.','.'},
    						{'5','.','.','.','.','.','.','.','.'},
    						{'6','.','.','.','.','.','.','.','.'},
    						{'7','.','.','.','.','.','.','.','.'},
    						{'8','.','.','.','.','.','.','.','.'},
    						{'9','.','.','.','.','.','.','.','.'}
    						}));
    }
}

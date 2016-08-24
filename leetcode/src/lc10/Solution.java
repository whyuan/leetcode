import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by wanghaoyuan on 2016/8/1.
 */
public class Solution {
    private class Node {
        int sp;
        int pp;
        Node(int sp, int pp, char starChar) {
            this.sp = sp;
            this.pp = pp;
        }
    }

    public boolean isMatch(String s, String p) {
        if (s == "" && p == "") return true;
        if (s == "" && p != "") return false;
        if (s != "" && p == "") return false;
        int sp = 0;
        int pp = 0;
        Stack<Node> stack = new Stack<Node>();
        char starChar = 0;
        while (true) {
            if (p.charAt(pp) == '*' || (pp < p.length()-1 && p.charAt(pp+1) == '*')) {
                int pStarChar = pp;
                while (pStarChar > 0 && p.charAt(pStarChar)=='*') pStarChar--;
                if (pStarChar >= 0) {
                    starChar = p.charAt(pStarChar);
                } else {
                    starChar = 0;
                }
                if (starChar == '.' || starChar == s.charAt(sp)) {
                    if (pp+1 < p.length()) {
                        stack.push(new Node(sp, pp+1, starChar));
                    } else {
                        stack.push(new Node(sp, pp, starChar));
                    }
                    sp++;
                } else {
                    pp++;
                }
            } else if (p.charAt(pp) == '.' || p.charAt(pp) == s.charAt(sp)) {
                pp++;
                sp++;
            } else {
                return false;
            }
            if (sp == s.length() && pp == p.length()) {
                return true;
            } else if (pp == p.length() || sp == s.length()) {
                if (stack.size() == 0) {
                    return false;
                } else {
                    Node node = stack.pop();
                    pp = node.pp;
                    sp = node.sp;
                    pp++;
                    if (pp == p.length()) {
                        return false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("ab", ".*c"));// ¡ú false
        System.out.println(solution.isMatch("aaa", "baabaaa"));// ¡ú false
        System.out.println(solution.isMatch("aa", "a*"));// ¡ú true
        System.out.println(solution.isMatch("aaa","ab*ac*a"));// ¡ú true
        System.out.println(solution.isMatch("aa","a"));// ¡ú false
        System.out.println(solution.isMatch("aa","aa"));// ¡ú true
        System.out.println(solution.isMatch("aaa","aa"));// ¡ú false
        System.out.println(solution.isMatch("aa", "a*"));// ¡ú true
        System.out.println(solution.isMatch("aa", ".*"));// ¡ú true
        System.out.println(solution.isMatch("ab", ".*"));// ¡ú true
        System.out.println(solution.isMatch("aab", "c*a*b"));// ¡ú true
    }
}


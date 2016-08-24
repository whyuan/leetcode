package lc20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by wanghaoyuan on 2016/8/4.
 */
public class Solution {
    public boolean isValid(String s) {
        char[][] map = new char[][]{{'(',')'}, {'[', ']'}, {'{', '}'}};
//        Stack<Character> stack = new Stack<Character>();
        char[] stack = new char[s.length()];
        int st = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
//                stack.push(c);
                stack[st++] = c;
            } else {
                if (st > 0) {
                    char p = stack[st-1];
                    if (p == 0) {
                        return false;
                    } else {
                        if ((p == '(' && c == ')') || (p == '[' && c == ']') || (p == '{' && c == '}')) {
//                            stack.pop();
                            st--;
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        if (st == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValid1(String s) {
        char[][] map = new char[][]{{'(',')'}, {'[', ']'}, {'{', '}'}};
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (!stack.empty()) {
                    char p = stack.peek();
                    if (p == 0) {
                        return false;
                    } else {
                        if ((p == '(' && c == ')') || (p == '[' && c == ']') || (p == '{' && c == '}')) {
                            stack.pop();
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid(""));
        System.out.println(solution.isValid(")"));
        System.out.println(solution.isValid("("));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("{{{{}}}}"));
        System.out.println(solution.isValid("(])[{}"));
    }
}

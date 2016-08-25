package lc71;

import java.util.*;
public class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
    String[] stack = new String[dirs.length];
    int stAll = 0;
    int st = 0;
    for (int i = 1; i < dirs.length; i++) {
        if (dirs[i].equals("..")) {
            stAll--;
            st = Math.max(0, st-1);
        } else if (!dirs[i].equals(".") && !dirs[i].equals("")) {
            stAll++;
            stack[st] = dirs[i];
            st++;
        }
    }
    String result = "";
    //for (int i = 0; i < st-stAll; i++) {
        //result += "/..";
    //}
    for (int i = 0; i < st; i++) {
        result += "/"+stack[i];
    }
    if (result == "") return "/";
    else return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));
    }
}

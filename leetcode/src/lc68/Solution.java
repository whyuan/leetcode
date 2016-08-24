
import java.util.*;
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
    int l = 0;
    int start = 0;
    List<String> result = new ArrayList<String>();
    while (start < words.length) {
        l = words[start].length();
        int step = 1;
        int realL = l;
        while (start+step < words.length && l+words[start+step].length()+1 <= maxWidth) {
            l += words[start+step].length()+1;
            realL += words[start+step].length();
            step++;
        }
        int totalSpace = maxWidth-realL;
        int interval = Math.max(1, step-1);
        int spaceWidth = totalSpace/interval;
        int extraSpaceNum = totalSpace%interval;
        String word = "";
        if (start+step < words.length) {
            l = 0;
            for (int i = start; i < start+step; i++) {
                word += words[i];
                l += words[i].length();
                if (l < maxWidth) {
                    int a = (extraSpaceNum!=0)?1:0;
                    for (int k = 0; k < spaceWidth+a; k++) {
                        word += " ";
                    } 
                    l += spaceWidth+a;
                    if (extraSpaceNum > 0) extraSpaceNum--;
                }
            }
        } else {
            l = 0;
            for (int i = start; i < start+step; i++) {
                word += words[i];
                l += words[i].length();
                if (i < start+step-1) {
                    word += " "; 
                    l++;
                }
            }
            for (int k = 0; k < maxWidth-l; k++) {
                word += " ";
            }
        }
        result.add(word);
        start = start+step;
    }
    if (result.size() == 0) {
        result.add("");
    }
    return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fullJustify(new String[]{"abcd", "ef", "erdge", "aaa"}, 10));
    }
}

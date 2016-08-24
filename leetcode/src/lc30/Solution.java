import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if (s.length() <= 0 || words.length <= 0) return result;
        int wLen = words[0].length();
        int sLen = s.length();
        Map<String, Integer> wDict = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            wDict.put(words[i], wDict.containsKey(words[i]) ? wDict.get(words[i])+1 : 1);
        }
        int left = 0;
        int count = 0;
        Map<String, Integer> tDict = new HashMap<String, Integer>();
        for (int i = 0; i < wLen; i++) {
            left = i;
            count = 0;
            tDict.clear();
            for (int j = i; j < sLen-wLen+1; j += wLen) {
                String cur = s.substring(j, j+wLen);
                if (wDict.containsKey(cur)) {
                    if (!tDict.containsKey(cur)) tDict.put(cur, 0);
                    while (tDict.get(cur) >= wDict.get(cur)) {
                        String out = s.substring(left, left+wLen);
                        tDict.put(out, tDict.get(out)-1);
                        count--;
                        left += wLen;
                    }
                    count++;
                    tDict.put(cur, !tDict.containsKey(cur) ? 1 : tDict.get(cur)+1);
                    if (count == words.length) {
                        result.add(left);
                    }
                } else {
                    tDict.clear();
                    left = j+wLen;
                    count = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findSubstring("aaaaaaaa", new String[]{"aa","aa","aa"}));
        System.out.println(solution.findSubstring("barfoofoobarthefoobarman", new String[]{"foo", "bar", "the"}));
        System.out.println(solution.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(solution.findSubstring("aaaaaaaa", new String[]{"a"}));
    }
}

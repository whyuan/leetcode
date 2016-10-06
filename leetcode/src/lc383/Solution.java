package lc383;

import java.util.*;

public class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] cMagazine = magazine.toCharArray();
        int[] counts = new int[26];
        for (int i = 0; i < cMagazine.length; i++) {
        	counts[cMagazine[i]-'a']++;
        }
        char[] cRansomNote = ransomNote.toCharArray();
        for (int i = 0; i < cRansomNote.length; i++) {
        	counts[cRansomNote[i]-'a']--;
        	if (counts[cRansomNote[i]-'a'] < 0) return false;
        }
        return true;
    }

	public static void main(String[] args) {
	}
}
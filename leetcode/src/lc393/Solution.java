package lc393;

import java.util.*;

public class Solution {
	
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) return true;
        int i = 0;
        while (i < data.length) {
        	if ((data[i]&0x80) == 0) i++;
        	else if (i < data.length-1 && (data[i]&0xE0) == 0xC0 && (data[i+1]&0xC0) == 0x80) i += 2;
        	else if (i < data.length-2 && (data[i]&0xF0) == 0xE0 && (data[i+1]&0xC0) == 0x80 && (data[i+2]&0xC0) == 0x80) i += 3;
        	else if (i < data.length-3 && (data[i]&0xF8) == 0xF0 && (data[i+1]&0xC0) == 0x80 && (data[i+2]&0xC0) == 0x80 && (data[i+3]&0xC0) == 0x80) i += 4;
        	else return false;
        }
        return true;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();
    }
}
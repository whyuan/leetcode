package lc126;

import java.util.*;

public class Solution {
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();
		beginSet.add(beginWord);
		endSet.add(endWord);
		wordList.remove(beginWord);
		wordList.remove(endWord);
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		int l = f(beginSet, endSet, wordList, 2, map, true);
		return getPaths(beginWord, map, endWord);
	}

	private int f(Set<String> beginSet, Set<String> endSet, Set<String> wordList, int step,
			Map<String, List<String>> map, boolean isForward) {
		Set<String> newSet = new HashSet<String>();
		// List<String> list0 = new ArrayList<String>();
		boolean flag = false;
		for (String s : beginSet) {
			char[] cs = s.toCharArray();
			for (int i = 0; i < cs.length; i++) {
				char bak = cs[i];
				for (char j = 'a'; j <= 'z'; j++) {
					cs[i] = j;
					String newS = String.valueOf(cs);
					if (wordList.contains(newS) || newSet.contains(newS) || endSet.contains(newS)) {
						if (wordList.contains(newS)) {
							wordList.remove(newS);
							newSet.add(newS);
						}
						String sa = s, sb = newS;
						if (!isForward) {
							sa = newS;
							sb = s;
						}
						if (map.containsKey(sa)) {
							List<String> aList = map.get(sa);
							aList.add(sb);
						} else {
							List<String> newList = new ArrayList<String>();
							newList.add(sb);
							map.put(sa, newList);
						}
						if (endSet.contains(newS)) {
							flag = true;
						}
					}
				}
				cs[i] = bak;
			}
		}
		if (newSet.size() == 0)
			return step;
		if (flag)
			return step;
		if (newSet.size() > endSet.size()) {
			return f(endSet, newSet, wordList, step + 1, map, isForward ? false : true);
		} else {
			return f(newSet, endSet, wordList, step + 1, map, isForward ? true : false);
		}
	}

	private List<List<String>> getPaths(String s, Map<String, List<String>> map, String targetS) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> cur = new ArrayList<String>();
		dfs(result, s, map, cur, targetS);
		return result;
	}

	private void dfs(List<List<String>> result, String s, Map<String, List<String>> map, List<String> cur,
			String targetS) {
		if (s != null) {
			cur.add(s);
			if (s.equals(targetS)) {
				result.add(new ArrayList<String>(cur));
			} else {
				List<String> list = map.get(s);
				if (list != null) {
					for (String as : list) {
						dfs(result, as, map, cur, targetS);
					}
				}
			}
			cur.remove(cur.size() - 1);
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		// beginWord = "hit"
		// endWord = "cog"
		// wordList = ["hot","dot","dog","lot","log"]
		HashSet<String> hashSet3 = new HashSet<String>();
		hashSet3.add("a");
		hashSet3.add("b");
		hashSet3.add("c");
		System.out.println(solution.findLadders("a", "c", hashSet3));
		HashSet<String> hashSet2 = new HashSet<String>();
		hashSet2.add("hot");
		hashSet2.add("cog");
		hashSet2.add("dot");
		hashSet2.add("dog");
		hashSet2.add("hit");
		hashSet2.add("lot");
		hashSet2.add("log");
		System.out.println(solution.findLadders("hit", "cog", hashSet2));
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("hot");
		hashSet.add("dot");
		hashSet.add("dog");
		hashSet.add("lot");
		hashSet.add("log");
		System.out.println(solution.findLadders("hit", "cog", hashSet));
		HashSet<String> hashSet1 = new HashSet<String>();
		hashSet1.add("hot");
		hashSet1.add("dog");
		hashSet1.add("dot");
		System.out.println(solution.findLadders("hot", "dog", hashSet1));
	}
}

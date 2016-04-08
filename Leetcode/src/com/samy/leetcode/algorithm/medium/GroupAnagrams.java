package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	/**
	 * 
	 * @param strs
	 * @return
	 * Apr 8, 2016
	 * @author Jiupeng
	 * @description 100 test cases, 36ms beats 16.53%
	 * @reference https://leetcode.com/problems/anagrams/
	 * @interpretation
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> anagrams = new ArrayList<List<String>>();
		Map<String, List<String>> maps = new HashMap<String, List<String>>();
		int[] flag = new int[26];
		for (String s : strs) {
			for (int i = 0, l = s.length(); i < l; ++i)
				flag[s.charAt(i) - 'a']++;
			String h = hash(flag);
			List<String> list = maps.get(h);
			if (list != null) {
				// contains
				int j = 0, k = list.size();
				while (j < k && s.compareTo(list.get(j)) > 0)
					++j;
				list.add(j, s);
			} else {
				list = new ArrayList<String>();
				list.add(s);
				maps.put(h, list);
			}
			flag = new int[26];
		}
		Iterator<String> keys = maps.keySet().iterator();
		while (keys.hasNext())
			anagrams.add(maps.get(keys.next()));

		return anagrams;
	}

	private String hash(int[] flag) {
		StringBuilder sb = new StringBuilder();
		for (int f : flag)
			sb.append(f + ".");
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

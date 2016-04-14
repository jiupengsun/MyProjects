package com.samy.leetcode.algorithm.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WordBreak {

	/**
	 * 
	 * @param s
	 * @param wordDict
	 * @return
	 * 2016Äê4ÔÂ14ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/word-break/
	 * @interpretation
	 */
	public boolean wordBreak(String s, Set<String> wordDict) {
		Map<Integer, Set<Integer>> seq = new HashMap<Integer, Set<Integer>>();
		Iterator<String> words = wordDict.iterator();
		// match the string with each word
		// if matched, then put the start and end index in the map
		while (words.hasNext()) {
			String word = words.next();
			int l = word.length();
			//greedy search
			int i = 0;
			while (true) {
				i = s.indexOf(word, i);
				if (i == -1)
					break;
				Set<Integer> set = seq.get(i);
				if (set == null)
					set = new HashSet<Integer>();
				set.add(i + l);
				seq.put(i, set);
				i += l;
			}
		}

		return couldBreak(seq, 0, s.length());
	}

	private boolean couldBreak(Map<Integer, Set<Integer>> seq, int start, int end) {
		Set<Integer> set = seq.get(start);
		if (set == null)
			return false;
		for (int index : set) {
			if (index == end || couldBreak(seq, index, end))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

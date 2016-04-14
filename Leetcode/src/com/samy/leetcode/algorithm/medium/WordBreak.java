package com.samy.leetcode.algorithm.medium;

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
		int i = 0, last = i, l = s.length();
		while (i < l) {
			for (String w : wordDict) {
				if (s.startsWith(w, i)) {
					i += w.length();
					break;
				}
			}
			if (last == i)
				return false;
			last = i;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

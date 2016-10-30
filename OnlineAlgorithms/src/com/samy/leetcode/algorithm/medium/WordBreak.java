package com.samy.leetcode.algorithm.medium;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordBreak {

	/**
	 * 
	 * @param s
	 * @param wordDict
	 * @return
	 * Apr 18, 2016
	 * @author Jiupeng
	 * @description 34 test cases, 12ms beats 31.03%
	 * @reference https://leetcode.com/problems/word-break/
	 * @interpretation http://www.programcreek.com/2012/12/leetcode-solution-word-break/
	 */
	public boolean wordBreak(String s, Set<String> wordDict) {
		int l = s.length();
		boolean[] dp = new boolean[l + 1];
		dp[0] = true;
		for (int i = 0; i <= l; ++i) {
			if (dp[i])
				continue;
			for (String word : wordDict) {
				int len = word.length();
				if (len > i)
					continue;
				int st = i - len;
				if (dp[st] && s.substring(st, i).equals(word))
					dp[i] = true;
			}
		}

		return dp[l];
	}

	/**
	 * 
	 * @param s
	 * @param wordDict
	 * @return
	 * Apr 18, 2016
	 * @author Jiupeng
	 * @description 34 test cases, 10ms beats 63.20%
	 * @reference 
	 * @interpretation
	 */
	public boolean wordBreak2(String s, Set<String> wordDict) {
		int l = s.length();
		boolean[] dp = new boolean[l + 1];
		dp[0] = true;
		for (int i = 0; i < l; ++i) {
			if (dp[i]) {
				for (String word : wordDict) {
					int len = word.length();
					int end = i + len;
					if (end > l)
						continue;
					if (word.equals(s.substring(i, end)))
						dp[end] = true;
				}
			}
		}
		return dp[l];
	}

	public boolean wordBreak3(String s, Set<String> wordDict) {
		StringBuilder sb = new StringBuilder();
		for (String word : wordDict)
			sb.append(word + "|");
		String pattern = sb.deleteCharAt(sb.length() - 1).toString();
		pattern = "(" + pattern + ")*";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(s);
		return m.matches();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

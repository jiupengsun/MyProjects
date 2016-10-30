package com.samy.leetcode.algorithm.easy;

public class ValidAnagram {

	/**
	 * 
	 * @param s
	 * @param t
	 * @return 2016Äê1ÔÂ11ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/valid-anagram/
	 */
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] alpha = new int[26];
		int s_length = s.length();
		for (int i = 0; i < s_length; ++i) {
			++alpha[s.charAt(i) - 97];
			--alpha[t.charAt(i) - 97];
		}
		for (int i : alpha)
			if (i != 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aa";
		String t = "a";
		System.out.println(isAnagram(s, t));
	}

}

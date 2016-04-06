package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

	private final String[][] phoneNumbers = { {}, {}, { "a", "b", "c" }, { "d", "e", "f" }, { "g", "h", "i" },
			{ "j", "k", "l" }, { "m", "n", "o" }, { "p", "q", "r", "s" }, { "t", "u", "v" }, { "w", "x", "y", "z" } };

	/**
	 * 
	 * @param digits
	 * @return
	 * Apr 6, 2016
	 * @author Jiupeng
	 * @description 25 test cases, 2ms beats 12.6%
	 * @reference https://leetcode.com/problems/letter-combinations-of-a-phone-number/
	 * @interpretation
	 */
	public List<String> letterCombinations(String digits) {
		int length = digits.length();
		List<List<String>> com = new ArrayList<List<String>>();
		List<String> ini = new ArrayList<String>();
		if (length == 0)
			return ini;
		ini.add("");
		com.add(ini);
		for (int i = 0; i < length; ++i) {
			int n = digits.charAt(i) - '0';
			if (n <= 1)
				return new ArrayList<String>();
			List<String> list = new ArrayList<String>();
			List<String> last = com.get(com.size() - 1);
			String[] letters = phoneNumbers[n];
			for (String s : last)
				for (String l : letters)
					list.add(s + l);
			com.add(list);
		}
		return com.get(com.size() - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

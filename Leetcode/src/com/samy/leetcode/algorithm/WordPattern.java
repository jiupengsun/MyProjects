package com.samy.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

	/**
	 * 
	 * @param pattern
	 * @param str
	 * @return
	 * 2016Äê1ÔÂ19ÈÕ
	 * @author Jiupeng
	 * @description 28 test cases 1ms beats 99.35%
	 * @reference https://leetcode.com/problems/word-pattern/
	 */
	public static boolean wordPattern(String pattern, String str) {
		Map<Character, String> map1 = new HashMap<Character, String>();
		Map<String, Character> map2 = new HashMap<String, Character>();
		int l1 = pattern.length(), l2 = str.length();
		int i = 0, j = 0;
		char c;
		for (; i < l1 && j < l2; ++i) {
			c = pattern.charAt(i);
			while (j < l2 && str.charAt(j) == ' ')
				++j;
			int tmp = j + 1;
			while (tmp < l2 && str.charAt(tmp) != ' ')
				++tmp;
			String sub = str.substring(j, tmp);
			//
			String sublast = map1.get(c);
			Character clast = map2.get(sub);
			if (sublast == null && clast == null) {
				map1.put(c, sub);
				map2.put(sub, c);
			} else if (!sub.equals(sublast) || clast == null
					|| clast.charValue() != c)
				return false;
			j = tmp;
		}
		return (i == l1 && j == l2) ? true : false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "abba";
		String str = "dog cat cat dog";
		wordPattern(pattern, str);
	}

}

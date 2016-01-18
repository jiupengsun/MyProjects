package com.samy.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * 
	 * @param s
	 * @return
	 * 2016年1月18日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/longest-substring-without-repeating-characters/
	 */
	public int lengthOfLongestSubstring(String s) {
		int max = 0, i = 0, j = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		while (j < s.length()) {
			String st = s.substring(j, j + 1);
			if (map.containsKey(st) && map.get(st) >= i)
				i = map.get(st) + 1;
			map.put(st, j++);
			max = max > (j - i) ? max : (j - i);
		}
		return max;
	}

	/**
	 * 
	 * @param s
	 * @return
	 * 2016年1月18日
	 * @author Jiupeng
	 * @description Use 256array to replace hashmap; Replace substring to charAt
	 * @reference
	 */
	public int lengthOfLongestSubstring2(String s) {
		int max = 0, i = 1, j = 1;
		int[] chars = new int[256];
		while (j <= s.length()) {
			char c = s.charAt(j - 1);
			if (chars[c] >= i) {
				i = chars[c] + 1;
				if (s.length() - i < max)
					return max;
			}
			chars[c] = j++;
			max = max > (j - i) ? max : (j - i);
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

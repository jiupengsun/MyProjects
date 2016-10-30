package com.samy.leetcode.algorithm.easy;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsofaString {

	private static final char[] vowels = new char[] { 'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U' };
	public static Set<Character> vowelSet = new HashSet<Character>();

	static {
		vowelSet = new HashSet<Character>();
		for (char c : vowels)
			vowelSet.add(c);
	}

	/**
	 * 
	 * @param s
	 * @return
	 * 2016年4月24日
	 * @author Jiupeng
	 * @description 481 test cases, 268ms
	 * @reference https://leetcode.com/problems/reverse-vowels-of-a-string/
	 * @interpretation
	 */
	public String reverseVowels(String s) {
		Set<Character> set = ReverseVowelsofaString.vowelSet;
		StringBuilder sb = new StringBuilder(s);
		int l = s.length(), i = 0, j = l - 1;
		while (i < j) {
			while (i < j && !set.contains(s.charAt(i)))
				++i;
			while (j > i && !set.contains(s.charAt(j)))
				--j;
			if (i < j) {
				String tmp = s.substring(i, i + 1);
				sb.replace(i, i + 1, s.substring(j, j + 1));
				sb.replace(j, j + 1, tmp);
				++i;
				--j;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "hello";
		String s2 = "wy";
		String s3 = "HELLO";
		ReverseVowelsofaString rvs = new ReverseVowelsofaString();
		System.out.println(rvs.reverseVowels(s3));
	}

}

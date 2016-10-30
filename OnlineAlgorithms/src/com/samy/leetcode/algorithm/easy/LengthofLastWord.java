package com.samy.leetcode.algorithm.easy;

public class LengthofLastWord {

	/**
	 * 
	 * @param s
	 * @return
	 * 2016Äê1ÔÂ18ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/length-of-last-word/
	 */
	public static int lengthOfLastWord(String s) {
		int i = s.length() - 1, j;
		while (i >= 0 && s.charAt(i) == ' ')
			--i;
		for (j = i; j >= 0 && s.charAt(j) != ' '; --j)
			;
		return i - j;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String t = " fefw fwefwef    ";
		System.out.println(lengthOfLastWord(t));
	}

}

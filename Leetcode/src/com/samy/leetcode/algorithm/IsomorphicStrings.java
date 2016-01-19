package com.samy.leetcode.algorithm;

public class IsomorphicStrings {

	/**
	 * 
	 * @param s
	 * @param t
	 * @return
	 * 2016年1月19日
	 * @author Jiupeng
	 * @description Nice ! 7ms beat 98.86%. 
	 * @reference https://leetcode.com/problems/isomorphic-strings/
	 */
	public boolean isIsomorphic(String s, String t) {
		int l = s.length();
		int[] code1 = new int[l];
		int[] code2 = new int[l];
		check(s, code1);
		check(t, code2);
		for (int i = 0; i < l; ++i) {
			if (code1[i] != code2[i])
				return false;
		}
		return true;
	}

	/**
	 * 
	 * @param s
	 * @param code
	 * 2016年1月19日
	 * @author Jiupeng
	 * @description encode the sequence, however, I did not consider the 0 situation, 0 is also a ascii
	 * @reference
	 */
	private void check(String s, int[] code) {
		byte[] alpha = new byte[256];
		byte mark = 1;
		for (int i = 0, l = s.length(); i < l; ++i) {
			char c = s.charAt(i);
			if (alpha[c] > 0) {
				code[i] = alpha[c];
			} else {
				alpha[c] = mark;
				code[i] = mark++;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

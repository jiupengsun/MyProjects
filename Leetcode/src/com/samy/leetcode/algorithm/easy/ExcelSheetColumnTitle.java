package com.samy.leetcode.algorithm.easy;

public class ExcelSheetColumnTitle {

	/**
	 * 
	 * @param n
	 * @return
	 * 2016Äê1ÔÂ26ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/excel-sheet-column-title/
	 */
	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while (n-- > 0) {
			sb.append((char) (n % 26 + 65));
			n /= 26;
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

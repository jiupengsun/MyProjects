package com.samy.leetcode.algorithm;

public class ExcelSheetColumnNumber {

	/**
	 * 
	 * @param s
	 * @return 2016Äê1ÔÂ12ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/excel-sheet-column-number/
	 */
	public static int titleToNumber(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); ++i) {
			// 'A' = 65
			sum = sum * 26 + s.charAt(i) - 64;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(titleToNumber(""));
		System.out.println(titleToNumber("A"));
		System.out.println(titleToNumber("D"));
		System.out.println(titleToNumber("Z"));
		System.out.println(titleToNumber("AA"));
		System.out.println(titleToNumber("AB"));
		System.out.println(titleToNumber("AAA"));
		System.out.println(titleToNumber("="));
	}

}

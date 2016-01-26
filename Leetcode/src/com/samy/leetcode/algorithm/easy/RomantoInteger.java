package com.samy.leetcode.algorithm.easy;

public class RomantoInteger {

	/**
	 * 
	 * @param s
	 * @return
	 * 2016年1月13日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/roman-to-integer/
	 */
	public static int romanToInt(String s) {
		int i = 0, sum = 0;
		// i+2<length
		while (i < s.length() - 1) {
			switch (s.substring(i, i + 2)) {
			case "IV": {
				//4
				sum += 4;
				i += 2;
			}
				break;
			case "IX": {
				//9
				sum += 9;
				i += 2;
			}
				break;
			case "XL": {
				//40
				sum += 40;
				i += 2;
			}
				break;
			case "XC": {
				//90
				sum += 90;
				i += 2;
			}
				break;
			case "CD": {
				//400
				sum += 400;
				i += 2;
			}
				break;
			case "CM": {
				//900
				sum += 900;
				i += 2;
			}
				break;
			default: {
				switch (s.charAt(i++)) {
				case 'I': {
					sum += 1;
				}
					break;
				case 'V': {
					sum += 5;
				}
					break;
				case 'X': {
					sum += 10;
				}
					break;
				case 'L': {
					sum += 50;
				}
					break;
				case 'C': {
					sum += 100;
				}
					break;
				case 'D': {
					sum += 500;
				}
					break;
				case 'M': {
					sum += 1000;
				}
					break;
				}
			}
			}
		}

		if (i == s.length() - 1) {
			switch (s.charAt(s.length() - 1)) {
			case 'I': {
				sum += 1;
			}
				break;
			case 'V': {
				sum += 5;
			}
				break;
			case 'X': {
				sum += 10;
			}
				break;
			case 'L': {
				sum += 50;
			}
				break;
			case 'C': {
				sum += 100;
			}
				break;
			case 'D': {
				sum += 500;
			}
				break;
			case 'M': {
				sum += 1000;
			}
				break;
			}
		}

		return sum;
	}

	/**
	 * 
	 * @param s
	 * @return
	 * 2016年1月13日
	 * @author Jiupeng
	 * @description Faster than mine
	 * @reference
	 */
	public int romanToIntSample(String s) {
		int num = 0, l = s.length(), last = 1000;
		for (int i = 0; i < l; i++) {
			int v = getValue(s.charAt(i));
			if (v > last)
				num = num - last * 2;
			num = num + v;
			last = v;
		}
		return num;
	}

	private int getValue(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("MCMXCVI"));
	}

}

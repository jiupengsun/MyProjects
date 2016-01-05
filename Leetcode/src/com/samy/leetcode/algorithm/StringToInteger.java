package com.samy.leetcode.algorithm;

public class StringToInteger {
	public static int myAtoi(String str) {
		int i = 0;
		while (i < str.length() && str.charAt(i) == ' ')
			++i;
		if (i == str.length())
			return 0;
		int sign = 0;
		if (str.charAt(i) == '+' || str.charAt(i) == '-')
			// +, sign = 44-43 = 1 > 0
			// -, sign = 44-45 = -1 < 0
			sign = 44 - str.charAt(i++);
		while (i < str.length() && str.charAt(i) == '0')
			++i;
		long num = 0;
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			num *= 10;
			// ascii 0 = 48
			num += str.charAt(i++) - 48;
			if (num > Integer.MAX_VALUE)
				return sign < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}

		return sign < 0 ? (int) -num : (int) num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myAtoi(""));
		System.out.println(myAtoi("010"));
		System.out.println(myAtoi("00000"));
		System.out.println(myAtoi("abcd"));
		System.out.println(myAtoi("+abcd"));
		System.out.println(myAtoi("-abcd  "));
		System.out.println(myAtoi("+0011"));
		System.out.println(myAtoi("00123"));
		System.out.println(myAtoi("-0012ab"));
		System.out.println(myAtoi("+00ab12"));
		System.out.println(myAtoi("1231232354432"));
		System.out.println(myAtoi("2147483649"));
		System.out.println(myAtoi("-2147483648"));
		System.out.println(myAtoi("-2147483649"));
	}

}

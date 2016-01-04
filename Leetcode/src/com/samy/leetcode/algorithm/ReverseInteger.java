package com.samy.leetcode.algorithm;

public class ReverseInteger {

	public static int reverse(int x) {
		long xl = 0;
		int i = 0;
		while (x != 0) {
			// if xl=0 and x%10=0, nothing changes
			xl = xl * 10 + x % 10;
			x /= 10;
		}
		if (xl > Integer.MAX_VALUE || xl < Integer.MIN_VALUE)
			return 0;
		return (int) xl;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 100000003;
		System.out.println(reverse(x));
	}

}

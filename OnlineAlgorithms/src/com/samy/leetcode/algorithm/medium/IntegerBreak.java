package com.samy.leetcode.algorithm.medium;

public class IntegerBreak {

	/**
	 * 
	 * @param n
	 * @return
	 * Apr 22, 2016
	 * @author Jiupeng
	 * @description 50 test cases, 1ms
	 * @reference https://leetcode.com/problems/integer-break/
	 * @interpretation
	 */
	public int integerBreak(int n) {
		int max = Integer.MIN_VALUE;
		int i = 2;
		while (true) {
			int d = n / i;
			int remainder = n - d * i;
			int j, tmp = 1;
			for (j = 1; j <= remainder; ++j)
				tmp *= (d + 1);
			for (; j <= i; ++j)
				tmp *= d;
			max = Math.max(max, tmp);
			if (d == 1)
				break;
			++i;
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

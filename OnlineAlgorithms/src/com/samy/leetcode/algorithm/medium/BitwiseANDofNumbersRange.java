package com.samy.leetcode.algorithm.medium;

public class BitwiseANDofNumbersRange {

	/**
	 * 
	 * @param m
	 * @param n
	 * @return
	 * 2016年3月28日
	 * @author Jiupeng
	 * @description 8266 test cases, 8ms beats 62.15%
	 * @reference https://leetcode.com/problems/bitwise-and-of-numbers-range/
	 * @interpretation
	 */
	public int rangeBitwiseAnd(int m, int n) {
		int s = 0x40000000, sum = 0;
		while (s > 0) {
			int a = s & m;
			int b = s & n;
			if (a > 0 && b > 0)
				sum += s;
			else if (a > 0 || b > 0)
				break;
			s >>= 1;
		}
		return sum;
	}

	/**
	 * 
	 * @param m
	 * @param n
	 * @return
	 * 2016年3月28日
	 * @author Jiupeng
	 * @description Indeed it's the same retionare with mine, however more subtle
	 * @reference https://leetcode.com/discuss/83738/java-8-ms-one-liner-o-1-no-loop-no-log
	 * @interpretation
	 */
	public int rangeBitwiseAndSample(int m, int n) {
		return m == n ? m : m & ~((highestOneBit(m ^ n) << 1) - 1);
	}

	private int highestOneBit(int m) {
		m |= (m >> 1);
		m |= (m >> 2);
		m |= (m >> 4);
		m |= (m >> 8);
		m |= (m >> 16);
		return m - (m >>> 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.highestOneBit(5 ^ 7));
	}

}

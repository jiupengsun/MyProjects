package com.samy.leetcode.algorithm;

public class PowerofThree {

	private final int[] pow = { 1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969,
			14348907, 43046721, 129140163, 387420489, 1162261467, 2147483647 };

	/**
	 * 
	 * @param n
	 * @return 2016年1月13日
	 * @author Jiupeng
	 * @description
	 * If N is a power of 3:
	 * It follows that 3^X == N
	 * It follows that log (3^X) == log N
	 * It follows that X log 3 == log N
	 * It follows that X == (log N) / (log 3)
	 * For the basis to hold, X must be an integer.
	 * However, due to precision issues that arise from the fact that log 3 cannot be precisely represented on a binary computer; 
	 * X is considered to be an integer if it's decimal component falls within a guard range of +/-0.00000000000001.
	 * @reference https://leetcode.com/problems/power-of-three/
	 */
	public boolean isPowerOfThree(int n) {
		double a = Math.log(n) / Math.log(3);
		return Math.abs(a - Math.rint(a)) <= 0.00000000000001;
	}

	/**
	 * 
	 * @param n
	 * @return
	 * 2016年1月13日
	 * @author Jiupeng
	 * @description Faster, utilizing the precision tricks
	 * @reference
	 */
	public boolean isPowerOfThreeSample(int n) {
		return n > 0 ? (1162261467 / n == 1162261467 / (double) n) : false;
	}

	public static void printBinary(int n) {
		int i = 31;
		while (i >= 0)
			System.out.print(((n >>> i--) & 0x1) + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1162261467 / 243d);
	}

}

package com.samy.leetcode.algorithm.easy;

public class FactorialTrailingZeroes {

	private final int[] pow5 = { 5, 25, 125, 625, 3125, 15625, 78125, 390625, 1953125, 9765625, 48828125, 244140625,
			1220703125, -1 };

	/**
	 * 
	 * @param n
	 * @return
	 * 2016年1月16日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/factorial-trailing-zeroes/
	 */
	public int trailingZeroes(int n) {
		int sum = 0, t, i = 0;
		while ((t = n / pow5[i++]) > 0)
			sum += t;
		return sum;
	}

	/**
	 * 
	 * @param n
	 * @return
	 * 2016年1月17日
	 * @author Jiupeng
	 * @description
	 * @reference https://en.wikipedia.org/wiki/Trailing_zero
	 * https://en.wikipedia.org/wiki/De_Polignac%27s_formula
	 */
	public int trailingZeroesSample(int n) {
		int count = 0;
		while (n > 1) {
			count += n / 5;
			n = n / 5;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mul = 1;
		for (int i = 1; i < 16; ++i) {
			mul *= 5;
			System.out.println(mul);
		}
	}

}

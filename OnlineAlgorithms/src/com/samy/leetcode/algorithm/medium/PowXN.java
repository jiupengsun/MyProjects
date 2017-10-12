package com.samy.leetcode.algorithm.medium;

public class PowXN {

	/**
	 *
	 * @param x
	 * @param n
	 * @return
	 * Apr 7, 2016
	 * @author Jiupeng
	 * @description 300 test cases, 2ms beats 4.92%
	 * @reference https://leetcode.com/problems/powx-n/
	 * @interpretation
	 */
	public double myPow(double x, int n) {
		x = helper(x, Math.abs(n));
		return n > 0 ? x : 1 / x;
	}

	private double helper(double x, int n) {
		if (n == 0)
			return 1d;
		double x2 = myPow(x, n >> 1);
		x2 *= x2;
		return (n & 1) == 0 ? x2 : x2 * x;
	}

  /**
   * using iterative method
   * @param x
   * @param n
   * @return
   */
	public double myPow2(double x, int n) {
	  // notice n may equal Integer.MIN_VALUE
    // then -n will overflow, so use long type here
		long exp = n;
		if(exp < 0) {
			x = 1 / x;
			exp = -exp;
		}
		double r = 1;
		while(exp > 0) {
			while(exp>0 && (exp&1) == 0) {
				x *= x;
				exp >>= 1;
			}
			r *= x;
			--exp;
		}
		return r;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = -1;
		System.out.println(n >>> 1);
	}

}

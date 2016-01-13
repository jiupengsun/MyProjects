package com.samy.leetcode.algorithm;

public class ClimbingStairs {

	/**
	 * 
	 * @param n
	 * @return
	 * 2016年1月13日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/climbing-stairs/
	 */
	public static int climbStairs(int n) {
		int sum = 1;
		for (int i = 1; i <= n / 2; ++i) {
			sum += combination(i + 1, n - 2 * i);
		}
		return sum;
	}

	/**
	 * 
	 * @param n
	 * @param i
	 * @return
	 * 2016年1月13日
	 * @author Jiupeng
	 * @description return Cni
	 * @reference
	 */
	private static int combination(int n, int i) {
		int sum = 1;
		while (i > 1)
			sum *= i--;
		return (int) Math.pow(n, i) / sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 35;
		System.out.println(climbStairs(n));
	}

}

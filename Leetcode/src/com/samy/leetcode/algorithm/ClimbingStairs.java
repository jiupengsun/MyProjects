package com.samy.leetcode.algorithm;

public class ClimbingStairs {

	/**
	 * 
	 * @param n
	 * @return
	 * 2016��1��13��
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/climbing-stairs/
	 */
	public static int climbStairs(int n) {
		int sum = 1;
		for (int i = 1; i <= n / 2; ++i) {
			sum += combination(n - i, i);
		}
		return sum;
	}

	public static int climbStairsSample(int n) {
		int step = 1;
		int prestep = 1;
		int temp = 0;
		while (--n > 0) {
			temp = step;
			step = step + prestep;
			prestep = temp;
		}
		return step;
	}

	/**
	 * 
	 * @param n
	 * @param i
	 * @return
	 * 2016��1��13��
	 * @author Jiupeng
	 * @description return Cni
	 * @reference
	 */
	private static int combination(int n, int i) {
		i = Math.min(i, n - i);
		long x = 1, y = 1;
		while (i >= 1) {
			x *= (n - i + 1);
			y *= i--;
		}
		return (int) (x / y);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; ++i) {
			System.out.println(Math.round(Math.random() * 69));
		}
		System.out.println(Math.round(Math.random() * 27));
	}

}

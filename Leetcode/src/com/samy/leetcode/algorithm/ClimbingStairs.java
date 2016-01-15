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
			sum += combination(n - i, i);
		}
		return sum;
	}

	/**
	 * 
	 * @param n
	 * @return
	 * 2016年1月14日
	 * @author Jiupeng
	 * @description Faster, this is the Fibonacci Number: F(n) = F(n-1) + F(n-2)
	 * @reference
	 */
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
	 * @return
	 * 2016年1月14日
	 * @author Jiupeng
	 * @description
	 * @reference https://en.wikipedia.org/wiki/Fibonacci_number
	 */
	public static int climbStairsSample2(int n) {
		++n;
		double sqrt5 = Math.sqrt(5);
		double ret = (1 / sqrt5)
				* (Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n));
		return (int) ret;
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

		System.out.println(climbStairs(10));
	}

}

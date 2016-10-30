package com.samy.leetcode.algorithm.medium;

public class PerfectSquares {

	/**
	 * 
	 * @param n
	 * @return
	 * 2016Äê3ÔÂ24ÈÕ
	 * @author Jiupeng
	 * @description 600 test cases, 60ms beats 88.88%
	 * @reference https://leetcode.com/problems/perfect-squares/
	 * @interpretation https://github.com/haoel/leetcode/commit/f874fde0ac8eb1aeeed3ff473ecf14b8e5c65433
	 * dp[n] = min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
	 */
	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		for (int i = 1, sqrt, min; i <= n; ++i) {
			sqrt = (int) Math.sqrt(i);
			min = Integer.MAX_VALUE;
			for (int j = sqrt; j > 0; --j) {
				min = Math.min(min, dp[i - j * j] + 1);
			}
			dp[i] = min;
		}
		return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PerfectSquares ps = new PerfectSquares();
		for (int i = 1; i <= 13; ++i)
			System.out.println(i + " " + ps.numSquares(i));
	}

}

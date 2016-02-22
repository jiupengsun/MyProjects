package com.samy.leetcode.algorithm.medium;

public class UniquePaths {

	/**
	 * 
	 * @param m
	 * @param n
	 * @return
	 * 2016年2月22日
	 * @author Jiupeng
	 * @description Math solution, calculate the combination C(m+n-1, m-1)
	 * Using following method to compute combination
	 * 61 test cases, 0ms beats 84.49%
	 * @reference https://leetcode.com/problems/unique-paths/
	 * @interpretation http://blog.csdn.net/perfumekristy/article/details/8713083
	 */
	public int uniquePaths(int m, int n) {
		int M = m + n - 2, N = m - 1 > (M >> 1) ? M - m + 1 : m - 1;
		return combination(M, N);
	}

	/**
	 * 
	 * @param m
	 * @return
	 * 2016年2月22日
	 * @author Jiupeng
	 * @description calculate the combination C(m, n)
	 * avoid overflowing
	 * @reference 
	 * @interpretation
	 */
	private int combination(int m, int n) {
		long com = 1;
		for (int i = 1; i <= n; ++i) {
			com = (m - n + i) * com / i;
		}
		return (int) com;
	}

	/**
	 * 
	 * @param m
	 * @param n
	 * @return
	 * 2016年2月22日
	 * @author Jiupeng
	 * @description
	 * @reference 
	 * @interpretation https://leetcode.com/discuss/70352/6-lines-java-0ms-solution
	 */
	public int uniquePathsSample(int m, int n) {
		int[] dp = new int[m];
		dp[0] = 1;
		for (int i = 0; i < n; i++)
			for (int j = 1; j < m; j++)
				dp[j] = dp[j - 1] + dp[j];
		return dp[m - 1];
	}

	/**
	 * 
	 * @param m
	 * @param n
	 * @return
	 * 2016年2月22日
	 * @author Jiupeng
	 * @description If using the below method to compute the combination, it's easier to overflow
	 * @reference https://leetcode.com/problems/unique-paths/
	 * @interpretation
	 */
	public int uniquePaths2(int m, int n) {
		int de = 1, mo = 1;
		for (int i = 0; i < m - 1; ++i) {
			de *= m + n - 2 - i;
			mo *= m - 1 - i;
		}
		return de / mo;
	}

	/**
	 * 
	 * @param m
	 * @param n
	 * @return
	 * 2016年2月22日
	 * @author Jiupeng
	 * @description DP Solution, however extremely slow
	 * @reference 
	 * @interpretation
	 */
	public int uniquePathsDP(int m, int n) {
		if (m == 1 || n == 1)
			return 1;
		return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 18, n = 18;
		UniquePaths up = new UniquePaths();
		up.uniquePathsSample(m, n);
	}

}

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
	 * @description first, image you have a m*n matrix, and you start from the left-top corner, to the right-bottom corner
	 * and at the beginning, the matrix[0][0] would be 1, means you only have one way to reach the position where you are
	 * and then if you want to move to the end of the first row, which is matrix[0][n-1], you only have one way to there, too
	 * you just need to move along the first row, to the rightmost position. Thus, you may set all values in the first row to 1
	 * and you move down, if you want to reach the bottom of the leftmost column. Similarly, you only have one way to be there, too
	 * thus you may set all values in the leftmost column to be one.
	 * Let's go further, if you want to reach the right end of second row, how many different paths you can choose?
	 * Let's say, if you want to get matrix[1][1], you can either move right firstly, then move down, or you can move down firstly, 
	 * then move right, so you will have two paths to be the position(1,1), and matrix[1][1] will equal 2. So how can we can this number?
	 * Obviously, we could know matrix[i][j] = matrix[i-1][j] + matrix[i][j-1], because if we can get the position (i-1,j) or (i, j-1),
	 * then we only have one way to be the destination -- move down or move right --, thus we use this formula matrix[i][j] = matrix[i-1][j] + matrix[i][j-1]
	 * to fill up all of the values in the matrix.
	 * Further more, do we really need o(m*n) space to help us finishing this task? Not really, through filling the matrix, we may see
	 * the filling task could be fulfilled layer by layer. Another saying, we could use only 1-dimension row array to present each row 
	 * of the matrix. And we fill the array again and again till n times (0,1,2...n-1). And finally we will get the result we want.
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

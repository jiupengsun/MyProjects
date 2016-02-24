package com.samy.leetcode.algorithm.medium;

public class MinimumPathSum {

	/**
	 * 
	 * @param grid
	 * @return
	 * 2016Äê2ÔÂ24ÈÕ
	 * @author Jiupeng
	 * @description 61 test cases, 4ms beats 53.72%
	 * @reference https://leetcode.com/problems/minimum-path-sum/
	 * @interpretation
	 */
	public int minPathSum(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		for (int i = 1; i < row; ++i)
			grid[i][0] += grid[i - 1][0];
		for (int j = 1; j < col; ++j)
			grid[0][j] += grid[0][j - 1];
		for (int i = 1; i < row; ++i)
			for (int j = 1; j < col; ++j) {
				grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
			}
		return grid[row - 1][col - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

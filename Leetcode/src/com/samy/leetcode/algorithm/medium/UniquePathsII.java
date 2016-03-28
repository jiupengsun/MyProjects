package com.samy.leetcode.algorithm.medium;

public class UniquePathsII {

	/**
	 * 
	 * @param obstacleGrid
	 * @return
	 * 2016Äê3ÔÂ28ÈÕ
	 * @author Jiupeng
	 * @description 43 test cases, 1ms beats 17.74%
	 * @reference https://leetcode.com/problems/unique-paths-ii/
	 * @interpretation
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length, n = m > 0 ? obstacleGrid[0].length : 0;
		int[] path = new int[n];
		path[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
		for (int i = 0; i < m; ++i) {
			path[0] = obstacleGrid[i][0] == 1 ? 0 : path[0];
			for (int j = 1; j < n; ++j)
				path[j] = obstacleGrid[i][j] == 0 ? path[j] + path[j - 1] : 0;
		}
		return path[n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 1, 0, 0, 0 }, { 0, 0, 0, 0 } };
		UniquePathsII up = new UniquePathsII();
		up.uniquePathsWithObstacles(grid);
	}

}

package com.samy.leetcode.algorithm.medium;

public class NumberofIslands {

	private final int[][] direction = new int[][] { { 0, -1 }, // left
			{ -1, 0 }, // up
			{ 0, 1 }, // right
			{ 1, 0 }// down
	};

	private int m;
	private int n;

	/**
	 * 
	 * @param grid
	 * @return
	 * Apr 8, 2016
	 * @author Jiupeng
	 * @description 45 test cases, 4ms beats 37.4% DFS solution
	 * @reference https://leetcode.com/problems/number-of-islands/
	 * @interpretation
	 * https://en.wikipedia.org/wiki/Depth-first_search
	 * http://www.geeksforgeeks.org/find-number-of-islands/
	 */
	public int numIslands(char[][] grid) {
		this.m = grid.length;
		this.n = m > 0 ? grid[0].length : 0;
		int count = 0;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				if (grid[i][j] == '1' && !visited[i][j]) {
					DFS(grid, i, j, visited);
					++count;
				}

		return count;
	}

	private void DFS(char[][] grid, int row, int col, boolean[][] visited) {
		if (row < 0 || col < 0 || row >= m || col >= n || visited[row][col] || grid[row][col] == '0')
			return;
		visited[row][col] = true;
		for (int d = 0; d < 4; ++d) {
			// four directions
			DFS(grid, row + direction[d][0], col + direction[d][1], visited);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid1 = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
		char[][] grid2 = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } };
		char[][] grid3 = new char[][] { { '1', '1', '1' }, { '0', '1', '0' }, { '1', '1', '1' } };
		char[][] grid4 = new char[][] { { '1', '0', '1', '1', '1' }, { '1', '0', '1', '0', '1' },
				{ '1', '1', '1', '0', '1' } };

		NumberofIslands ni = new NumberofIslands();
		System.out.println(ni.numIslands(grid4));

	}

}

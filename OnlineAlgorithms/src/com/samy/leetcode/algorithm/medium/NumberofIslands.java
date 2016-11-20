package com.samy.leetcode.algorithm.medium;

import java.util.LinkedList;
import java.util.Queue;

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
					//DFS(grid, i, j, visited);
					bfs(grid, m, n, i, j, visited);
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

	private void bfs(char[][] grid, int row, int col, int pos_i, int pos_j, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{pos_i, pos_j});
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			int i = pos[0], j= pos[1];
			if(!visited[i][j]) {
				visited[i][j] = true;
				// check the surrounding
				// left
				if(j>0 && grid[i][j-1]=='1' && !visited[i][j-1])
					queue.add(new int[]{i, j-1});
				// up
				if(i>0 && grid[i-1][j]=='1' && !visited[i-1][j])
					queue.add(new int[]{i-1, j});
				// right
				if(j<col-1 && grid[i][j+1]=='1' && !visited[i][j+1])
					queue.add(new int[]{i, j+1});
				// bottom
				if(i<row-1 && grid[i+1][j]=='1' && !visited[i+1][j])
					queue.add(new int[]{i+1, j});
			}
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
		String[] grid5_s = {"11111011111111101011","01111111111110111110","10111001101111111111","11110111111111111111","10011111111111111111","10111111011101110111","01111111111101101111","11111111111101111011","11111111110111111111","11111111111111111111","01111111011111111111","11111111111111111111","11111111111111111111","11111011111110111111","10111110111011110111","11111111111101111110","11111111111110111100","11111111111111111111","11111111111111111111","11111111111111111111"};
		char[][] grid5 = new char[grid5_s.length][grid5_s[0].length()];
		for(int i=0; i<grid5_s.length; ++i)
			grid5[i] = grid5_s[i].toCharArray();

		NumberofIslands ni = new NumberofIslands();
		System.out.println(ni.numIslands(grid5));

	}

}

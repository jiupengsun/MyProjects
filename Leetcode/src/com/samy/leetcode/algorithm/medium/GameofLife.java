package com.samy.leetcode.algorithm.medium;

public class GameofLife {

	/**
	 * 
	 * @param board
	 * 2016Äê3ÔÂ4ÈÕ
	 * @author Jiupeng
	 * @description 22 test cases, 1ms beats 13.28%
	 * @reference https://leetcode.com/problems/game-of-life/
	 * @interpretation
	 */
	public void gameOfLife(int[][] board) {
		int m = board.length;
		int n = m > 0 ? board[0].length : 0;
		int[] next = new int[m * n];
		int l = 0, i, j;
		for (j = 0; j < n; ++j)
			for (i = 0; i < m; ++i) {
				int left = j - 1 > 0 ? j - 1 : 0;
				int right = j + 1 < n - 1 ? j + 1 : n - 1;
				int top = i - 1 > 0 ? i - 1 : 0;
				int bottom = i + 1 < m - 1 ? i + 1 : m - 1;
				int count = 0;
				for (int jt = left; jt <= right; ++jt)
					for (int it = top; it <= bottom; ++it)
						count += board[it][jt];
				if (board[i][j] == 1) {
					//live
					if (count == 3 || count == 4)
						next[l] = 1;
				} else {
					//die
					if (count == 3)
						next[l] = 1;
				}
				++l;
			}
		for (l = 0, j = 0; j < n; ++j)
			for (i = 0; i < m; ++i)
				board[i][j] = next[l++];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

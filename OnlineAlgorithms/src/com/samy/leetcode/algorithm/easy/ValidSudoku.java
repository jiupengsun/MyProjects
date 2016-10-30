package com.samy.leetcode.algorithm.easy;

public class ValidSudoku {

	/**
	 * 
	 * @param board
	 * @return
	 * 2016Äê1ÔÂ17ÈÕ
	 * @author Jiupeng
	 * @description 4ms beats 73.45%, time complexity o(N^2), space complexity o(1)
	 * @reference https://leetcode.com/problems/valid-sudoku/
	 */
	public boolean isValidSudoku(char[][] board) {
		//[0,0]-[2,2] [0,3]-[2,5] [0,6]-[2,8]
		//[3,0]-[5,2] [3,3]-[5,5] [3,6]-[5,8]
		//[6,0]-[8,2] [6,3]-[8,5] [6,6]-[8,8]
		int i = 0, lt, ll, rb, rr;
		for (; i < 9; ++i) {
			int[] nums = new int[9];
			// check the matrix
			lt = i / 3 * 3;
			ll = (i % 3) * 3;
			rb = lt + 2;
			rr = ll + 2;
			for (int m = lt; m <= rb; ++m)
				for (int n = ll; n <= rr; ++n) {
					int t = board[m][n] - 48;
					if (t > 0) {
						if (nums[t - 1] != 0)
							return false;
						nums[t - 1] = t;
					}
				}
			// check the row and column
			nums = new int[9];
			for (int m = 0; m < 9; ++m) {
				int t = board[i][m] - 48;
				if (t > 0) {
					if (nums[t - 1] != 0)
						return false;
					nums[t - 1] = t;
				}
			}
			nums = new int[9];
			for (int m = 0; m < 9; ++m) {
				int t = board[m][i] - 48;
				if (t > 0) {
					if (nums[t - 1] != 0)
						return false;
					nums[t - 1] = t;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

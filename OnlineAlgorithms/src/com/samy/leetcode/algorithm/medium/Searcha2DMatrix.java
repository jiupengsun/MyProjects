package com.samy.leetcode.algorithm.medium;

public class Searcha2DMatrix {

	/**
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 * 2016Äê3ÔÂ7ÈÕ
	 * @author Jiupeng
	 * @description 134 test cases, 1ms beats 6.15%
	 * @reference https://leetcode.com/problems/search-a-2d-matrix/
	 * @interpretation
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length;
		int col = row > 0 ? matrix[0].length : 0;
		int i = 0, j = row - 1, mid = (i + j) >> 1;
		//search target from the last col
		while (i <= j) {
			if (target > matrix[mid][col - 1])
				i = mid + 1;
			else if (target < matrix[mid][col - 1])
				j = mid - 1;
			else
				return true;
			mid = (i + j) >> 1;
		}
		if (i < row && matrix[i][0] <= target) {
			int p = 0, q = col - 1;
			mid = (p + q) >> 1;
			while (p <= q) {
				if (target > matrix[i][mid])
					p = mid + 1;
				else if (target < matrix[i][mid])
					q = mid - 1;
				else
					return true;
				mid = (p + q) >> 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

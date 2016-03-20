package com.samy.leetcode.algorithm.medium;

public class SetMatrixZeroes {

	/**
	 * 
	 * @param matrix
	 * 2016年3月20日
	 * @author Jiupeng
	 * @description 157 test cases, 2ms beats 19.41%
	 * @reference https://leetcode.com/problems/set-matrix-zeroes/
	 * @interpretation
	 */
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = m > 0 ? matrix[0].length : 0;
		int[] row = new int[m];
		int[] col = new int[n];
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				if (matrix[i][j] == 0) {
					row[i] = 1;
					col[j] = 1;
				}
		for (int i = 0; i < m; ++i)
			if (row[i] == 1)
				for (int j = 0; j < n; ++j)
					matrix[i][j] = 0;

		for (int j = 0; j < n; ++j)
			if (col[j] == 1)
				for (int i = 0; i < m; ++i)
					matrix[i][j] = 0;

	}

	/**
	 * 
	 * @param matrix
	 * 2016年3月20日
	 * @author Jiupeng
	 * @description with constant space
	 * @reference 157 test cases, 2ms beats 19.41%
	 * @interpretation
	 */
	public void setZeroes2(int[][] matrix) {
		int m = matrix.length;
		int n = m > 0 ? matrix[0].length : 0;
		boolean row = false, col = false;
		for (int j = 0; j < n; ++j)
			if (matrix[0][j] == 0) {
				row = true;
				break;
			}
		for (int i = 0; i < m; ++i)
			if (matrix[i][0] == 0) {
				col = true;
				break;
			}

		for (int i = 1; i < m; ++i)
			for (int j = 1; j < n; ++j)
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
		for (int i = 1; i < m; ++i)
			if (matrix[i][0] == 0)
				for (int j = 0; j < n; ++j)
					matrix[i][j] = 0;
		for (int j = 1; j < n; ++j)
			if (matrix[0][j] == 0)
				for (int i = 0; i < m; ++i)
					matrix[i][j] = 0;
		if (row)
			for (int j = 0; j < n; ++j)
				matrix[0][j] = 0;
		if (col)
			for (int i = 0; i < m; ++i)
				matrix[i][0] = 0;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 0, 0, 0, 5 }, { 4, 3, 1, 4 }, { 0, 1, 1, 4 }, { 1, 2, 1, 3 }, { 0, 0, 1, 1 } };
		SetMatrixZeroes sz = new SetMatrixZeroes();
		sz.setZeroes2(matrix);
	}

}

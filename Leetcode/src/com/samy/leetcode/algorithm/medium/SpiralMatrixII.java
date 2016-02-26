package com.samy.leetcode.algorithm.medium;

public class SpiralMatrixII {

	/**
	 * 
	 * @param n
	 * @return
	 * 2016Äê2ÔÂ26ÈÕ
	 * @author Jiupeng
	 * @description 21 test cases, 0ms beats 14.96%
	 * @reference https://leetcode.com/problems/spiral-matrix-ii/
	 * @interpretation
	 */
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		//left, top, right, bottom
		int bottom = n - 1, top = 0, left = 0, right = n - 1;
		int i, j, st = 0;
		while (top <= bottom || left <= right) {
			//to the right
			if (top <= bottom) {
				for (i = top++, j = left; j <= right; ++j)
					matrix[i][j] = ++st;
			}
			//to the bottom
			if (left <= right) {
				for (i = top, j = right--; i <= bottom; ++i)
					matrix[i][j] = ++st;
			}
			//to the left
			if (top <= bottom) {
				for (i = bottom--, j = right; j >= left; --j)
					matrix[i][j] = ++st;
			}
			//to the top
			if (left <= right) {
				for (i = bottom, j = left++; i >= top; --i)
					matrix[i][j] = ++st;
			}
		}
		return matrix;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

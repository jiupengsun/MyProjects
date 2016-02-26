package com.samy.leetcode.algorithm.medium;

public class RotateImage {

	/**
	 * 
	 * @param matrix
	 * 2016Äê2ÔÂ26ÈÕ
	 * @author Jiupeng
	 * @description 20 test cases, 0ms beats 25.65%
	 * @reference https://leetcode.com/problems/rotate-image/
	 * @interpretation
	 */
	public void rotate(int[][] matrix) {
		for (int o = 0, l = matrix.length - 1; o < l; ++o, --l)
			for (int i = o, j = o, tmp, r; j < l; ++j) {
				tmp = matrix[i][j];
				r = l - j + o;
				matrix[i][j] = matrix[r][o];
				matrix[r][o] = matrix[l][r];
				matrix[l][r] = matrix[j][l];
				matrix[j][l] = tmp;
			}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

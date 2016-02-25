package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	/**
	 * 
	 * @param matrix
	 * @return
	 * 2016Äê2ÔÂ25ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/spiral-matrix/
	 * @interpretation
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> spiral = new ArrayList<Integer>();
		//left, top, right, bottom
		int bottom = matrix.length - 1, top = 0, left = 0;
		int right = bottom >= 0 ? matrix[0].length - 1 : -1;
		int i = top, j = left;
		while (top <= bottom || left <= right) {
			//to the right
			if (top <= bottom) {
				for (; j < right; ++j)
					spiral.add(matrix[i][j]);
				++top;
			}
			//to the bottom
			if (left <= right) {
				for (; i < bottom; ++i)
					spiral.add(matrix[i][j]);
				--right;
			}
			//to the left
			if (top <= bottom) {
				for (; j > left; --j)
					spiral.add(matrix[i][j]);
				--bottom;
			}
			//to the top
			if (left <= right) {
				for (; i > top; --i)
					spiral.add(matrix[i][j]);
				++left;
			}
		}
		return spiral;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		SpiralMatrix sm = new SpiralMatrix();
		sm.spiralOrder(matrix);
	}

}

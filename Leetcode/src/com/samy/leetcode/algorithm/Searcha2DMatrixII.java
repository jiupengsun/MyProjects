package com.samy.leetcode.algorithm;

public class Searcha2DMatrixII {

	/**
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 * 2016年1月17日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/search-a-2d-matrix-ii/
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length;
		int col = row != 0 ? matrix[0].length : 0;
		return searchSubMatrix(matrix, target, 0, 0, row - 1, col - 1);
	}

	private boolean searchSubMatrix(int[][] matrix, int target, int lt, int ll, int rb, int rr) {
		if (lt > rb || ll > rr)
			return false;
		//search in a row or a column
		int i, j;
		//a single row
		if (lt == rb) {
			int mid = (ll + rr) >> 1;
			for (i = ll, j = rr; i <= j && i <= rr && j <= rr; mid = (i + j) >> 1) {
				if (target < matrix[lt][mid])
					j = mid - 1;
				else if (target > matrix[lt][mid])
					i = mid + 1;
				else
					return true;
			}
			return false;
		}
		if (ll == rr) {
			int mid = (lt + rb) >> 1;
			for (i = lt, j = rb; i <= j && i <= rb && j <= rb; mid = (i + j) >> 1) {
				if (target < matrix[mid][ll])
					j = mid - 1;
				else if (target > matrix[mid][ll])
					i = mid + 1;
				else
					return true;
			}
			return false;
		}
		//
		for (i = lt, j = ll; i <= rb && j <= rr && matrix[i][j] < target; ++i, ++j)
			;
		if (i <= rb && j <= rr && matrix[i][j] == target)
			return true;
		return searchSubMatrix(matrix, target, lt, j, i - 1, rr) || searchSubMatrix(matrix, target, i, ll, rb, j - 1);
	}

	/**
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 * 2016年1月17日
	 * @author Jiupeng
	 * @description much faster, O(m+n)
	 * @reference
	 */
	public boolean searchMatrixSample(int[][] matrix, int target) {
		int m = matrix.length, n = matrix[0].length, i = 0, j = n - 1;
		while (i < m && j >= 0) {
			if (matrix[i][j] == target)
				return true;
			else if (matrix[i][j] < target)
				i++;
			else
				j--;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		int n = 15;
		Searcha2DMatrixII ss = new Searcha2DMatrixII();
		System.out.println(ss.searchMatrix(matrix, n));

	}

}

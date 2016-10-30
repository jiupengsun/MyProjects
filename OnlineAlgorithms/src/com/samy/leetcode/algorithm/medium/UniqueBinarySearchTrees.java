package com.samy.leetcode.algorithm.medium;

public class UniqueBinarySearchTrees {

	/**
	 * 
	 * @param n
	 * @return
	 * 2016Äê2ÔÂ18ÈÕ
	 * @author Jiupeng
	 * @description 10 test cases, 0ms beats 9.04%
	 * @reference https://leetcode.com/problems/unique-binary-search-trees/
	 * @interpretation
	 */
	public int numTrees(int n) {
		int[] nums = new int[n + 1];
		nums[0] = 1;
		nums[1] = 1;
		for (int i = 2, k, j; i <= n; ++i) {
			int sum = 0;
			for (k = 0, j = i - 1; k < j; ++k, --j) {
				sum += nums[k] * nums[j];
			}
			sum <<= 1;
			if (k == j)
				sum += nums[k] * nums[k];
			nums[i] = sum;
		}
		return nums[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

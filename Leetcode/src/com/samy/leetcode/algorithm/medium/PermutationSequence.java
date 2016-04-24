package com.samy.leetcode.algorithm.medium;

public class PermutationSequence {

	// factorial from 0 to 9
	private final int[] factorials = new int[] { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };
	// 
	private final int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	/**
	 * 
	 * @param n
	 * @param k
	 * @return
	 * 2016年4月24日
	 * @author Jiupeng
	 * @description 200 test cases, 2ms beats 77.48%
	 * @reference https://leetcode.com/problems/permutation-sequence/
	 * @interpretation
	 */
	public String getPermutation(int n, int k) {
		helper(nums, 0, k, n);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i)
			sb.append(nums[i]);
		return sb.toString();
	}

	private void helper(int[] nums, int st, int k, int n) {
		int i = n - st;
		if (i == 1)
			return;
		int index = (k - 1) / factorials[i - 1];
		int tmp = nums[st + index];
		for (int j = st + index; j > st; --j)
			nums[j] = nums[j - 1];
		nums[st] = tmp;
		helper(nums, st + 1, k - index * factorials[i - 1], n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

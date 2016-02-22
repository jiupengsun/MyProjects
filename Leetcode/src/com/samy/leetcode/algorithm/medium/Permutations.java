package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016Äê2ÔÂ22ÈÕ
	 * @author Jiupeng
	 * @description 25 test cases, 2ms beats 93.8%
	 * @reference https://leetcode.com/problems/permutations/
	 * @interpretation
	 */
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> collection = new ArrayList<List<Integer>>();
		permutation(nums, 0, collection);
		return collection;
	}

	private void permutation(int[] nums, int st, List<List<Integer>> collection) {
		if (st == nums.length - 1) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i : nums)
				list.add(i);
			collection.add(list);
			return;
		}
		for (int i = st, l = nums.length; i < l; ++i) {
			//exchange
			int tmp = nums[st];
			nums[st] = nums[i];
			nums[i] = tmp;
			//permute elements after st
			permutation(nums, st + 1, collection);
			//exchange back
			tmp = nums[st];
			nums[st] = nums[i];
			nums[i] = tmp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 4 };
		Permutations perm = new Permutations();
		perm.permute(nums);
	}

}

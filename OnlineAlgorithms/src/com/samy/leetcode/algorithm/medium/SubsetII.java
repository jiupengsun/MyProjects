package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016Äê3ÔÂ28ÈÕ
	 * @author Jiupeng
	 * @description 19 test cases, 3ms beats 41.85%
	 * @reference https://leetcode.com/problems/subsets-ii/
	 * @interpretation
	 */
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> sets = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int last = 0, l = nums.length;
		sets.add(new ArrayList<Integer>());
		if (l > 0) {
			List<Integer> set = new ArrayList<Integer>();
			set.add(nums[0]);
			sets.add(set);
			last = 1;
		}
		for (int i = 1, j, size; i < l; ++i) {
			if (nums[i] != nums[i - 1]) {
				for (j = 0, last = sets.size(); j < last; ++j) {
					List<Integer> set = new ArrayList<Integer>();
					set.addAll(sets.get(j));
					set.add(nums[i]);
					sets.add(set);
				}
			} else {
				for (j = last, size = sets.size(); j > 0; --j) {
					List<Integer> set = new ArrayList<Integer>();
					set.addAll(sets.get(size - j));
					set.add(nums[i]);
					sets.add(set);
				}
			}
		}
		return sets;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

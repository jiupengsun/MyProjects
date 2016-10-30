package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	/**
	 * 
	 * @param candidates
	 * @param target
	 * @return
	 * 2016Äê2ÔÂ24ÈÕ
	 * @author Jiupeng
	 * @description 172 test cases, 6ms beats 70.29%
	 * @reference https://leetcode.com/problems/combination-sum-ii/
	 * @interpretation
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		return helper(candidates, target, candidates.length - 1);
	}

	private List<List<Integer>> helper(int[] candidates, int target, int end) {
		List<List<Integer>> collection = new ArrayList<List<Integer>>();
		if (target == 0)
			collection.add(new ArrayList<Integer>());
		else {
			while (end >= 0 && target < candidates[end])
				--end;
			if (end >= 0) {
				List<List<Integer>> colSub = helper(candidates,
						target - candidates[end], end - 1);
				for (List<Integer> list : colSub) {
					list.add(candidates[end]);
					collection.add(list);
				}
				while (end > 0 && candidates[end - 1] == candidates[end])
					--end;
				colSub = helper(candidates, target, end - 1);
				collection.addAll(colSub);
			}
		}
		return collection;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

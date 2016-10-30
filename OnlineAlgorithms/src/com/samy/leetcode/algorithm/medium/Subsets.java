package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016Äê3ÔÂ27ÈÕ
	 * @author Jiupeng
	 * @description 10 test cases, 3ms beats 15.24%
	 * @reference https://leetcode.com/problems/subsets/
	 * @interpretation
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> sets = new ArrayList<List<Integer>>();
		sets.add(new ArrayList<Integer>());
		for (int i : nums) {
			for (int j = 0, l = sets.size(); j < l; ++j) {
				List<Integer> newSet = new ArrayList<Integer>();
				newSet.addAll(sets.get(j));
				int m = 0, n = newSet.size();
				while (m < n && newSet.get(m) < i)
					++m;
				newSet.add(m, i);
				sets.add(newSet);
			}
		}
		return sets;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

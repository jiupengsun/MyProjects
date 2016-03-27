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
	 * @description
	 * @reference https://leetcode.com/problems/subsets/
	 * @interpretation
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> sets = new ArrayList<List<Integer>>();
		for (int i = 0, l = nums.length; i <= l; ++i) {
			List<Integer> set = new ArrayList<Integer>();
			for (int j = i, k; j > 0; --j) {

			}
		}
		return sets;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

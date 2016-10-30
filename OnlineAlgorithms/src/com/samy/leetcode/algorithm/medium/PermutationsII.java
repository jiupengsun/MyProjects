package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {

	/**
	 * 
	 * @param nums
	 * @return
	 * Apr 6, 2016
	 * @author Jiupeng
	 * @description 30 test cases, 20ms beats 21.68%
	 * @reference https://leetcode.com/problems/permutations-ii/
	 * @interpretation http://www.programcreek.com/2013/02/leetcode-permutations-ii-java/
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> perm = new ArrayList<List<Integer>>();
		perm.add(new ArrayList<Integer>());
		for (int i : nums) {
			Set<List<Integer>> set = new HashSet<List<Integer>>();
			for (List<Integer> list : perm) {
				for (int j = 0, l = list.size(); j <= l; ++j) {
					List<Integer> newL = new ArrayList<Integer>(list);
					newL.add(j, i);
					set.add(newL);
				}
			}
			perm = new ArrayList<List<Integer>>(set);
		}

		return perm;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		List<Integer> list2 = new ArrayList<Integer>();
		set.add(list1);
		list2.add(2);
		set.add(list2);
		System.out.println(list1.equals(list2));
		System.out.println(set.size());
	}

}

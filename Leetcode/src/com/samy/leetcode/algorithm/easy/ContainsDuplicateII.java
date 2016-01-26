package com.samy.leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateII {

	/**
	 * 
	 * @param nums
	 * @param k
	 * @return
	 * 2016年1月18日
	 * @author Jiupeng
	 * @description Much faster, 20 test cases, 9ms only
	 * @reference https://leetcode.com/problems/contains-duplicate-ii/
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
		int i = 0, l = nums.length, t = l < (++k) ? l : k;
		while (i < t) {
			if (!set.add(nums[i++]))
				return true;
		}
		while (i < l) {
			set.remove(nums[i - k]);
			if (!set.add(nums[i++]))
				return true;
		}
		return false;
	}

	/**
	 * 
	 * @param nums
	 * @param k
	 * @return
	 * 2016年1月18日
	 * @author Jiupeng
	 * @description Fastest sample from leetcode discuss area
	 * @reference https://leetcode.com/discuss/80031/3ms-java-solution-without-using-hashmap
	 */
	public boolean containsNearbyDuplicateSample(int[] nums, int k) {
		int[] sorted = Arrays.copyOf(nums, nums.length);
		Arrays.sort(sorted);
		ArrayList<Integer> duplicate = new ArrayList<>();
		for (int i = 0; i < sorted.length - 1; i++) {
			if (sorted[i] == sorted[i + 1] && !duplicate.contains(sorted[i])) {
				duplicate.add(sorted[i]);
			}
		}

		for (int x : duplicate) {
			ArrayList<Integer> indexes = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == x) {
					indexes.add(i);
				}
			}
			for (int i = 0; i < indexes.size() - 1; i++) {
				if (indexes.get(i + 1) - indexes.get(i) <= k)
					return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param nums
	 * @param k
	 * @return
	 * 2016年1月18日
	 * @author Jiupeng
	 * @description it works, however takes too long time
	 * @reference
	 */
	public boolean containsNearbyDuplicate2(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int l = nums.length;
		Integer j = null;
		for (int i = 0; i < l; ++i) {
			if ((j = map.get(nums[i])) != null && (i - j.intValue()) <= k)
				return true;
			else
				map.put(nums[i], i);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Integer i = map.get(5);
		System.out.println(i.intValue());
	}

}

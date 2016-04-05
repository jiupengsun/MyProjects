package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum {

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016Äê3ÔÂ31ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/3sum/
	 * @interpretation
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> sumList = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int l = nums.length, last = Integer.MAX_VALUE;
		for (int i = 0; i < l - 2; ++i) {
			if (nums[i] == last)
				continue;
			last = nums[i];
			twoSum(sumList, nums, -nums[i], i + 1, l - 1);
		}

		return sumList;
	}

	private void twoSum(List<List<Integer>> sumList, int[] nums, int target,
			int st, int en) {
		int last = Integer.MAX_VALUE;
		while (st < en) {
			if (nums[st] == last) {
				++st;
				continue;
			}
			last = nums[st];
			int sum = nums[st] + nums[en];
			if (sum == target) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(target);
				list.add(nums[st]);
				list.add(nums[en]);
				sumList.add(list);
				++st;
			} else if (sum > target)
				--en;
			else
				++st;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sum = new int[] { -1, 0, 1, 2, -1, -4 };
		_3Sum three = new _3Sum();
		three.threeSum(sum);
	}

}

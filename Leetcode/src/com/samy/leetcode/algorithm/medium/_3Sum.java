package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum {

	/**
	 * 
	 * @param nums
	 * @return Apr 6, 2016
	 * @author Jiupeng
	 * @description 311 test cases, 10ms beats 24.81%
	 * @reference https://leetcode.com/problems/3sum/
	 * @interpretation http://www.sigmainfy.com/blog/summary-of-ksum-problems.
	 *                 html
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> sumList = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0, l = nums.length; i < l - 2; ++i) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			twoSum(sumList, nums, i, i + 1, l - 1);
		}

		return sumList;
	}

	private void twoSum(List<List<Integer>> sumList, int[] nums, int target, int st, int en) {
		while (st < en) {
			if (st > target + 1 && nums[st] == nums[st - 1]) {
				++st;
				continue;
			}
			int sum = nums[st] + nums[en] + nums[target];
			if (sum == 0) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(nums[target]);
				list.add(nums[st++]);
				list.add(nums[en--]);
				sumList.add(list);
			} else if (sum > 0)
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

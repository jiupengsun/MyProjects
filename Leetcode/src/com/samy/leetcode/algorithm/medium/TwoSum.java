package com.samy.leetcode.algorithm.medium;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	/**
	 * 
	 * @param nums
	 * @param target
	 * @return
	 * 2016Äê1ÔÂ18ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/two-sum/
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[0] = map.get(target - nums[i]) + 1;
				result[1] = i + 1;
				return result;
			} else {
				map.put(nums[i], i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

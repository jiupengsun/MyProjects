package com.samy.leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016Äê1ÔÂ25ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/summary-ranges/
	 */
	public List<String> summaryRanges(int[] nums) {
		List<String> ranges = new ArrayList<String>();
		int i = 0, j = 1, l = nums.length;
		while (j <= l - 1) {
			while (j < l && nums[j] == nums[j - 1] + 1)
				++j;
			if (i != j - 1)
				ranges.add(nums[i] + "->" + nums[j - 1]);
			else
				ranges.add(nums[i] + "");
			i = j++;
		}
		if (i < l)
			ranges.add(String.valueOf(nums[i]));
		return ranges;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

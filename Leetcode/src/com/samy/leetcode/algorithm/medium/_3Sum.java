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
		for (int i = 0, l = nums.length; i < l - 3; ++i) {
			int st = i + 1, en = l - 1;
			for (; st < en;) {
				int sum = nums[i] + nums[st] + nums[en];
				if (sum == 0) {
					if (sumList.size() > 0) {
						List<Integer> lastList = sumList.get(sumList.size() - 1);
						if (nums[i] == lastList.get(0) && nums[st] == lastList.get(1)
								&& nums[en] == lastList.get(2))
							continue;
					}
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[i]);
					list.add(nums[st]);
					list.add(nums[en]);
					sumList.add(list);
					--en;
				} else if (sum > 0)
					--en;
				else
					++st;
			}
		}
		return sumList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

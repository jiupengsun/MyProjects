package com.samy.leetcode.algorithm.easy;

import java.util.Arrays;

public class MajorityElement {

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016Äê1ÔÂ12ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/majority-element/
	 */
	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	public int majorityElement2(int[] nums) {
		int majority = nums[0], t = 0;
		for (int i : nums) {
			if (i == majority) {
				++t;
				/*
				 * do not judge big or small here, it would more slower
				 */
				/*if (t >= length / 2)
					break;*/
			} else if (t > 0)
				--t;
			else {
				majority = i;
				t = 1;
			}
		}
		return majority;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

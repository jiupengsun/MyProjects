package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

	/**
	 * 
	 * @param nums
	 * @return
	 * Apr 10, 2016
	 * @author Jiupeng
	 * @description 65 test cases, 3ms beats 74.81%
	 * @reference https://leetcode.com/problems/majority-element-ii/
	 * @interpretation http://www.programcreek.com/2014/07/leetcode-majority-element-ii-java/
	 */
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		int l = nums.length;
		if (l == 0)
			return list;
		int c1 = 0, c2 = 0;
		int n1 = 0, n2 = 0;
		n1 = nums[0];
		int i = 0;
		while (i < l && nums[i] == n1) {
			++i;
			++c1;
		}
		if (i < l) {
			n2 = nums[i++];
			++c2;
		}
		for (; i < l; ++i) {
			if (nums[i] == n1) {
				++c1;
			} else if (nums[i] == n2) {
				++c2;
			} else if (c1 == 0) {
				n1 = nums[i];
				c1 = 1;
			} else if (c2 == 0) {
				n2 = nums[i];
				c2 = 1;
			} else {
				--c1;
				--c2;
			}
		}
		c1 = c2 = 0;
		for (int n : nums) {
			if (n == n1)
				++c1;
			else if (n == n2)
				++c2;
		}
		if (c1 > l / 3)
			list.add(n1);
		if (c2 > l / 3)
			list.add(n2);
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package com.samy.leetcode.algorithm.medium;

public class FindPeakElement {

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016年3月21日
	 * @author Jiupeng
	 * @description 58 test cases, 1ms beats 2.23%
	 * @reference https://leetcode.com/problems/find-peak-element/
	 * @interpretation
	 */
	public int findPeakElement(int[] nums) {
		int i = 1;
		while (i < nums.length && nums[i] > nums[i - 1])
			++i;
		return i - 1;
	}

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016年3月21日
	 * @author Jiupeng
	 * @description 58 test cases, 0ms beats 27.16%
	 * @reference https://leetcode.com/discuss/88467/tricky-problem-tricky-solution
	 * @interpretation
	 */
	public int findPeakElementSample(int[] nums) {
		int st = 0, en = nums.length - 1, mid;
		while (st < en) {
			mid = (st + en) >> 1;
			if (nums[mid] < nums[mid + 1])
				st = mid + 1;
			else
				en = mid;
		}
		return st;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

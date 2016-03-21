package com.samy.leetcode.algorithm.medium;

import java.util.Arrays;

public class KthLargestElementinanArray {

	/**
	 * 
	 * @param nums
	 * @param k
	 * @return
	 * 2016年3月21日
	 * @author Jiupeng
	 * @description 31 test cases, 4ms beats 80.07%
	 * @reference https://leetcode.com/problems/kth-largest-element-in-an-array/
	 * @interpretation
	 */
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	/**
	 * 
	 * @param nums
	 * @param k
	 * @return
	 * 2016年3月21日
	 * @author Jiupeng
	 * @description 31 test cases, 130ms beats 2.49%
	 * @reference 
	 * @interpretation https://en.wikipedia.org/wiki/Selection_algorithm
	 * http://c3p0demo.googlecode.com/svn/trunk/scalaDemo/script/Order_statistics.ppt
	 */
	public int findKthLargest2(int[] nums, int k) {
		for (int i = 0, l = nums.length; i < k; ++i) {
			for (int j = i + 1; j < l; ++j) {
				if (nums[j] > nums[i]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		return nums[k - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

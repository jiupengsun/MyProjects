package com.samy.leetcode.algorithm.easy;

public class RemoveElement {

	/**
	 * 
	 * @param nums
	 * @param val
	 * @return
	 * 2016年1月14日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/remove-element/
	 */
	public int removeElement(int[] nums, int val) {
		int length = nums.length, tmp;
		for (int i = 0; i < length; ++i) {
			if (nums[i] == val) {
				while (length > i && nums[length - 1] == val)
					--length;
				if (length > i) {
					tmp = nums[i];
					nums[i] = nums[length - 1];
					nums[(length--) - 1] = tmp;
				}
			}
		}
		return length;
	}

	/**
	 * 
	 * @param nums
	 * @param val
	 * @return
	 * 2016年1月14日
	 * @author Jiupeng
	 * @description More cleaner and better
	 * @reference https://leetcode.com/discuss/71535/my-easy-java-solution-1ms
	 */
	public int removeElementSample(int[] nums, int val) {
		int n = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val)
				nums[n++] = nums[i];
		}
		return (n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package com.samy.algorithm;

public class FindSubarraySum {

	/**
	 * 
	 * @param nums
	 * @param n
	 * @return
	 * 2016Äê1ÔÂ17ÈÕ
	 * @author Jiupeng
	 * @description check if there is a subarray in array nums, that the sum of the subarray equals n
	 * @reference
	 */
	public boolean findSubarray(int[] nums, int n) {
		return findSubarrayFrom(nums, n, 0);
	}

	private boolean findSubarrayFrom(int[] nums, int n, int st) {
		if (st == nums.length)
			return false;
		if (nums[st] == n)
			return true;
		return findSubarrayFrom(nums, n - nums[st], st + 1) | findSubarrayFrom(nums, n, st + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 3, 5, 7, 9, 11 };
		int n = 12;
		FindSubarraySum fu = new FindSubarraySum();
		System.out.println(fu.findSubarray(nums, n));
	}

}

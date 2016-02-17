package com.samy.leetcode.algorithm.medium;

public class IncreasingTripletSubsequence {

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016年2月17日
	 * @author Jiupeng
	 * @description 61 test cases, 2ms
	 * @reference https://leetcode.com/problems/increasing-triplet-subsequence/
	 * @interpretation 
	 */
	public boolean increasingTriplet(int[] nums) {
		int length = nums.length;
		if (length < 3)
			return false;
		int[] seq = new int[3];
		seq[0] = nums[0];
		int count = 0, min = nums[0];
		for (int i = 1; i < length && count < 2; ++i) {
			if (nums[i] > seq[count]) {
				seq[++count] = nums[i];
			} else if (nums[i] < seq[count]) {
				if (count == 0 || nums[i] > seq[count - 1])
					seq[count] = nums[i];
				else if (nums[i] > min) {
					seq[count - 1] = min;
					seq[count] = nums[i];
				} else
					min = nums[i];
			}
		}
		return count == 2 ? true : false;
	}

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016年2月17日
	 * @author Jiupeng
	 * @description 1ms, very clean and faster. We can expand this method to more-numbers solution
	 * let's say, find four increasing sequence, then we could use three initial numbers, and follow
	 * the same step like following
	 * @reference 
	 * @interpretation https://leetcode.com/discuss/86780/java-1ms-clean-solution
	 */
	public boolean increasingTripletSample(int[] nums) {
		int length = nums.length;
		if (length < 3)
			return false;
		int min = Integer.MAX_VALUE, max = Integer.MAX_VALUE;
		int i = -1;
		while ((++i) < length) {
			if (nums[i] > max)
				return true;
			if (nums[i] > min)
				max = nums[i];
			else
				min = nums[i];
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

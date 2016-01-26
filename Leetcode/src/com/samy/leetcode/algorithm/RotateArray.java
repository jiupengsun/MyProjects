package com.samy.leetcode.algorithm;

import java.util.Arrays;

public class RotateArray {

	/**
	 * 
	 * @param nums
	 * @param k
	 * 2016年1月26日
	 * @author Jiupeng
	 * @description o(k) space and o(n) time complexity
	 * @reference https://leetcode.com/problems/rotate-array/
	 */
	public void rotate(int[] nums, int k) {
		int l = nums.length;
		k %= l;
		int[] head = Arrays.copyOfRange(nums, 0, l - k);
		for (int i = 0; i < k; ++i)
			nums[i] = nums[l - k + i];
		for (int i = k; i < l; ++i) {
			nums[i] = head[i - k];
		}
	}

	/**
	 * 
	 * @param nums
	 * @param k
	 * 2016年1月26日
	 * @author Jiupeng
	 * @description o(1) space and o(n) complexity, find the next position using the current value
	 * @reference
	 */
	public void rotate2(int[] nums, int k) {
		int l = nums.length;
		k %= l;
		if (k > 0) {
			for (int st = 0, current, last = nums[0], swap, step = l; step > 0; ++st) {
				current = st;
				do {
					swap = nums[current];
					nums[current] = last;
					last = swap;
					current = (current + k) % l;
					--step;
				} while (current != st);
				nums[st] = last;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 4, 5, 6 };
		int k = 2;
		RotateArray ra = new RotateArray();
		ra.rotate2(nums, k);
		for (int i : nums)
			System.out.print(i);
	}

}

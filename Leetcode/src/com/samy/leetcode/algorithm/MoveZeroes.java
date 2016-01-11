package com.samy.leetcode.algorithm;

public class MoveZeroes {

	public static void moveZeroes(int[] nums) {
		int i = 0, j = 0, length = nums.length;
		for (; j < length; ++j) {
			if (nums[j] == 0)
				++j;
			if (nums[i] != 0)
				++i;
			nums[i++] = nums[j];
			nums[j] = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

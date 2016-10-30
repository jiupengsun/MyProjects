package com.samy.leetcode.algorithm.easy;

public class MoveZeroes {

	/**
	 * 
	 * @param nums
	 *          2016Äê1ÔÂ11ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/move-zeroes/
	 */
	public static void moveZeroes(int[] nums) {
		int i = 0, j = 0, length = nums.length;
		while (true) {
			// find i that nums[i] = 0
			while (i < length && nums[i] != 0)
				++i;
			// no zero in the array
			if (i == length)
				break;
			// find j that nums[j] != 0
			// all numbers in the array are 0
			while (j < length && nums[j] == 0)
				++j;
			if (j == length)
				break;
			// find!
			// 0 is after non-0, continue searching with j=i+1
			if (j < i) {
				j = i + 1;
			} else {
				nums[i++] = nums[j];
				nums[j++] = 0;
			}
		}
	}

	public static void print(int[] nums) {
		for (int i : nums)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n1 = {};
		int[] n2 = { 1 };
		int[] n3 = { 1, 2, 3 };
		int[] n4 = { 0, 1, 2, 3 };
		int[] n5 = { 0, 1, 0, 3, 12 };
		int[] n6 = { 0, 0, 0, 0, 0 };
		int[] n7 = { 1, 2, 0, 3, 4 };
		int[] n8 = { 1, 2, 3, 0, 0 };
		moveZeroes(n1);
		System.out.print("n1: ");
		print(n1);

		moveZeroes(n2);
		System.out.print("n2: ");
		print(n2);

		moveZeroes(n3);
		System.out.print("n3: ");
		print(n3);

		moveZeroes(n4);
		System.out.print("n4: ");
		print(n4);

		moveZeroes(n5);
		System.out.print("n5: ");
		print(n5);

		moveZeroes(n6);
		System.out.print("n6: ");
		print(n6);

		moveZeroes(n7);
		System.out.print("n7: ");
		print(n7);

		moveZeroes(n8);
		System.out.print("n8: ");
		print(n8);
	}

}

package com.samy.leetcode.algorithm.medium;

public class ProductofArrayExceptSelf {

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016Äê2ÔÂ15ÈÕ
	 * @author Jiupeng
	 * @description 17 test cases, 2ms beats 48.07%
	 * @reference https://leetcode.com/problems/product-of-array-except-self/
	 * @interpretation
	 */
	public static int[] productExceptSelf(int[] nums) {
		int l = nums.length, left = 1, right = 1;
		int[] product = new int[l];
		for (int i = 0; i < l; ++i) {
			product[i] = left;
			left *= nums[i];
		}
		for (int j = l - 1; j >= 0; --j) {
			product[j] *= right;
			right *= nums[j];
		}
		return product;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 4 };
		for (int i : productExceptSelf(nums)) {
			System.out.print(i + " ");
		}
	}

}

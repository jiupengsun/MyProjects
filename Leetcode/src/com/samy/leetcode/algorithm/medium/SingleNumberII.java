package com.samy.leetcode.algorithm.medium;

public class SingleNumberII {

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016Äê1ÔÂ30ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/single-number-ii/
	 * @interpretation http://traceformula.blogspot.com/2015/08/single-number-ii-how-to-come-up-with.html
	 */
	public int singleNumber(int[] nums) {
		int p = 0, q = 0;
		for (int i = 0, l = nums.length; i < l; ++i) {
			p = q & (p ^ nums[i]);
			q = p | (q ^ nums[i]);
		}
		return q;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

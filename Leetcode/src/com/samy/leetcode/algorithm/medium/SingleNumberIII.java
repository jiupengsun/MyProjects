package com.samy.leetcode.algorithm.medium;

public class SingleNumberIII {
	//The two numbers that appear only once must differ at some bit, this is how we can distinguish between them. Otherwise, they will be one of the duplicate numbers.
	//Let¡¯s say the at the ith bit, the two desired numbers differ from each other. which means one number has bit i equaling: 0, the other number has bit i equaling 1.
	//Thus, all the numbers can be partitioned into two groups according to their bits at location i. the first group consists of all numbers whose bits at i is 0. the second group consists of all numbers whose bits at i is 1.
	//Notice that, if a duplicate number has bit i as 0, then, two copies of it will belong to the first group. Similarly, if a duplicate number has bit i as 1, then, two copies of it will belong to the second group.
	//by XoRing all numbers in the first group, we can get the first number. by XoRing all numbers in the second group, we can get the second number.

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016Äê1ÔÂ29ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/single-number-iii/
	 * @interpretation: http://yuancrackcode.com/2015/10/21/single-number-iii/
	 */
	public int[] singleNumber(int[] nums) {
		int xor = 0;
		for (int i : nums)
			xor ^= i;
		// get the first bit that not equals zero
		xor &= -xor;
		int x0 = 0, x1 = 0;
		for (int i : nums) {
			if ((i & xor) == 0) {
				x0 ^= i;
			} else
				x1 ^= i;
		}
		return new int[] { x0, x1 };
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0;
		System.out.println((x &= -x));
	}

}

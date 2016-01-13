package com.samy.leetcode.algorithm;

public class Numberof1Bits {
	/**
	 * 
	 * @param n
	 * @return
	 * 2016Äê1ÔÂ13ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/number-of-1-bits/
	 */
	public int hammingWeight(int n) {
		n = ((n & 0xAAAAAAAA) >>> 1) + (n & 0x55555555);
		n = ((n & 0xCCCCCCCC) >>> 2) + (n & 0x33333333);
		n = ((n & 0xF0F0F0F0) >>> 4) + (n & 0x0F0F0F0F);
		n = ((n & 0xFF00FF00) >>> 8) + (n & 0x00FF00FF);
		n = ((n & 0xFFFF0000) >>> 16) + (n & 0x0000FFFF);
		return n;
	}

	public int hammingWeight2(int n) {
		int sum = 0, i = 0;
		while (i < 32) {
			if (((n >> (i++)) & 1) == 1)
				++sum;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Numberof1Bits nb = new Numberof1Bits();
		int[] n = { 1, 2, 10, 124, 342354, -123, Integer.MAX_VALUE,
				Integer.MIN_VALUE };
		for (int i : n) {
			System.out
					.println(i + ": " + nb.hammingWeight(i) + " " + nb.hammingWeight2(i));
		}

	}

}

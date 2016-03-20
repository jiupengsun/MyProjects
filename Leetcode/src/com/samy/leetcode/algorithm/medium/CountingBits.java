package com.samy.leetcode.algorithm.medium;

public class CountingBits {

	/**
	 * 
	 * @param num
	 * @return
	 * 2016年3月19日
	 * @author Jiupeng
	 * @description 16 test cases passed, 3ms
	 * @reference https://leetcode.com/problems/counting-bits/
	 * @interpretation
	 */
	public int[] countBitsByHint(int num) {
		int[] bits = new int[num + 1];
		int l_bound = 1, h_bound = 0;
		while (h_bound < num) {
			h_bound = Math.min((l_bound << 1) - 1, num);
			for (int j = l_bound; j <= h_bound; ++j)
				bits[j] = bits[j - l_bound] + 1;
			l_bound <<= 1;
		}
		return bits;
	}

	/**
	 * 
	 * @param num
	 * @return
	 * 2016年3月19日
	 * @author Jiupeng
	 * @description 16 test cases, 3ms
	 * @reference https://leetcode.com/discuss/92609/three-line-java-solution
	 * @interpretation
	 */
	public int[] countBitsSample(int num) {
		int[] f = new int[num + 1];
		for (int i = 1; i <= num; ++i)
			f[i] = f[i >> 1] + (i & 1);
		return f;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountingBits cb = new CountingBits();
		int[] bits = cb.countBitsByHint(5);
		for (int i : bits)
			System.out.print(i + " ");
	}

}

package com.samy.leetcode.algorithm.medium;

public class UglyNumberII {

	/**
	 * 
	 * @param n
	 * @return
	 * 2016Äê3ÔÂ20ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/ugly-number-ii/
	 * @interpretation
	 */
	public int nthUglyNumberByHint(int n) {
	}

	private int min(int n1, int n2, int n3) {
		return n1 < n2 ? (n1 < n3 ? n1 : n3) : (n2 < n3 ? n2 : n3);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

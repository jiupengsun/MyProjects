package com.samy.leetcode.algorithm;

public class AddDigits {

	/**
	 * 
	 * @param num
	 * @return
	 * 2016Äê1ÔÂ11ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/add-digits/
	 * @reference https://en.wikipedia.org/wiki/Digital_root
	 */
	public static int addDigits(int num) {
		return 1 + (num - 1) % 9;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}

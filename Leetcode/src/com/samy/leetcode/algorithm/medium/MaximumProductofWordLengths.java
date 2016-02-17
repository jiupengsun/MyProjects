package com.samy.leetcode.algorithm.medium;

public class MaximumProductofWordLengths {

	/**
	 * 
	 * @param words
	 * @return
	 * 2016Äê2ÔÂ17ÈÕ
	 * @author Jiupeng
	 * @description 174 test cases, 32ms beats 80.28%
	 * @reference https://leetcode.com/problems/maximum-product-of-word-lengths/
	 * @interpretation
	 */
	public int maxProduct(String[] words) {
		int length = words.length, max = 0;
		int[] id = new int[length];
		for (int i = 0; i < length; ++i) {
			int tmp = 0;
			for (Character c : words[i].toCharArray()) {
				tmp |= (1 << (c - 'a'));
			}
			id[i] = tmp;
			for (int j = 0; j < i; ++j) {
				if ((tmp & id[j]) == 0) {
					int tmax = words[j].length() * words[i].length();
					max = max > tmax ? max : tmax;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

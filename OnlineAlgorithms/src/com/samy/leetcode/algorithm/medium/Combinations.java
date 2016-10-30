package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	/**
	 * 
	 * @param n
	 * @param k
	 * @return
	 * 2016Äê3ÔÂ4ÈÕ
	 * @author Jiupeng
	 * @description 26 test cases, 2ms beats 87.27%
	 * @reference https://leetcode.com/problems/combinations/
	 * @interpretation
	 */
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> collection = new ArrayList<List<Integer>>();
		int[] com = new int[k];
		int i = k - 1;
		while (i < k) {
			while (i > -1 && n > i) {
				com[i--] = n--;
			}
			if (i == -1) {
				List<Integer> col = new ArrayList<Integer>();
				for (int c : com)
					col.add(c);
				collection.add(col);
			}
			if (i == k - 1)
				break;
			n = com[++i] - 1;
		}
		return collection;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1, k = 1;
		Combinations com = new Combinations();
		com.combine(n, k);
	}

}

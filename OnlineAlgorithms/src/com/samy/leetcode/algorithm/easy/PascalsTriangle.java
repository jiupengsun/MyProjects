package com.samy.leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	/**
	 * 
	 * @param numRows
	 * @return
	 * 2016年1月16日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/pascals-triangle/
	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> pascal = new ArrayList<List<Integer>>();
		for (int i = 1; i <= numRows; ++i) {
			List<Integer> l = new ArrayList<Integer>();
			int mid = i >> 1, j = 0;
			for (; j <= mid; ++j)
				l.add(combination(i - 1, j));
			for (; j < i; ++j)
				l.add(l.get(i - j - 1));
			pascal.add(l);
		}
		return pascal;
	}

	private int combination(int n, int k) {
		k = Math.min(k, n - k);
		long numerator = 1, denominator = 1, i = 1;
		while (i <= k) {
			denominator *= n - k + i;
			numerator *= i++;
		}
		return (int) (denominator / numerator);
	}

	/**
	 * 
	 * @param numRows
	 * @return
	 * 2016年1月16日
	 * @author Jiupeng
	 * @description Faster, since no need to calculate the combination iteratively
	 * @reference https://leetcode.com/discuss/76173/1ms-java-solution-simple
	 */
	public List<List<Integer>> generateSample(int numRows) {
		List<List<Integer>> allrows = new ArrayList<>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for (int i = 0; i < numRows; i++) {
			row.add(1);
			for (int j = 1; j < i; j++) {
				List<Integer> p = allrows.get(i - 1);
				row.set(j, p.get(j - 1) + p.get(j));
			}
			row.set(i, 1);
			allrows.add(new ArrayList<Integer>(row));
		}
		return allrows;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalsTriangle p = new PascalsTriangle();
		List<List<Integer>> l = p.generate(30);
		for (int i = 0; i < l.size(); ++i) {
			System.out.println(l.get(i));
		}
	}

}

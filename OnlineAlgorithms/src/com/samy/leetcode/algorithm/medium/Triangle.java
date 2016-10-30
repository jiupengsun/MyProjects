package com.samy.leetcode.algorithm.medium;

import java.util.List;

public class Triangle {

	/**
	 * 
	 * @param triangle
	 * @return
	 * 2016Äê3ÔÂ28ÈÕ
	 * @author Jiupeng
	 * @description 43 test cases, 3ms beats 94.60%
	 * @reference https://leetcode.com/problems/triangle/
	 * @interpretation
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		int h = triangle.size(), min = Integer.MAX_VALUE;
		int[] dp = new int[h];
		dp[0] = triangle.get(0).get(0);
		for (int i = 1, j = 1; i < h; j = ++i) {
			List<Integer> list = triangle.get(i);
			dp[j] = list.get(j) + dp[j - 1];
			--j;
			while (j > 0) {
				dp[j] = list.get(j) + Math.min(dp[j], dp[j - 1]);
				--j;
			}
			dp[0] += list.get(0);
		}
		//return the min value
		for (int d : dp) {
			min = d < min ? d : min;
		}
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

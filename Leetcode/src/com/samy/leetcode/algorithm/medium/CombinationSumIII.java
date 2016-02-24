package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationSumIII {

	/**
	 * 
	 * @param k
	 * @param n
	 * @return
	 * 2016年2月24日
	 * @author Jiupeng
	 * @description 18 test cases, 3ms beats 4.39%
	 * @reference https://leetcode.com/problems/combination-sum-iii/
	 * @interpretation
	 */
	public List<List<Integer>> combinationSum3(int k, int n) {
		return helper(k, n, 9);
	}

	/**
	 * 
	 * @param k
	 * @param n
	 * @param end 1,2,3...,end
	 * @return
	 * 2016年2月24日
	 * @author Jiupeng
	 * @description
	 * @reference 
	 * @interpretation
	 */
	private List<List<Integer>> helper(int k, int n, int end) {
		List<List<Integer>> collection = new ArrayList<List<Integer>>();
		if (k == 1 && n <= end && n > 0) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(n);
			collection.add(list);
		} else if (k > 1 && end > 0) {
			end = end < n ? end : n;
			List<List<Integer>> colSub = helper(k - 1, n - end, end - 1);
			for (List<Integer> list : colSub) {
				list.add(end);
				collection.add(list);
			}
			colSub = helper(k, n, end - 1);
			collection.addAll(colSub);
		}

		return collection;
	}

	public List<List<Integer>> combinationSumIII2(int k, int n) {
		List<List<Integer>> collection = new ArrayList<List<Integer>>();
		Stack<Integer> stack = new Stack<Integer>();
		int end = 9, total = k;
		while (end > 0) {

			while (k > 1 && n > 0) {
				end = end < n ? end : n;
				stack.push(end);
				n -= end;
				--k;
				--end;
			}
			if (k == 1) {
				if (n > 0 && n <= end) {
					List<Integer> list = stack.subList(0, total - 1);
					list.add(0, end);
					collection.add(list);
				} else if (n < 0) {

				}

			}
		}

		return collection;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

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

	/**
	 * 
	 * @param k
	 * @param n
	 * @return
	 * 2016年2月25日
	 * @author Jiupeng
	 * @description 18 test cases, 1ms beats 51.49%
	 * @reference 
	 * @interpretation
	 */
	public List<List<Integer>> combinationSumIII2(int k, int n) {
		return helper2(k, n, 9);
	}

	private List<List<Integer>> helper2(int k, int n, int end) {
		List<List<Integer>> collection = new ArrayList<List<Integer>>();
		int[] sum = new int[k];
		while (true) {
			while (k > 0 && n > 0 && end > 0) {
				end = end < n ? end : n;
				sum[(k--) - 1] = end;
				n -= end--;
			}
			if (k == 0 && n == 0) {
				List<Integer> list = new ArrayList<Integer>();
				for (int i : sum)
					list.add(i);
				collection.add(list);
			}
			if (++k > sum.length)
				break;
			end = sum[k - 1];
			n += end--;
		}
		return collection;
	}

	private List<List<Integer>> helper2Enhanced(int k, int n, int end) {
		List<List<Integer>> collection = new ArrayList<List<Integer>>();
		int[] sum = new int[k];
		while (true) {
			//k * end - ((k - 1) * k >> 1): end + end-1 + end-2 +.. + end-(k-1)
			//(k + 1) * k >> 1: 1+2+3+...+k
			while (k > 0 && n <= k * end - ((k - 1) * k >> 1)
					&& n >= (k + 1) * k >> 1) {
				end = end < n ? end : n;
				sum[(k--) - 1] = end;
				n -= end--;
			}
			if (k == 0) {
				List<Integer> list = new ArrayList<Integer>();
				for (int i : sum)
					list.add(i);
				collection.add(list);
			}
			if (++k > sum.length)
				break;
			end = sum[k - 1];
			n += end--;
		}

		return collection;
	}

	/**
	 * 
	 * @param k
	 * @param n
	 * @return
	 * 2016年2月25日
	 * @author Jiupeng
	 * @description backTracking algorithm
	 * @reference 
	 * @interpretation https://leetcode.com/discuss/44514/simple-java-recursive-solution
	 */
	public List<List<Integer>> combinationSumIII3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		backtracking(new ArrayList<Integer>(), res, n, 1, k);
		return res;
	}

	private void backtracking(List<Integer> temp, List<List<Integer>> res,
			int tar, int k, int count) {
		if (tar == 0 && count == 0) {
			res.add(temp);
			return;
		}
		if (count == 0 || tar <= 0)
			return;

		for (int i = k; i <= 9; i++) {
			temp.add(i);
			backtracking(new ArrayList<Integer>(temp), res, tar - i, i + 1,
					count - 1);
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 3, n = 9;
		CombinationSumIII c = new CombinationSumIII();
		c.combinationSumIII3(k, n);
	}

}

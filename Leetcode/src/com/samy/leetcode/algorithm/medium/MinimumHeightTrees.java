package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

public class MinimumHeightTrees {

	/**
	 * 
	 * @param n
	 * @param edges
	 * @return
	 * 2016��4��9��
	 * @author Jiupeng
	 * @description 66 test cases, 130ms beats 14.65%
	 * @reference https://leetcode.com/problems/minimum-height-trees/
	 * @interpretation https://www.hrwhisper.me/leetcode-minimum-height-trees/
	 */
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> roots = new ArrayList<Integer>();
		int[] degree = new int[n];
		boolean[] leaves = new boolean[n];
		List<List<Integer>> links = new ArrayList<List<Integer>>(n);
		for (int i = 0; i < n; ++i)
			links.add(new ArrayList<Integer>());
		for (int[] i : edges) {
			degree[i[0]]++;
			degree[i[1]]++;
			links.get(i[0]).add(i[1]);
			links.get(i[1]).add(i[0]);
		}

		int l = n;
		while (n > 2) {
			for (int d = 0; d < l; ++d)
				if (degree[d] == 1)
					leaves[d] = true;

			for (int i = 0; i < l; ++i) {
				if (leaves[i]) {
					// remove leaves
					degree[i] = -1;
					List<Integer> set = links.get(i);
					for (int node : set)
						degree[node]--;
					--n;
					leaves[i] = false;
				}
			}
		}

		for (int i = 0; i < l; ++i)
			if (degree[i] > -1)
				roots.add(i);

		return roots;
	}

	/**
	 * 
	 * @param n
	 * @param edges
	 * @return
	 * 2016��4��9��
	 * @author Jiupeng
	 * @description not finished, O(n^2) time complexity, too slow
	 * @reference 
	 * @interpretation
	 */
	public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
		List<Integer> roots = new ArrayList<Integer>();
		int[][] height = new int[n][n];
		int[] maxHeight = new int[n];
		int minMaxHeight = Integer.MAX_VALUE;
		for (int i = 0; i < edges.length; ++i) {
			height[edges[i][0]][edges[i][1]] = 1;
			height[edges[i][1]][edges[i][0]] = 1;
		}

		fill(height, n);
		for (int i = 0; i < n; ++i) {
			int max = Integer.MIN_VALUE;
			for (int h : edges[i])
				max = Math.max(max, h);
			maxHeight[i] = max;
			minMaxHeight = Math.min(max, minMaxHeight);
		}

		for (int i = 0; i < n; ++i)
			if (maxHeight[i] == minMaxHeight)
				roots.add(i);

		return roots;
	}

	private void fill(int[][] height, int n) {
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				if (height[i][j] > 0) {

				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[][] edges = new int[][] { { 0, 3 }, { 1, 3 }, { 2, 3 }, { 4, 3 }, { 5, 4 } };

		MinimumHeightTrees mht = new MinimumHeightTrees();
		System.out.println(mht.findMinHeightTrees(n, edges));
	}

}

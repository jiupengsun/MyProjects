package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumHeightTrees {

	/**
	 * 
	 * @param n
	 * @param edges
	 * @return
	 * 2016年4月9日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/minimum-height-trees/
	 * @interpretation
	 */
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> roots = new ArrayList<Integer>();
		int[] degree = new int[n];
		Map<Integer, Set<Integer>> links = new HashMap<Integer, Set<Integer>>();
		for (int[] edge : edges) {
			degree[edge[0]]++;
			degree[edge[1]]++;
			Set<Integer> setX = links.get(edge[0]);
			if (setX == null)
				setX = new HashSet<Integer>();
			setX.add(edge[1]);
			links.put(edge[0], setX);

			Set<Integer> setY = links.get(edge[1]);
			if (setY == null)
				setY = new HashSet<Integer>();
			setY.add(edge[0]);
			links.put(edge[1], setY);
		}

		int l = n;
		while (n > 2) {
			for (int i = 0; i < l; ++i) {
				if (degree[i] == 1) {
					degree[i] = -1;
					Set<Integer> set = links.get(i);
					for (int node : set)
						degree[node]--;
					--n;
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
	 * 2016年4月9日
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

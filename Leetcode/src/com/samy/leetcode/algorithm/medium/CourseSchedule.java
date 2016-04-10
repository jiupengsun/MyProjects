package com.samy.leetcode.algorithm.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {

	/**
	 * 
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 * 2016Äê4ÔÂ9ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/course-schedule/
	 * @interpretation
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		boolean[] visited = new boolean[numCourses];
		Map<Integer, Set<Integer>> edges = generateEdges(numCourses, prerequisites);
		for (int i = 0; i < numCourses; ++i)
			if (!visited[i] && DFS(visited, i, i, edges))
				return false;
		return true;
	}

	private boolean DFS(boolean[] visited, int[] backVerticle, int now, Map<Integer, Set<Integer>> edges) {
		visited[now] = true;
		Set<Integer> links = edges.get(now);
		if (links == null)
			return false;
		for (int descent : links)
			if (descent == from || DFS(visited, from, descent, edges))
				return true;

		return false;
	}

	private Map<Integer, Set<Integer>> generateEdges(int numCourse, int[][] prerequisites) {
		Map<Integer, Set<Integer>> edges = new HashMap<Integer, Set<Integer>>();
		for (int i = 0, e = prerequisites.length; i < e; ++i) {
			Set<Integer> dependent = edges.get(prerequisites[i][0]);
			if (dependent == null)
				dependent = new HashSet<Integer>();
			dependent.add(prerequisites[i][1]);
			edges.put(prerequisites[i][0], dependent);
		}

		return edges;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCourses = 4;
		int[][] prerequisites = new int[][] { { 0, 1 }, { 3, 1 }, { 1, 3 }, { 3, 2 } };
		CourseSchedule cs = new CourseSchedule();
		System.out.println(cs.canFinish(numCourses, prerequisites));
	}

}

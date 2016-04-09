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
			if (!visited[i] && DFS(numCourses, visited, i, i, edges))
				return true;
		return false;
	}

	private boolean DFS(int numCourses, boolean[] visited, int from, int now, Map<Integer, Set<Integer>> edges) {
		Set<Integer> links = edges.get(now);
		if(links == null)
			
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

	}

}

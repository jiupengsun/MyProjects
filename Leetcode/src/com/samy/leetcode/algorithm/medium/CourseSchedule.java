package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {

	/**
	 * 
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 * 2016��4��9��
	 * @author Jiupeng
	 * @description 35 test cases, 33ms beats 30.49%
	 * @reference https://leetcode.com/problems/course-schedule/
	 * @interpretation
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		boolean[] visited = new boolean[numCourses];
		boolean[] backVerticles = new boolean[numCourses];
		Map<Integer, Set<Integer>> edges = generateEdges(numCourses, prerequisites);
		for (int i = 0; i < numCourses; ++i)
			if (!visited[i] && DFS(visited, backVerticles, i, edges))
				return false;
		return true;
	}

	private boolean DFS(boolean[] visited, boolean[] backVerticles, int now, Map<Integer, Set<Integer>> edges) {
		visited[now] = true;
		Set<Integer> links = edges.get(now);
		if (links == null)
			return false;
		for (int descent : links) {
			if (backVerticles[now])
				return true;
			backVerticles[now] = true;
			if (DFS(visited, backVerticles, descent, edges))
				return true;
			backVerticles[now] = false;
		}

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

	/**
	 * 
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 * Apr 10, 2016
	 * @author Jiupeng
	 * @description 35 test cases, 24ms beats 47.84%
	 * @reference 
	 * @interpretation
	 */
	public boolean canFinish2(int numCourses, int[][] prerequisites) {
		boolean[] visited = new boolean[numCourses];
		boolean[] backVerticles = new boolean[numCourses];
		List<Set<Integer>> edges = generateEdgesList(numCourses, prerequisites);
		for (int i = 0; i < numCourses; ++i) {
			if (!visited[i] && DFS(visited, backVerticles, i, edges))
				return false;
		}
		return true;
	}

	private boolean DFS(boolean[] visited, boolean[] backVerticles, int node, List<Set<Integer>> edges) {
		visited[node] = true;
		Set<Integer> links = edges.get(node);
		if (links.size() == 0)
			return false;
		if (backVerticles[node])
			return true;
		backVerticles[node] = true;
		for (int l : links)
			if (DFS(visited, backVerticles, l, edges))
				return true;
		backVerticles[node] = false;
		return false;
	}

	private List<Set<Integer>> generateEdgesList(int numCourses, int[][] prerequisites) {
		List<Set<Integer>> edges = new ArrayList<Set<Integer>>(numCourses);
		for (int i = 0; i < numCourses; ++i)
			edges.add(new HashSet<Integer>());
		for (int[] i : prerequisites)
			edges.get(i[0]).add(i[1]);
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

package com.samy.leetcode.algorithm.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CourseScheduleII {

  public static void main(String[] args) {
    CourseScheduleII c = new CourseScheduleII();
    int[] sort = c.findOrder(2, new int[][]{{1, 0}});
    for (int s : sort)
      System.out.print(s + " ");
  }

  /**
   * https://leetcode.com/problems/course-schedule-ii/description/
   *
   * @param numCourses
   * @param prerequisites
   * @return
   */
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    boolean[] visit = new boolean[numCourses];
    boolean[] path = new boolean[numCourses];
    List<Integer> sort = new LinkedList<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int[] p : prerequisites) {
      List<Integer> list = graph.getOrDefault(p[1], new LinkedList<>());
      list.add(p[0]);
      graph.put(p[1], list);
    }

    for (int i = 0; i < numCourses; ++i) {
      // find an unvisit node
      if (!visit[i] && hasCircle(visit, path, graph, i, sort)) {
        return new int[]{};
      }
    }

    int[] result = new int[numCourses];
    int i = 0;
    for (int c : sort)
      result[i++] = c;
    return result;
  }

  private boolean hasCircle(boolean[] visit, boolean[] path, Map<Integer, List<Integer>> graph, int node, List<Integer> sort) {
    if (visit[node])
      return false;
    if (path[node])
      return true;
    List<Integer> edges = graph.get(node);
    if (edges != null) {
      for (int e : edges) {
        path[node] = true;
        if (hasCircle(visit, path, graph, e, sort))
          return true;
        path[node] = false;
      }
    }
    visit[node] = true;
    sort.add(0, node);
    return false;
  }
}

package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphValidTree {

  public static void main(String[] args) {
    GraphValidTree gv = new GraphValidTree();
    gv.validTree(5, new int[][]{
      {0, 1}, {0, 2}, {2, 3}, {2, 4}
    });
  }

  /**
   * https://leetcode.com/problems/graph-valid-tree/description/
   *
   * @param n
   * @param edges
   * @return
   */
  public boolean validTree(int n, int[][] edges) {
    int[] visit = new int[n];
    Map<Integer, List<Integer>> edgeMap = new HashMap<>();
    for (int[] e : edges) {
      List<Integer> list = edgeMap.getOrDefault(e[0], new ArrayList<>());
      list.add(e[1]);
      edgeMap.put(e[0], list);
      list = edgeMap.getOrDefault(e[1], new ArrayList<>());
      list.add(e[0]);
      edgeMap.put(e[1], list);
    }
    for (int i = 0; i < n; ++i) {
      if (visit[i] == 0 && hasCycle(visit, i, -1, edgeMap))
        return false;
    }
    return true;
  }

  private boolean hasCycle(int[] visit, int v, int parent, Map<Integer, List<Integer>> edges) {
    if (visit[v] < 0)
      return false;
    visit[v] = 1;
    List<Integer> list = edges.get(v);
    if (list == null || list.size() == 0) {
      visit[v] = -1;
      return false;
    }
    for (int e : list) {
      if (e == parent)
        continue;
      if (visit[e] == 0) {
        visit[e] = 1;
        if (hasCycle(visit, e, v, edges))
          return true;
        visit[e] = 0;
      }
    }
    visit[v] = -1;
    return false;
  }
}

package com.samy.leetcode.algorithm.hard;

import java.util.*;


/**
 * <a href="https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/">Sort Items by Groups Respecting Dependencies</a>
 * create virtual node for each group so only need to sort once,
 * {@see} <a href="https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/discuss/402945/C%2B%2B-with-picture-single-level-topological-sort">discussion</a>
 */
public class SortItemsbyGroupsRespectingDependencies {
  private static final int PERMANNENT_VISIT = 1;
  private static final int TEMPORARY_VISIT = -1;

  public static void main(String[] args) {
    SortItemsbyGroupsRespectingDependencies si = new SortItemsbyGroupsRespectingDependencies();
    List<List<Integer>> edges = new ArrayList<>();
    int n = 8, m = 2;
    int[] groups = new int[]{-1, -1, 1, 0, 0, 1, 0, -1};
    for (int i = 0; i < n; i++) {
      edges.add(new ArrayList<>());
    }
    edges.get(1).add(6);
    edges.get(2).add(5);
    edges.get(3).add(6);
    edges.get(4).add(3);
    edges.get(4).add(6);
    int[] result = si.sortItems(n, m, groups, edges);
    for (int r : result) {
      System.out.print(String.valueOf(r) + ' ');
    }
    System.out.println();
  }

  public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
    Map<Integer, Set<Integer>> graph = generateGraph(n, group, beforeItems);
    List<Integer> sortedList = topoSort(n, m, graph);
    if (sortedList == null || sortedList.isEmpty()) {
      return new int[0];
    }
    int[] result = new int[n];
    int i = 0;
    for (int r : sortedList) {
      if (r < n) {
        result[i++] = r;
      }
    }
    return result;
  }

  private Map<Integer, Set<Integer>> generateGraph(int n, int[] group, List<List<Integer>> beforeItems) {
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int e = 0; e < n; ++e) {
      if (group[e] == -1 && beforeItems.get(e).isEmpty()) {
        // if e isn't in any group and e doesn't have any dependency, then no edge
        continue;
      }
      if (group[e] > -1) {
        // e.g. if e is in group 1, and n is 5
        // then 7, 8
        int virtualInboundGroup = n + (group[e] << 1);
        int virtualOutboundGroup = virtualInboundGroup + 1;
        Set<Integer> inboundEdges = graph.computeIfAbsent(virtualInboundGroup, k -> new HashSet<>());
        Set<Integer> outboundEdges = graph.computeIfAbsent(virtualOutboundGroup, k -> new HashSet<>());
        Set<Integer> currentEdges = graph.computeIfAbsent(e, k -> new HashSet<>());
        inboundEdges.add(e);
        currentEdges.add(virtualOutboundGroup);
        for (int originalEdge : beforeItems.get(e)) {
          if (group[originalEdge] == group[e]) {
            // same group
            currentEdges.add(originalEdge);
          } else {
            // different group
            // if originalEdge belongs to a group, then add the virtual inbound group number
            // otherwise if doesn't belong any group, no virtual group number needed
            outboundEdges.add(
              group[originalEdge] > -1 ? n + (group[originalEdge] << 1) : originalEdge
            );
          }
        }
      } else {
        // e isn't in any group
        Set<Integer> edges = graph.computeIfAbsent(e, k -> new HashSet<>());
        for (int currentEdge : beforeItems.get(e)) {
          edges.add(group[currentEdge] > -1 ? n + (group[currentEdge] << 1) : currentEdge);
        }
      }
    }
    return graph;
  }

  private List<Integer> topoSort(int n, int m, Map<Integer, Set<Integer>> graph) {
    int[] visited = new int[n + (m << 1)];
    List<Integer> sortedList = new ArrayList<>();
    // sort group firstly
    for (int v = n; v < visited.length; ++v) {
      if (visited[v] == 0 && !helper(v, graph, visited, sortedList)) {
        return null;
      }
    }
    // sort the rest
    for (int v = 0; v < n; ++v) {
      if (visited[v] == 0 && !helper(v, graph, visited, sortedList)) {
        return null;
      }
    }
    return sortedList;
  }

  /**
   * sort, and return true if no circle
   */
  private boolean helper(int node, Map<Integer, Set<Integer>> graph, int[] visited, List<Integer> sortedList) {
    if (visited[node] == TEMPORARY_VISIT) {
      return false;
    }
    if (visited[node] == PERMANNENT_VISIT) {
      return true;
    }
    visited[node] = TEMPORARY_VISIT;
    if (graph.containsKey(node)) {
      for (int edge : graph.get(node)) {
        if (!helper(edge, graph, visited, sortedList)) {
          return false;
        }
      }
    }
    sortedList.add(node);
    visited[node] = PERMANNENT_VISIT;
    return true;
  }
}

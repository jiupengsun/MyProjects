package com.samy.leetcode.algorithm.hard;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/critical-connections-in-a-network/">Critical Connections in a Network</a>
 * Similar idea with Tarjan's algorithm, refer to
 * <a href"https://leetcode.com/problems/critical-connections-in-a-network/discuss/399827/Java-DFS-Solution-similar-to-Tarjan-maybe-easier-to-understand">Discuss</a>
 */
public class CriticalConnectionsinaNetwork {
  private int count = 1;

  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (List<Integer> l : connections) {
      List<Integer> e1 = graph.computeIfAbsent(l.get(0), k -> new ArrayList<>());
      e1.add(l.get(1));
      List<Integer> e2 = graph.computeIfAbsent(l.get(1), k -> new ArrayList<>());
      e2.add(l.get(0));
    }
    count = 0;
    int[] min = new int[n];
    List<List<Integer>> results = new ArrayList<>();
    helper(0, -1, min, graph, results);
    return results;
  }

  private int helper(int node, int parent, int[] min, Map<Integer, List<Integer>> graph, List<List<Integer>> results) {
    min[node] = ++count;
    int minCount = Integer.MAX_VALUE;
    for (int edge : graph.get(node)) {
      if (edge == parent) {
        continue;
      }
      if (min[edge] > 0) {
        // has visit, check its number
        minCount = Math.min(minCount, min[edge]);
      } else {
        // not visit
        int siblingCount = helper(edge, node, min, graph, results);
        if (siblingCount > min[node]) {
          // no loop for this edge
          results.add(Arrays.asList(node, edge));
        }
        minCount = Math.min(minCount, min[edge]);
      }
    }
    min[node] = Math.min(minCount, min[node]);
    return min[node];
  }

  public static void main(String[] args) {
    CriticalConnectionsinaNetwork c = new CriticalConnectionsinaNetwork();
    List<List<Integer>> connections = new ArrayList<>();
    connections.add(Arrays.asList(0, 1));
    connections.add(Arrays.asList(1, 2));
    connections.add(Arrays.asList(2, 0));
    connections.add(Arrays.asList(1, 3));
    connections.add(Arrays.asList(3, 4));
    connections.add(Arrays.asList(4, 5));
    connections.add(Arrays.asList(5, 3));
    List<List<Integer>> results = c.criticalConnections(6, connections);
    for (List<Integer> l : results) {
      System.out.print(String.format("%d %d", l.get(0), l.get(1)));
    }
    System.out.println();
  }
}

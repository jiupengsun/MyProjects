package com.samy.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface StronglyConnectedComponent {

  /**
   * Get strongly connected components.
   * {@see} <a href="https://en.wikipedia.org/wiki/Strongly_connected_component">Wikipedia</a>
   * @param n number of node, starts from 0
   * @param connections directed graph, [1, 3] represents the edge from 1 to 3, no duplicate connections
   * @return List of SCCs
   */
  public List<List<Integer>> getSCCs(int n, List<List<Integer>> connections);

  /**
   * convert a list of connections to graph, which is represented by Map
   * @param connections
   * @return
   */
  default Map<Integer, List<Integer>> convertToGraph(List<List<Integer>> connections) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (List<Integer> edge : connections) {
      List<Integer> to = graph.computeIfAbsent(edge.get(0), k -> new ArrayList<>());
      to.add(edge.get(1));
    }
    return graph;
  }
}

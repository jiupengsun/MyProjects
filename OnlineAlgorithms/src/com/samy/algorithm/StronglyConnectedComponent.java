package com.samy.algorithm;

import java.util.List;

public interface StronglyConnectedComponent {

  /**
   * Get strongly connected components.
   * {@see} <a href="https://en.wikipedia.org/wiki/Strongly_connected_component">Wikipedia</a>
   * @param n number of node, starts from 0
   * @param connections directed graph, [1, 3] represents the edge from 1 to 3, no duplicate connections
   * @return List of SCCs
   */
  public List<List<Integer>> getSCCs(int n, List<List<Integer>> connections);
}

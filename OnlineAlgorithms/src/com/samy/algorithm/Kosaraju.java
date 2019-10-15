package com.samy.algorithm;

import java.util.*;

/**
 * <a href="https://www.geeksforgeeks.org/strongly-connected-components/">Kosaraju’s algorithm</a>
 */
public class Kosaraju implements StronglyConnectedComponent {
  @Override
  public List<List<Integer>> getSCCs(int n, List<List<Integer>> connections) {
    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[n];
    Map<Integer, List<Integer>> graph = convertToGraph(connections);
    // DFS
    DFSHelper(0, visited, stack, graph);
    // reverse the direction of graph
    Map<Integer, List<Integer>> reverseConnections = reverseGraph(graph);
    // DFS with the order of stack
    visited = new boolean[n];
    List<List<Integer>> sccs = new ArrayList<>();
    getSCCs(stack, visited, reverseConnections, sccs);
    return sccs;
  }

  private void getSCCs(Stack<Integer> stack, boolean[] visited, Map<Integer, List<Integer>> graph, List<List<Integer>> sccs) {
    while(!stack.isEmpty()) {
      int node = stack.pop();
      if (!visited[node]) {
        List<Integer> scc = new ArrayList<>();
        Stack<Integer> tmpStack = new Stack<>();
        tmpStack.push(node);
        while (!tmpStack.isEmpty()) {
          int from = tmpStack.pop();
          scc.add(from);
          visited[from] = true;
          if (graph.containsKey(from)) {
            for (int edge : graph.get(from)) {
              if (!visited[edge]) {
                tmpStack.push(edge);
              }
            }
          }
        }
        sccs.add(scc);
      }
    }
  }

  private Map<Integer, List<Integer>> reverseGraph(Map<Integer, List<Integer>> graph) {
    Map<Integer, List<Integer>> revertedGraph = new HashMap<>();
    for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
      int from = entry.getKey();
      List<Integer> tos = entry.getValue();
      for (int to : tos) {
        List<Integer> l = revertedGraph.computeIfAbsent(to, k -> new ArrayList<>());
        l.add(from);
      }
    }
    return revertedGraph;
  }

  private void DFSHelper(int node, boolean[] visited, Stack<Integer> stack, Map<Integer, List<Integer>> graph) {
    visited[node] = true;
    if (graph.containsKey(node)) {
      for (int edge : graph.get(node)) {
        if (!visited[edge]) {
          DFSHelper(edge, visited, stack, graph);
        }
      }
    }
    stack.push(node);
  }

  private Map<Integer, List<Integer>> convertToGraph(List<List<Integer>> connections) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (List<Integer> edge : connections) {
      List<Integer> to = graph.computeIfAbsent(edge.get(0), k -> new ArrayList<>());
      to.add(edge.get(1));
    }
    return graph;
  }

  public static void main(String[] args) {
    Kosaraju k = new Kosaraju();
    List<List<Integer>> connections = new ArrayList<>();
    connections.add(Arrays.asList(0, 1));
    connections.add(Arrays.asList(1, 2));
    connections.add(Arrays.asList(2, 0));
    connections.add(Arrays.asList(1, 3));
    connections.add(Arrays.asList(3, 4));
    connections.add(Arrays.asList(4, 5));
    connections.add(Arrays.asList(5, 3));
    connections.add(Arrays.asList(4, 6));
    List<List<Integer>> results = k.getSCCs(7, connections);
    for (List<Integer> l : results) {
      for (int e : l) {
        System.out.print(String.valueOf(e) + ' ');
      }
      System.out.println();
    }
  }
}

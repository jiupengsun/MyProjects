package com.samy.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;


/**
 * <a href="https://www.youtube.com/watch?v=TyWtx7q2D7Y">Tarjan's algorithm</a>
 * the intuition of Tarjan is, for each SCC, if we start a random node to do the DFS, when we traverse back to that node,
 * we must have visit all of the nodes in the SCC, and all of them will share a same minimum id. The key element in the
 * Tarjan is we use a stack to memorize all of the nodes in one DFS, and when we update the low-link, we need to check
 * if the target node is on the stack, if yes then we use its low-link id, otherwise it means the target node belongs
 * to another SCC, so we don't take its low-link id.
 */
public class Tarjan implements StronglyConnectedComponent {
  private int id = 1;

  @Override
  public List<List<Integer>> getSCCs(int n, List<List<Integer>> connections) {
    Map<Integer, List<Integer>> graph = convertToGraph(connections);
    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[n];
    boolean[] isOnStack = new boolean[n];
    int[] low = new int[n];
    List<List<Integer>> results = new ArrayList<>();
    id = 1;
    for (int i=0; i<n; ++i) {
      if (!visited[i]) {
        DFSHelper(i, visited, isOnStack, low, stack, graph, results);
      }
    }
    return results;
  }

  private int DFSHelper(int node, boolean[] visited, boolean[] isOnStack, int[] low, Stack<Integer> stack, Map<Integer, List<Integer>> graph, List<List<Integer>> results) {
    visited[node] = true;
    int currentId = id++;
    low[node] = currentId;
    stack.push(node);
    isOnStack[node] = true;
    if (graph.containsKey(node)) {
      for (int edge : graph.get(node)) {
        int min = Integer.MAX_VALUE;
        if (visited[edge]) {
          min = Math.min(min, low[edge]);
        } else {
          min = Math.min(min, DFSHelper(edge, visited, isOnStack, low, stack, graph, results));
        }
        if (isOnStack[edge]) {
          low[node] = Math.min(low[node], min);
        }
      }
    }
    if (low[node] == currentId) {
      // find scc
      List<Integer> list = new ArrayList<>();
      int top = -1;
      do {
        top = stack.pop();
        list.add(top);
        isOnStack[top] = false;
      } while (top != node);
      results.add(list);
    }
    return low[node];
  }

  public static void main(String[] args) {
    Tarjan t = new Tarjan();
    List<List<Integer>> connections = new ArrayList<>();
    connections.add(Arrays.asList(0, 1));
    connections.add(Arrays.asList(1, 2));
    connections.add(Arrays.asList(2, 0));
    connections.add(Arrays.asList(1, 3));
    connections.add(Arrays.asList(3, 4));
    connections.add(Arrays.asList(4, 5));
    connections.add(Arrays.asList(5, 3));
    connections.add(Arrays.asList(4, 6));
    List<List<Integer>> results = t.getSCCs(7, connections);
    for (List<Integer> l : results) {
      for (int e : l) {
        System.out.print(String.valueOf(e) + ' ');
      }
      System.out.println();
    }
  }
}

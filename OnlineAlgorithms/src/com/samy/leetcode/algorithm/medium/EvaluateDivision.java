package com.samy.leetcode.algorithm.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/evaluate-division/description/
 */
public class EvaluateDivision {
  /**
   * store edges for each node
   */
  class Edges{
    List<Double> values = new ArrayList<>();
    List<String> nodes = new ArrayList<>();
  }

  /**
   * represents node and current result
   */
  class Pair {
    String node;
    double res;

    Pair(String n, double r) {
      node = n;
      res = r;
    }
  }

  public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    Map<String, Edges> map = new HashMap<>();
    for(int i=0; i<equations.length; ++i) {
      String dividend = equations[i][0];
      String divisor = equations[i][1];
      Edges e = map.get(dividend);
      if(e == null) {
        e = new Edges();
        map.put(dividend, e);
      }
      e.values.add(values[i]);
      e.nodes.add(divisor);
      // add reverse
      e = map.get(divisor);
      if(e == null) {
        e = new Edges();
        map.put(divisor, e);
      }
      e.values.add(1 / values[i]);
      e.nodes.add(dividend);
    }

    double[] result = new double[queries.length];
    for(int i=0; i<queries.length; ++i) {
      result[i] = cal(map, queries[i]);
    }
    return result;
  }

  private double cal(Map<String, Edges> graph, String[] query) {
    String dividend = query[0];
    String divisor = query[1];
    if(!graph.containsKey(dividend) || !graph.containsKey(divisor))
      return -1d;
    if(dividend.equals(divisor))
      return 1d;
    // DFS
    Deque<Pair> stack = new LinkedList<>();
    stack.push(new Pair(dividend, 1));
    Set<String> visit = new HashSet<>();
    while(!stack.isEmpty()) {
      Pair p = stack.pop();
      visit.add(p.node);
      if(p.node.equals(divisor)) {
        return p.res;
      }
      Edges e = graph.get(p.node);
      for(int i=0; i<e.nodes.size(); ++i) {
        String next = e.nodes.get(i);
        if(!visit.contains(next)) {
          double value = e.values.get(i);
          Pair next_p = new Pair(next, p.res * value);
          stack.push(next_p);
        }
      }
    }
    return -1d;
  }
}

package com.samy.leetcode.algorithm.medium;

import java.util.HashMap;
import java.util.Map;

public class RedundantConnection {
  /**
   * https://leetcode.com/problems/redundant-connection/description/
   *
   * @param edges
   * @return
   */
  public int[] findRedundantConnection(int[][] edges) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int[] e : edges) {
      int f1 = find(map, e[0]);
      int f2 = find(map, e[1]);
      if (f1 == f2)
        return e;
      // union
      map.put(f1, f2);
    }
    return new int[]{};
  }

  private int find(Map<Integer, Integer> map, int v) {
    if (!map.containsKey(v)) {
      map.put(v, 0);
      return v;
    }
    while (map.get(v) > 0) {
      int n = map.get(map.get(v));
      if (n > 0)
        map.put(v, n);
      v = map.get(v);
    }
    return v;
  }
}

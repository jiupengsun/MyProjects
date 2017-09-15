package com.samy.leetcode.algorithm.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/number-of-islands-ii/
 * Created by samy on 11/14/16.
 */
public class NumberofIslandsII {
  int[][] directions = new int[][]{
    {-1, 0}, {0, -1}, {1, 0}, {0, 1}
  };

  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    int[] set = new int[m * n];
    Arrays.fill(set, -1);
    List<Integer> list = new ArrayList<>();
    int count = 0;
    for(int[] p: positions) {
      int index = p[0]*n + p[1];
      set[index] = index;
      ++count;
      for(int k=0; k<4; ++k) {
        // four directions
        int i = Math.max(0, Math.min(p[0]+directions[k][0], m-1));
        int j = Math.max(0, Math.min(p[1]+directions[k][1], n-1));
        if(i==p[0] && j==p[1])
          continue;
        int nindex = i*n + j;
        if(set[nindex] >= 0) {
          // has island
          int source = find(set, nindex);
          if(source != index) {
            --count;
            // union
            set[source] = index;
          }
        }
      }
      list.add(count);
    }
    return list;
  }

  private int find(int[] set, int index) {
    while(set[index] != index) {
      // MAGIC !!!!! improve the efficiency
      set[index] = set[set[index]];
      index = set[index];
    }
    return index;
  }

}
